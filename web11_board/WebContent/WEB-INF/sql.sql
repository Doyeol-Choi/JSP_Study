DROP TABLE boardTbl;

CREATE TABLE boardTbl (num number(5) PRIMARY KEY,
                    name VARCHAR2(30),
                    email VARCHAR2(30),
                    pass VARCHAR2(30),
                    title VARCHAR2(50),
                    content VARCHAR2(1000),
                    readCount number(4) DEFAULT 0,
                    writeDate DATE DEFAULT sysdate);

DROP SEQUENCE board_seq;

CREATE SEQUENCE board_seq NOCACHE;

INSERT INTO boardTbl(num, name, email, pass, title, content) VALUES(board_seq.nextval, '홍길동', 'hong@naver.com', 1234, '첫 방문', '왔다 갑니다.'); 
INSERT INTO boardTbl(num, name, email, pass, title, content) VALUES(board_seq.nextval, '김길동', 'kim@naver.com', 1234, '반가워요', '대출은 000-0000-0000');
INSERT INTO boardTbl(num, name, email, pass, title, content) VALUES(board_seq.nextval, '고길동', 'ko@naver.com', 1234, '안녕하세요', '건강하시죠??');
INSERT INTO boardTbl(num, name, email, pass, title, content) VALUES(board_seq.nextval, '홍길동', 'hong@naver.com', 1234, '두번째 방문', '이제 이건 제껍니다.');
INSERT INTO boardTbl(num, name, email, pass, title, content) VALUES(board_seq.nextval, '박길동', 'park@naver.com', 1234, '밥은 먹었냐?', '친구야! 밥먹으러 가자!');

SELECT * FROM boardTbl;

commit;