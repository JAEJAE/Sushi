
delete jumun where jumunno = 1
delete GUEST where guestno = 1
delete sushi where sushino=1
delete store where fishno=2

select * from store;
select * from SUSHI
select * from guest
select * from jumun
-- 가게
create table Store(

fishNo varchar2(10) primary key
, fishAmount varchar2(50)
, tableNo varchar2(10)
, totalSales varchar2(300)

);

-- 스시 
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


-- 주문
create table Jumun(

jumunNo varchar2(10) primary key
, guestNo varchar2(10)
, tableNo varchar2(50) 
	constraint tableNo_fk2 references Guest
, sushiNo varchar2(50)
	constraint sushiNo_fk references Sushi
, sushiCount varchar2(10) 

);


-- 손님
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

-- 가게의 테이블 생성 (no.1~2)

-- 연어의 재료량을 보여주기 위한 테이블 설정
-- (연어) 초기값
insert into STORE(
tableNo, fishNo, fishAmount, totalSales)
values(
'0', '1', '800', (select sum(cost) from GUEST ))
-- (광어) 초기값
insert into STORE(
tableNo, fishNo, fishAmount, totalSales)
values(
'0', '2', '800', (select sum(cost) from GUEST ))

--  (연어) 재고변경
update store
set fishAmount =(select a.fishAmount - b.fishIn * c.sushiCount 
					from store a, sushi b, jumun c
					where a.fishNo = b.fishNo
					and b.sushiNo = c.sushiNo
					and a.fishNo= '1'
					and c.sushiNo = '1') 
where tableNo= '0'

-- (광어) 재고변경
update store
set totalAmount =(select a.fishAmount - b.fishIn * c.sushiCount 
					from store a, sushi b, jumun c
					where a.fishNo = b.fishNo
					and b.sushiNo = c.sushiNo
					and a.fishNo= '2'
					and c.sushiNo = '2') 
where tableNo= '0'



-- 가게의 총 매출 
update store
set storeSales = (select sum(pay) from STORE )
where tableNo = '0'

-- 테이블 별 매출

update STORE
set cost = (select sum(price) from jumun a where tableNo='?' )
where tableNo = ?


-- 가게 재료양 계산

-- (연어)
update STORE
set fishNo = ('1')
,totalAmount = ('800')
where tableNo = '1'

--(광어)
update STORE
set fishNo = ('2')
,totalAmount = ('800')
where tableNo = '2'


-- Store 테이블
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
'1','연어초밥','1000','1','연어','50'
)

insert into Sushi(
sushiNo, sushiName, sushiPrice, fishNo, fishName, fishIn)
values(
'2','광어초밥','1200','2','광어','40'
)



/*
 * JUMUN -> GUEST가 생성되어야 할 수 있음
 */

-- GUEST생성 -> guest생성과 테이블 생성을 할 수 있음
insert into Guest(
guestNo,tableNo,cost)
values(
'1','1',null)
-- 주문하기 
insert into JUMUN(
guestNo,jumunNo,tableNo,sushiNo,sushiCount)
values(
'1','1','1','1', '2')

-- 총액(영수증) 계산
update GUEST
set cost = (select a.sushiPrice * b.sushiCount from sushi a, jumun b 
		where a.sushiNo=b.sushiNo)
where guestNo ='1'

select * from guest
where guestNo = '1'

			

-- delete문

delete from STORE
where fishNo = ?

delete from GUEST
where guestNo = ?

delete from JUMUN
where jumunNo = ?

delete from SUSHI
where sushiNo = ?








