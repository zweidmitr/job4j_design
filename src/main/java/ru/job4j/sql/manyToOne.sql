create table taxNumber(
id serial primary key,
name varchar(255)
);
insert into  taxNumber(name) values ('68k');
insert into  taxNumber(name) values ('130k');
select * from taxNumber

create table cars(
id serial primary key,
number int,
taxNumber_id int references taxNumber(id)
);
insert into cars(number, taxNumber_id) VALUES(999, 1);
insert into cars(number, taxNumber_id) VALUES(998, 1);
insert into cars(number, taxNumber_id) VALUES(997, 1);
insert into cars(number, taxNumber_id) VALUES(996, 1);
insert into cars(number, taxNumber_id) VALUES(888, 2);
insert into cars(number, taxNumber_id) VALUES(808, 2);
select * from cars;