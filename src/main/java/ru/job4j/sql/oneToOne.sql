create table man(
id serial primary key,
name varchar(255)
);

create table woman(
id serial primary key,
name varchar(255)
);

create table family(
id serial primary key,
man_id int references man(id) unique,
	woman_id int references woman(id) unique
);

insert into man(name) values('one');
insert into woman(name) values('two');

insert into family(man_id, woman_id) values(1,1);

select * from family;