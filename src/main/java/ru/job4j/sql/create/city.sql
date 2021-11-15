create table continent(
id serial primary key,
name varchar(255)
);

create table city(
id serial primary key,
name varchar(255),
continent_id int references continent(id)
);

insert into continent(name) values ('europa');
insert into continent(name) values ('asia');
insert into continent(name) values ('america');
insert into continent(name) values ('africa');
insert into continent(name) values ('australia');
insert into continent(name) values ('antarctica');

insert into city(name,continent_id) values ('spb',1);
insert into city(name,continent_id) values ('kron',1);
insert into city(name,continent_id) values ('ny',3);
insert into city(name,continent_id) values ('la',3);
insert into city(name,continent_id) values ('berlin',1);
insert into city(name,continent_id) values ('tokio',2);
insert into city(name,continent_id) values ('canberra',5);
insert into city(name,continent_id) values ('sydney',5);
insert into city(name,continent_id) values ('cairo',4);

select * from city join continent count on city.continent_id = count.id;
select city.name as ci from city join continent on city.continent_id = continent.id;
select city.name as ci, continent.name as cont from city join continent on city.continent_id = continent.id;
select city.name as ci, continent.name as cont from city join continent on city.continent_id = continent.id
where continent.name = 'australia';
select continent.name as continent from city join continent on city.continent_id = continent.id
where city.name = 'spb';
