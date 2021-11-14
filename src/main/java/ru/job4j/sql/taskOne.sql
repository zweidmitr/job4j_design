CREATE TABLE training(
id serial primary key,
tekData date,
legs integer,
bars integer,
execute boolean,
comm text
);

insert into training VALUES (1, '2021-11-114',60,null,TRUE,'ups');
insert into training VALUES (2, '2021-11-15',null,60,TRUE,'ha-ha');

update training SET execute = 'FALSE';

delete from training;