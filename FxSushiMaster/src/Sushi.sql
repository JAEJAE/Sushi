select * from STORE;
select * from SUSHI;
select * from GUEST;
select * from JUMUN;

--������ �Ʒ��� ���̺� �����ϸ� ��
-- ����
create table Store(

fishNo varchar2(10) primary key
, fishAmount varchar2(50)
, tableNo varchar2(10)
, totalSales varchar2(300)

);

-- ���� 
select * from sushi

create table Sushi(
sushiNo varchar2(10)	primary key
, sushiName varchar2(300)	
, sushiPrice varchar2(10)				
, fishNo varchar2(10) 
	constraint fishNo_fk references Store on delete cascade
, fishName varchar(50)	
, fishIn varchar2(10)	
)


-- �մ�
create table Guest(

guestNo varchar2(10) primary key
, tableNo varchar2(50) 
	constraint tableNo_fk references Store on delete cascade
, cost varchar2(100)	

);

-- �ֹ�
create table Jumun(

jumunNo varchar2(10) primary key
, guestNo varchar2(10)
, tableNo varchar2(50) 
	constraint tableNo_fk2 references Guest on delete cascade
, sushiNo varchar2(50)
	constraint sushiNo_fk references Sushi on delete cascade
, sushiCount varchar2(10) 

);

