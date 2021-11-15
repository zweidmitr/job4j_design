
create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);


insert into devices(name, price) values ('iphone7', 777);
insert into devices(name, price) values ('iphone7', 700);
insert into devices(name, price) values ('iphone7', 666);
insert into devices(name, price) values ('iphone8', 888);
insert into devices(name, price) values ('iphone8', 900);
insert into devices(name, price) values ('iphone9', 999);
insert into devices(name, price) values ('iphone13', 899);
insert into devices(name, price) values ('iphone13', 855);
insert into devices(name, price) values ('samsung', 666);
insert into devices(name, price) values ('samsung', 6666);
select * from devices;

insert into people(name) values ('dima');
insert into people(name) values ('mitr');
insert into people(name) values ('zwei');

select * from people;

insert into devices_people(device_id, people_id) values (4,1);
insert into devices_people(device_id, people_id) values (1,1);
insert into devices_people(device_id, people_id) values (2,2);
insert into devices_people(device_id, people_id) values (3,3);
insert into devices_people(device_id, people_id) values (6,2);
insert into devices_people(device_id, people_id) values (5,3);
insert into devices_people(device_id, people_id) values (8,1);
insert into devices_people(device_id, people_id) values (7,2);
insert into devices_people(device_id, people_id) values (9,2);
insert into devices_people(device_id, people_id) values (10,3);
select * from devices_people;

select d.name, avg(d.price) from devices as d
group by d.name;

select p.name, avg(d.price) from devices_people as dp join people p on dp.people_id = p.id
join devices d on dp.device_id = d.id
where d.price >5000
group by p.name;