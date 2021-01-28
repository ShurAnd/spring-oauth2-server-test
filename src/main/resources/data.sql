insert into users (username, password) values ('admin', 'admin');
insert into user_roles (user_id, roles) values (1, 'ROLE_ADMIN'), (1, 'ROLE_USER');
insert into client (client_id, secret) values ('andrey', 'andrey');