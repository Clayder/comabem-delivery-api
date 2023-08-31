insert into kitchen (id, name) values (1, 'Tailandesa'), (2, 'Indiana');

insert into state (id, name) values (1, 'Rio de Janeiro');

insert into city (id, state_id, name) values (1, 1, 'Rio das Ostras');

insert into restaurant(id, shipping_fee, name, kitchen_id, address_zipcode, address_address1, address_address2, address_number, address_neighborhood, address_city_id, created_at, updated_at) values (1, 10, 'Thai Gourmet', 1, '21726335', 'logradouro', 'casa', '12', 'Centro', 1, utc_timestamp, utc_timestamp);
insert into restaurant(id, shipping_fee, name, kitchen_id, address_zipcode, address_address1, address_address2, address_number, address_neighborhood, address_city_id, created_at, updated_at) values (2, 9.5, 'Thai Delivery', 1, '21726335', 'logradouro', 'casa', '12', 'Centro', 1, utc_timestamp, utc_timestamp);
insert into restaurant(id, shipping_fee, name, kitchen_id, address_zipcode, address_address1, address_address2, address_number, address_neighborhood, address_city_id, created_at, updated_at) values (3, 15, 'Tuk Tuk Comida Indiana', 2, '21726335', 'logradouro', 'casa', '12', 'Centro', 1, utc_timestamp, utc_timestamp);

insert into permission (id, description, name) values (1, 'descrição', 'admin');

insert into type_payment (id, description) values (1, 'debito'), (2, 'credito');

insert into restaurant_type_payment (restaurant_id, type_payment_id) values (1, 1), (1, 2), (2, 1), (3, 2);

insert into product (id, name, description, price, active, restaurant_id) values (1, 'Pizza', 'descrição', 90.9, true, 1);