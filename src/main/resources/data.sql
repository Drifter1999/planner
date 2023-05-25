DROP SEQUENCE PARTY_SEQ;
CREATE SEQUENCE PARTY_SEQ START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SCHEDULE_SEQ;
CREATE SEQUENCE SCHEDULE_SEQ START WITH 1 INCREMENT BY 1;

DROP SEQUENCE SHARED_SCHEDULE_SEQ;
CREATE SEQUENCE SHARED_SCHEDULE_SEQ START WITH 1 INCREMENT BY 1;

insert into MEMBER_STATE values (1, 'using');
insert into MEMBER_STATE values (2, 'deactivate');
insert into MEMBER_STATE values (3, 'locked');

insert into MEMBERS
    (MEMBER_ID, MEMBER_PW, MEMBER_NAME, MEMBER_PHONE, MEMBER_EMAIL, MEMBER_BIRTH, MEMBER_ROLE, MEMBER_GENDER ,STATE_ID)
VALUES
    ('test01', 'test1234!', '테스터', '01022221111', 'tester@kic.com', '010101', 'ROLE_USER', 'Male', 1);

INSERT INTO BLOG
    (BLOG_ID, BLOG_CONTENT, BLOG_TITLE, UPDATE_DATE, MEMBER_ID, IMG_NAME, IMG_PATH)
values
    (1, '<span style="color: rgb(34, 34, 34); font-family: &quot;Malgun Gothic&quot;, 돋움, dotum, &quot;Apple SD Gothic Neo&quot;, &quot;Helvetica Neue&quot;, Helvetica, Roboto, Arial, sans-serif; font-size: 22px;"><span style="font-size: 22px; font-family: 궁서;">사람도 동물도 힐링하는 곳&nbsp;‘순천만정원박람회</span>’</span><br style="box-sizing: inherit; color: rgb(34, 34, 34); font-family: &quot;Malgun Gothic&quot;, 돋움, dotum, &quot;Apple SD Gothic Neo&quot;, &quot;Helvetica Neue&quot;, Helvetica, Roboto, Arial, sans-serif; font-size: 16px;"><br style="box-sizing: inherit; color: rgb(34, 34, 34); font-family: &quot;Malgun Gothic&quot;, 돋움, dotum, &quot;Apple SD Gothic Neo&quot;, &quot;Helvetica Neue&quot;, Helvetica, Roboto, Arial, sans-serif; font-size: 16px;"><span style="color: rgb(34, 34, 34); font-family: &quot;Malgun Gothic&quot;, 돋움, dotum, &quot;Apple SD Gothic Neo&quot;, &quot;Helvetica Neue&quot;, Helvetica, Roboto, Arial, sans-serif; font-size: 16px;">자연이 만든 최고의 경관 ‘순천만’. 이곳에서 10월 말까지 </span><span style="font-family: &quot;Malgun Gothic&quot;, 돋움, dotum, &quot;Apple SD Gothic Neo&quot;, &quot;Helvetica Neue&quot;, Helvetica, Roboto, Arial, sans-serif; font-size: 16px; background-color: rgb(255, 255, 0);"><font color="#000000">‘2023순천만국제정원박람회</font></span><span style="color: rgb(34, 34, 34); font-family: &quot;Malgun Gothic&quot;, 돋움, dotum, &quot;Apple SD Gothic Neo&quot;, &quot;Helvetica Neue&quot;, Helvetica, Roboto, Arial, sans-serif; font-size: 16px;">’가 펼쳐져 다채로운 매력 즐기는 여행을 만끽할 수 있다.</span><br style="box-sizing: inherit; color: rgb(34, 34, 34); font-family: &quot;Malgun Gothic&quot;, 돋움, dotum, &quot;Apple SD Gothic Neo&quot;, &quot;Helvetica Neue&quot;, Helvetica, Roboto, Arial, sans-serif; font-size: 16px;"><br style="box-sizing: inherit; color: rgb(34, 34, 34); font-family: &quot;Malgun Gothic&quot;, 돋움, dotum, &quot;Apple SD Gothic Neo&quot;, &quot;Helvetica Neue&quot;, Helvetica, Roboto, Arial, sans-serif; font-size: 16px;"><br style="box-sizing: inherit; color: rgb(34, 34, 34); font-family: &quot;Malgun Gothic&quot;, 돋움, dotum, &quot;Apple SD Gothic Neo&quot;, &quot;Helvetica Neue&quot;, Helvetica, Roboto, Arial, sans-serif; font-size: 16px;"><br>', '반려동물 동반 추천 여행지 ‘순천’', '2023-05-01', 'test01', 'suncheonman.jpg', '/files/suncheonman.jpg');