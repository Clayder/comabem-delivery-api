CREATE TABLE `order` (
    id bigint NOT NULL AUTO_INCREMENT,
    subTotal decimal(10,2) NOT NULL,
    shippingFee decimal(10,2) NOT NULL,
    amount decimal(10,2) NOT NULL,
    createdAt datetime NOT NULL,
    confirmationDate datetime NOT NULL,
    cancellationDate datetime NOT NULL,
    deliveryDate datetime NULL,
    status varchar(10) NOT NULL,
    restaurant_id bigint not null,
    user_id bigint not null,
    type_payment_id bigint not null,
    address_zip_code varchar(9) not null,
    address_address1 varchar(100) not null,
    address_address2 varchar(100) not null,
    address_number varchar(20) not null,
    address_neighborhood varchar(60) not null,
    address_city_id bigint(20) not null,

    PRIMARY KEY (id),

    constraint fk_order_restaurant foreign key (restaurant_id) references restaurant (id),
    constraint fk_order_user foreign key (user_id) references user (id),
    constraint fk_order_type_payment foreign key (type_payment_id) references type_payment (id)

) ENGINE=InnoDB DEFAULT charset=utf8;