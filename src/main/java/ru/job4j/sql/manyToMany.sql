create table games(
id serial primary key,
name varchar(255)
);

create table platforms(
id serial primary key,
name varchar(255)
);

create table games_platforms(
id serial primary key,
game_id int references games(id),
	platform_id int references platforms(id)
);

insert into games(name) values('g1');
insert into games(name) values('g2');
insert into games(name) values('g3');

insert into platforms(name) values('pk');
insert into platforms(name) values('ps');
insert into platforms(name) values('phone');

insert into games_platforms(game_id, platform_id) values(1,1);
insert into games_platforms(game_id, platform_id) values(1,3);
insert into games_platforms(game_id, platform_id) values(2,3);
insert into games_platforms(game_id, platform_id) values(3,1);
insert into games_platforms(game_id, platform_id) values(3,2);
insert into games_platforms(game_id, platform_id) values(3,3);

select * from games_platforms;

