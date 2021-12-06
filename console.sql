use week5;
show tables;
create table cqupt_student(
    studentid Varchar(10),
    name      VARCHAR(20),
    sex       VARCHAR(2),
    age       INTEGER,
    Fee       DECIMAL(10,2),
    address   VARCHAR(50),
    memo       VARCHAR(300)
);
create table CourseAa(
    Aa1     VARCHAR(20),
    Aa2     INTEGER,
    Aa3     DECIMAL(10)
);
create  table  ChooseBb(
    Bb1     VARCHAR(30),
    Bb2     INTEGER,
    Bb3     DECIMAL(6)
);
Alter table ChooseBb add Bb4    VARCHAR(20) NOT NULL  DEFAULT '系统测试值';
Alter table ChooseBb add Bb5    VARCHAR(10);
Alter table chooseBb add primary key (Bb5);
Create view view_Choosebb as select Bb1,Bb4,Bb5 from choosebb;
Drop view view_Choosebb;
Create index index_bb2 on choosebb(Bb2 ASC);
Create index index_bb4 on choosebb(Bb4 Desc);
Drop index index_bb2 on choosebb;

Create  table test(
    name VARCHAR(20),
    age  Integer,
    Score NUMERIC(10,2),
    Address VARCHAR(60)
);
INSERT into test (name, age, Score, Address)values
    ('赵一','20','580.00','重邮宿舍 12-3-5'),
    ('钱二','19','540.00','南福苑 5-2-9'),
    ('孙三','21','555.50','学生新区 21-5-15'),
    ('李四','22','505.00','重邮宿舍 8-6-22'),
    ('周五','20','495.50','学生新区 23-4-8'),
    ('吴六','19','435.00','南福苑');
Create table test_temp(
    Name VARCHAR (20),
    Age  INTEGER ,
    Score NUMERIC (10,2),
    Address VARCHAR (60)
);
INSERT  into test_temp(Name, Age, Score, Address) values
    ('郑七','21','490.50','重邮宿舍11-2-1'),
    ('张八','20','560.00','南福苑3-3-3'),
    ('王九','10','515.00','学生新区19-7-1');
INSERT INTO test (name, age, Score, Address) select name,age,Score,Address from test_temp;
update test set Score = Score+5 where age<=20;
update test set age=age-1 where Address like '南福苑';
Delete from test where age>=21 and Score>=500;
Delete from test where Score<550 and Address like '重邮宿舍%';

Create table Student (
    SNO VARCHAR(20),
    Name VARCHAR(10),
    Age INTEGER,
    College VARCHAR(30)
);
Create table Choose(
    SNO VARCHAR(20),
    CoureseID VARCHAR(30),
    Score   DECIMAL(5,2)
);
Create table Course(
    CourseID    VARCHAR(15),
    CourseName  VARCHAR(30),
    CourseBeforeID  VARCHAR(15)
);
INSERT into Student(SNO, Name, Age, College) values
    ('S00001','张三','20','计算机学院'),
    ('S00002','李四','19','通信学院'),
    ('S00003','王五','21','计算机学院');
INSERT into  Course(courseid, coursename, coursebeforeid) values
('C1','计算机导论',null),
('C2','C语言','C1'),
('C3','数据结构','C2');
INSERT into Choose(SNO, CoureseID, Score) values
('S00001','C1','95'),
('S00001','C2','80'),
('S00001','C3','84'),
('S00002','C1','80'),
('S00002','C2','85'),
('S00003','C1','78'),
('S00003','C3','70');
SELECT Sno  Name from student WHERE College='计算机学院';
SELECT *from student where Age between 20 and 23;
SELECT  count(*) from  student;
Select Max(Score) FROM choose WHERE CoureseID ='C1';
Select MIN(Score) FROM choose WHERE CoureseID ='C1';
Select SUM(Score) FROM choose WHERE CoureseID ='C1';
Select AVG(Score) FROM choose WHERE CoureseID ='C1';
SELECT courseid,coursename from course where CourseBeforeID is NULL;
SELECT student.SNO ,NAME,Coursename,score from student,course,choose where Student.SNO=Choose.SNO and choose.Coureseid=Course.CourseID;
Select *from student where College=(select College from student where name ='张三');
select student.SNO,name,CourseName,Score from student,course,choose where Student.sno=Choose.SNO and Choose.CoureseID=Course.CourseID ;
select SNO from choose where CoureseID='C1' UNION SELECT SNO FROM Choose WHERE CoureseID='C3';
SELECT DISTINCT SNO FROM Student WHERE SNO IN (SELECT SNO FROM Choose WHERE CoureseID='C1')
UNION SELECT DISTINCT SNO FROM Student
WHERE SNO IN (SELECT SNO FROM Choose WHERE CoureseID='C3');
