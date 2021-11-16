
create table departments (
id serial primary key,
name varchar(255)
);

create table employers (
id serial primary key,
name varchar(255),
department_id int references departments(id)
);

insert into departments(name) values ('ONE');
insert into departments(name) values ('TWO');
insert into departments(name) values ('THREE');
insert into departments(name) values ('four');


insert into employers(name, department_id) values ('1',1);
insert into employers(name, department_id) values ('11',1);
insert into employers(name, department_id) values ('111',null);
insert into employers(name, department_id) values ('1111',1);
insert into employers(name, department_id) values ('2',2);
insert into employers(name, department_id) values ('22',2);
insert into employers(name, department_id) values ('222',null);
insert into employers(name, department_id) values ('2222',2);
insert into employers(name, department_id) values ('3',3);
insert into employers(name, department_id) values ('33',3);
insert into employers(name, department_id) values ('333',null);
insert into employers(name, department_id) values ('3333',3);

select * from departments;
select * from employers;

-- 2. Выполнить запросы с left, rigth, full, cross соединениями
select * from employers as emp
left join departments dep
on emp.department_id = dep.id;

select * from employers as emp
right join departments dep
on emp.department_id = dep.id;

select * from employers as emp
full join departments dep
on emp.department_id = dep.id;

select * from employers as emp
cross join departments;

--3. Используя left join найти департаменты, у которых нет работников
select * from departments as dep
left join employers as emp
on emp.department_id = dep.id
where emp.department_id is null;

--4. Используя left и right join написать запросы, которые давали бы одинаковый результат.
select emp.name, dep.name
from departments dep
left join employers emp
on dep.id=emp.department_id
where emp.department_id is null;

select emp.name, dep.name
from employers emp
right join departments dep
on dep.id=emp.department_id
where emp.department_id is null;

--5. Создать таблицу teens с атрибутами name, gender и заполнить ее.
--Используя cross join составить все возможные разнополые пары
create table teens(
name varchar(255),
gender varchar(255)
);
insert into teens(name,gender) values ('Q','f');
insert into teens(name,gender) values ('W','f');
insert into teens(name,gender) values ('E','f');
insert into teens(name,gender) values ('R','f');
insert into teens(name,gender) values ('T','f');
insert into teens(name,gender) values ('Y','f');
insert into teens(name,gender) values ('й','m');
insert into teens(name,gender) values ('ц','m');
insert into teens(name,gender) values ('у','m');
insert into teens(name,gender) values ('к','m');
insert into teens(name,gender) values ('е','m');
insert into teens(name,gender) values ('н','m');

select f.name as female, m.name as male
from teens f cross join teens m
where f.gender != m.gender;

