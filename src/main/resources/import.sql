insert into kitchen (name) values ('Tailandesa');
insert into kitchen (name) values ('Indiana');

insert into restaurant(shipping_fee, name, kitchen_id) values (10, 'Thai Gourmet', 1);
insert into restaurant(shipping_fee, name, kitchen_id) values (9.5, 'Thai Delivery', 1);
insert into restaurant(shipping_fee, name, kitchen_id) values (15, 'Tuk Tuk Comida Indiana', 1);

insert into state (id, name) values (1, 'Rio de Janeiro');

insert into city (id, state_id, name) values (1, 1, 'Rio das Ostras');

insert into permission (id, description, name) values (1, 'descrição', 'admin');

insert into type_payment (id, description) values (1, 'debito');