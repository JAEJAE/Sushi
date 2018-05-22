
delete jumun where jumunno = 3
delete GUEST where guestno = 1
delete sushi where sushino=3
delete store where fishno=1

select * from store;
select * from SUSHI
select * from guest
select * from jumun
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
	constraint fishNo_fk references Store
, fishName varchar(50)	
, fishIn varchar2(10)	
)


-- �ֹ�
create table Jumun(

jumunNo varchar2(10) primary key
, guestNo varchar2(10)
, tableNo varchar2(50) 
	constraint tableNo_fk2 references Guest
, sushiNo varchar2(50)
	constraint sushiNo_fk references Sushi
, sushiCount varchar2(10) 

);


-- �մ�
create table Guest(

guestNo varchar2(10) primary key
, tableNo varchar2(50) 
	constraint tableNo_fk references Store
, cost varchar2(100)	

);



/*
 * STORE
 */

select * from STORE

-- ������ ���̺� ���� (no.1~2)

-- ������ ��ᷮ�� �����ֱ� ���� ���̺� ����
-- (����) �ʱⰪ
insert into STORE(
tableNo, fishNo, fishAmount, totalSales)
values(
'0', '1', '800', (select sum(cost) from GUEST ))
-- (����) �ʱⰪ
insert into STORE(
tableNo, fishNo, fishAmount, totalSales)
values(
'0', '2', '800', (select sum(cost) from GUEST ))

--  (����) �����
update store
set fishAmount =(select a.fishAmount - b.fishIn * c.sushiCount 
					from store a, sushi b, jumun c
					where a.fishNo = b.fishNo
					and b.sushiNo = c.sushiNo
					and a.fishNo= '1'
					and c.sushiNo = '1') 
where tableNo= '0'

-- (����) �����
update store
set totalAmount =(select a.fishAmount - b.fishIn * c.sushiCount 
					from store a, sushi b, jumun c
					where a.fishNo = b.fishNo
					and b.sushiNo = c.sushiNo
					and a.fishNo= '2'
					and c.sushiNo = '2') 
where tableNo= '0'



-- ������ �� ���� 
update store
set storeSales = (select sum(pay) from STORE )
where tableNo = '0'

-- ���̺� �� ����

update STORE
set cost = (select sum(price) from jumun a where tableNo='?' )
where tableNo = ?


-- ���� ���� ���

-- (����)
update STORE
set fishNo = ('1')
,totalAmount = ('800')
where tableNo = '1'

--(����)
update STORE
set fishNo = ('2')
,totalAmount = ('800')
where tableNo = '2'


-- Store ���̺�
select * from STORE where tableNo = '1'

update store
set totalAmount=('null')
where tableNo='0'




/*
 * SUSHI
 */
select * from sushi
insert into Sushi(
sushiNo, sushiName, sushiPrice, fishNo, fishName, fishIn)
values(
'1','�����ʹ�','1000','1','����','50'
)

insert into Sushi(
sushiNo, sushiName, sushiPrice, fishNo, fishName, fishIn)
values(
'2','�����ʹ�','1200','2','����','40'
)



/*
 * JUMUN -> GUEST�� �����Ǿ�� �� �� ����
 */

-- GUEST���� -> guest������ ���̺� ������ �� �� ����
insert into Guest(
guestNo,tableNo,cost)
values(
'1','1',null)
-- �ֹ��ϱ� 
insert into JUMUN(
guestNo,jumunNo,tableNo,sushiNo,sushiCount)
values(
'1','1','1','1', '2')

-- �Ѿ�(������) ���
update GUEST
set cost = (select a.sushiPrice * b.sushiCount from sushi a, jumun b 
		where a.sushiNo=b.sushiNo)
where guestNo ='1'

select * from guest
where guestNo = '1'

			

-- delete��

delete from STORE
where fishNo = ?

delete from GUEST
where guestNo = ?

delete from JUMUN
where jumunNo = ?

delete from SUSHI
where sushiNo = ?








