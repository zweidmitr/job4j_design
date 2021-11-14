insert into roles (role) values ('one');
insert into roles (role) values ('two');

insert into users (name, role_id) values ('you', 1);
insert into users (name, role_id) values ('he', 1);
insert into users (name, role_id) values ('she', 2);

insert into rules (rule) values ('super');
insert into rules (rule) values ('neSuper');
insert into rules (rule) values ('taksebe');

insert into roles_rules (role_id, rule_id) values (1, 1);
insert into roles_rules (role_id, rule_id) values (2, 2);

insert into categories (category) values ('ein');
insert into categories (category) values ('zwei');
insert into categories (category) values ('drei');
insert into categories (category) values ('vier');

insert into states (state) values ('now');
insert into states (state) values ('yesterday');
insert into states (state) values ('tomorrow');

insert into items (item, user_id, category_id, state_id) values ('eat', 1, 1, 1);
insert into items (item, user_id, category_id, state_id) values ('sleep', 2, 2, 1);
insert into items (item, user_id, category_id, state_id) values ('walk', 3, 3, 1);

insert into comments (comment, item_id) values ('i want to eat', 1);
insert into comments (comment, item_id) values ('and sleep', 3);