CREATE TABLE course_tbl (
                        id VARCHAR2(5) PRIMARY KEY,
                        name VARCHAR2(40),
                        credit NUMBER(6),
                        lecturer NUMBER(6),
                        week NUMBER(2),
                        start_hour NUMBER(4),
                        end_hour NUMBER(4));
                        
INSERT INTO course_tbl VALUES(10001, '���α׷���', 2, 1, 1, 0900, 1100);
INSERT INTO course_tbl VALUES(10002, '��ü���� ���α׷���', 2, 2, 2, 0900, 1200);
INSERT INTO course_tbl VALUES(10003, '�ڷᱸ��', 3, 4, 3, 0900, 1200);
INSERT INTO course_tbl VALUES(10004, '�˰���', 3, 4, 4, 0900, 1200);
INSERT INTO course_tbl VALUES(20001, '�ý��� ���α׷���', 2, 5, 1, 1300, 1600);
INSERT INTO course_tbl VALUES(20002, '�ü��', 3, 5, 3, 1500, 1800);
INSERT INTO course_tbl VALUES(20003, '���丶Ÿ�� �����Ϸ�', 3, 5, 3, 1330, 1630);
INSERT INTO course_tbl VALUES(30001, '����Ʈ���� ����', 2, 3, 4, 1300, 1530);
INSERT INTO course_tbl VALUES(30002, '�ý��� �м� �� ����', 3, 3, 5, 0900, 1200);
INSERT INTO course_tbl VALUES(40001, '�����ͺ��̽�', 3, 2, 5, 1300, 1600);

SELECT * FROM course_tbl;

CREATE TABLE lecturer_tbl (
                        idx NUMBER(6) PRIMARY KEY,
                        name VARCHAR2(10),
                        major VARCHAR2(30),
                        field VARCHAR2(30));

CREATE SEQUENCE lecturer_seq NOCACHE;

INSERT INTO lecturer_tbl VALUES(lecturer_seq.nextval, '�豳��', '����Ʈ���� ����', '�˰���');
INSERT INTO lecturer_tbl VALUES(lecturer_seq.nextval, '�̱���', '����Ʈ���� ����', '�ΰ�����');
INSERT INTO lecturer_tbl VALUES(lecturer_seq.nextval, '�ڱ���', '����Ʈ���� ����', '����Ʈ���� ����');
INSERT INTO lecturer_tbl VALUES(lecturer_seq.nextval, '������', '����Ʈ���� ����', '�˰���');
INSERT INTO lecturer_tbl VALUES(lecturer_seq.nextval, '�ֱ���', '������ǻ�� ����', '�Ӻ���� �ý���');
INSERT INTO lecturer_tbl VALUES(lecturer_seq.nextval, '������', '������ǻ�� ����', '��Ƽ�̵��');
INSERT INTO lecturer_tbl VALUES(lecturer_seq.nextval, 'Ȳ����', '����� �ý��� ����', '��Ʈ��ũ');

SELECT * FROM lecturer_tbl;

commit;

SELECT id, c.name, credit, l.name AS lecturer, week, start_hour, end_hour FROM course_tbl c, lecturer_tbl l WHERE c.lecturer = l.idx;
SELECT name FROM lecturer_tbl ORDER BY idx;
SELECT id, c.name, credit, l.name AS lecturer, week, start_hour, end_hour FROM course_tbl c, lecturer_tbl l WHERE c.lecturer = l.idx AND c.id='10001';