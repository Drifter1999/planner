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