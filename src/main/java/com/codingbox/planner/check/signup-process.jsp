<%@ page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>회원가입 처리</title>
</head>
<body>
<h1>회원가입 처리</h1>
<%
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");

        String url = "jdbc:mysql://localhost:9090/signup";
        String username = "planner";
        String dbPassword = "planner";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean isDuplicate = false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, dbPassword);

            //아이디 중복 체크
            pstmt = conn.prepareStatement("SELECT COUNT(*) AS cnt FROM users WHERE id=?");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getInt("cnt") > 0) {
                    isDuplicate = true;
                }
            }

            // 이메일 중복 체크
            pstmt = conn.prepareStatement("SELECT COUNT(*) AS cnt FROM users WHERE email=?");
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getInt("cnt") > 0) {
                    isDuplicate = true;
                }
            }

            // 실패하면 이거 뜸
            if (isDuplicate) {
                System.out.println("<p>이미 사용 중인 아이디 또는 이메일입니다. 다른 아이디 또는 이메일을 입력해주세요.</p>");
            } else {
             //  성공하면 이거 뜸
                pstmt = conn.prepareStatement("INSERT INTO users (id, password, email, name) VALUES (?, ?, ?, ?)");
                pstmt.setString(1, id);
                pstmt.setString(2, password);
                pstmt.setString(3, email);
                pstmt.setString(4, name);
                pstmt.executeUpdate();
                System.out.println("<p>회원가입이 완료되었습니다.</p>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
%>
</body>
</html>