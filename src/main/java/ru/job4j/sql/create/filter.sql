create table type(
id serial primary key,
name varchar(255)
);

create table product(
id serial primary key,
name varchar(255),
type_id int references type(id),
experied_data date,
price int
);

insert into type(name) values('МОЛОКО');
insert into type(name) values('МЯСО');
insert into type(name) values('СЫР');
insert into type(name) values('ВИНО');
select * from type;

insert into product(name,type_id,experied_data,price) values('мороженное',1,'2021-11-30',60);
update product set name = 'мороженое';
insert into product(name,type_id,experied_data,price) values('молоко',1,'2021-11-17',90);
insert into product(name,type_id,experied_data,price) values('ряженка',1,'2021-11-18',95);
insert into product(name,type_id,experied_data,price) values('кефир',1,'2021-11-14',79);

insert into product(name,type_id,experied_data,price) values('филе',2,'2021-11-30',250);
insert into product(name,type_id,experied_data,price) values('бедра',2,'2021-11-30',200);
insert into product(name,type_id,experied_data,price) values('фарш',2,'2021-11-11',300);
insert into product(name,type_id,experied_data,price) values('нарезка',2,'2021-12-31',450);
insert into product(name,type_id,experied_data,price) values('мяско',2,'2021-12-31',600);
insert into product(name,type_id,experied_data,price) values('свинина',2,'2021-12-31',500);
insert into product(name,type_id,experied_data,price) values('курица',2,'2021-12-31',350);
insert into product(name,type_id,experied_data,price) values('говядина',2,'2021-12-31',450);
insert into product(name,type_id,experied_data,price) values('жадина',2,'2021-12-31',555);
insert into product(name,type_id,experied_data,price) values('паштет',2,'2021-12-31',200);
insert into product(name,type_id,experied_data,price) values('бекон',2,'2021-12-31',150);

insert into product(name,type_id,experied_data,price) values('Моцарелла',3,'2021-12-31',70);
insert into product(name,type_id,experied_data,price) values('Пармезан',3,'2021-12-31',80);
insert into product(name,type_id,experied_data,price) values('Чеддер',3,'2021-12-31',90);
insert into product(name,type_id,experied_data,price) values('Гауда',3,'2021-12-31',100);

insert into product(name,type_id,experied_data,price) values('пино-нуар',4,'2021-12-31',900);
insert into product(name,type_id,experied_data,price) values('шираза',4,'2021-12-31',900);
insert into product(name,type_id,experied_data,price) values('каберне',4,'2021-12-31',900);
insert into product(name,type_id,experied_data,price) values('мерло',4,'2021-12-31',900);
select * from product;

-- 1. Написать запрос получение всех продуктов с типом "СЫР"
select pr.name
from product as pr
join type as t on pr.type_id = t.id
where t.name like  '%СЫР%';

-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженое"
select pr.name
from product as pr
join type as t on pr.type_id = t.id
where pr.name like  '%мороженое%';

-- 3. Написать запрос, который выводит все продукты, срок годности которых уже истек
select pr.name
from product as pr
join type as t on pr.type_id = t.id
where pr.experied_data < current_date;

-- 4. Написать запрос, который выводит самый дорогой продукт.
select pr.name, pr.price
from product as pr
where pr.price = (select max(p.price) from product p);

-- 5. Написать запрос, который выводит для каждого типа количество продуктов к нему принадлежащих.
select t.name, count(pr.id)
from type t join product as pr
on t.id = pr.type_id
group by t.name;

-- 6. Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select p.name
from product p join type as t
on p.type_id = t.id
where t.name = 'СЫР' or t.name ='МОЛОКО';

-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
-- Под количеством подразумевается количество продуктов определенного типа.

select t.name, count(pr.id)
from type as t join product as pr
on t.id = pr.type_id
group by t.name
having count(pr.id) <10;

-- 8. Вывести все продукты и их тип.
select  pr.name, t.name
from product as pr  join type as t
on pr.type_id = t.id;

