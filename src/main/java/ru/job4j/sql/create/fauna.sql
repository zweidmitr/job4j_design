create table fauna (
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values ('fish',55,'555-10-02');
insert into fauna(name, avg_age, discovery_date) values ('fish',7,'520-01-19');

insert into fauna(name, avg_age, discovery_date) values ('dog',999,'02-01-03');
insert into fauna(name, avg_age, discovery_date) values ('dog',15,'01-01-01');
insert into fauna(name, avg_age, discovery_date) values ('cat',9,'1917-05-05');
insert into fauna(name, avg_age, discovery_date) values ('cat',10,'2021-02-03');
insert into fauna(name, avg_age, discovery_date) values ('homa',10,null);


select * from fauna;

select * from fauna
where name LIKE 'fish';

select * from fauna
where avg_age > 10000 and avg_age < 21000;

select * from fauna
where discovery_date is null;

select * from fauna
where discovery_date < '1950-01-01';

