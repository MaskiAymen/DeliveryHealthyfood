insert into users(username, password,enabled) values ("admin", "123", true);
insert into users(username, password,enabled) values ("cashier", "123", true);
insert into users(username, password,enabled) values ("livreur", "123", true);


insert into authorities(username, authority) values ("admin", "ROLE_ADMIN");
insert into authorities(username, authority) values ("admin", "ROLE_USER");
insert into authorities(username, authority) values ("cashier", "ROLE_CASHIER");
insert into authorities(username, authority) values ("livreur", "ROLE_USER");
