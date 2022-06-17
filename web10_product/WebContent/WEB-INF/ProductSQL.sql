CREATE TABLE productTbl(
                code number PRIMARY KEY,
                name varchar2(100),
                price number,
                pictureurl varchar2(100),
                description varchar2(1000));
                
CREATE SEQUENCE product_seq NOCACHE;

INSERT INTO productTbl VALUES(product_seq.nextval, '���̽� ������ ���̾� �ڵ��', 34200, '01_python.jpg', '���̽��� Ȱ���� ������ ���� �Թ���');
INSERT INTO productTbl VALUES(product_seq.nextval, '��Ʋ���� Ȱ���� �ȵ���̵� ���α׷��� ', 34000, '02_android.jpg', '��Ʋ�� �� ���� �ȵ���̵� ���߼�');
INSERT INTO productTbl VALUES(product_seq.nextval, 'Node.js ������', 32400, '03_nodejs.jpg', '�⺻�⿡ ����� ���.js �н���');
INSERT INTO productTbl VALUES(product_seq.nextval, '�ڹ� ���� �ٷ�� ���', 40500, '04_javaWebBook.jpg', 'JSP,����,���������� �ǹ��� �˾ƾ� �� �����');
INSERT INTO productTbl VALUES(product_seq.nextval, '����� ������ 3.1', 67500, '05_spring.jpg', '�������� ������ ���ظ� ����� �������� ������');

SELECT * FROM productTbl;

commit;

SELECT * FROM productTbl ORDER BY code DESC;