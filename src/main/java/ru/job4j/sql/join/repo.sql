create table carcases(
id serial primary key,
name varchar(255)
);
create table engines(
id serial primary key,
name varchar(255)
);
create table transmissions(
id serial primary key,
name varchar(255)
);
create table cars(
id serial primary key,
name varchar(255),
carcase_id int references carcases(id),
engine_id int references engines(id),
transmission_id int references transmissions(id)
);

insert into carcases (name) values ('red carcase');
insert into engines (name) values ('red engine');
insert into transmissions (name) values ('red transmission');
insert into cars (name, carcase_id, engine_id, transmission_id) values ('red',1,1,1);

insert into carcases (name) values ('white carcase');
insert into engines (name) values ('white engine');
insert into transmissions (name) values ('white transmission');
insert into cars (name, carcase_id, engine_id, transmission_id) values ('white',2,2,2);

insert into carcases (name) values ('orange carcase');
insert into engines (name) values ('orange engine');
insert into transmissions (name) values ('orange transmission');
insert into cars (name, carcase_id, engine_id, transmission_id) values ('orange',3,3,3);

insert into carcases (name) values ('black carcase');
insert into carcases (name) values ('black carcase');
insert into carcases (name) values ('black carcase');
insert into engines (name) values ('green engine');
insert into engines (name) values ('green engine');
insert into transmissions (name) values ('yellow transmission');

-- 1) Вывести список всех машин и все привязанные к ним детали.
select cars.name, c.name, e.name, t.name
from cars
left join carcases as c
on cars.carcase_id = c.id
left join engines as e
on cars.engine_id = e.id
left join transmissions as t
on cars.transmission_id = t.id
order by cars.name;

-- 2) Вывести отдельно детали (1 деталь - 1 запрос), которые не используются НИ в одной машине

select * from carcases as c
left join cars
on c.id = cars.carcase_id
where cars.id is null;

select * from engines as e
left join cars
on e.id = cars.engine_id
where cars.engine_id is null;

select * from transmissions as t
left join cars
on t.id = cars.transmission_id
where cars.name is null;
