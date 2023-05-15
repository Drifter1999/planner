<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>

<%
    String userId = request.getParameter("userId");

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String result = "";

    try {
        // 데이터베이스 연결 설정
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:9090/planner";
        String user = "planner";
        String password = "planner";
        conn = DriverManager.getConnection(url, user, password);

        // 아이디 중복체크
        pstmt = conn.prepareStatement("SELECT * FROM users WHERE user_id = 모르겠음 ㅠㅠ");
        pstmt.setString(1, userId);
        rs = pstmt.executeQuery();
        if(rs.next()) {
            result = "unavailable";
        } else {
            result = "available";
        }

    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // 데이터베이스 연결 해제
        if(rs != null) try {rs.close();} catch(SQLException ex) {}
        if(pstmt != null) try {pstmt.close();} catch(SQLException ex) {}
        if(conn != null) try {conn.close();} catch(SQLException ex) {}

        // 중복 체크 결과 전송
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(result);
    }
%>