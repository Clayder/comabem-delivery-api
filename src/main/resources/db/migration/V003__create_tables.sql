create table type_payment (
     id bigint not null auto_increment,
     description varchar(60) not null,
     primary key (id)
) engine=InnoDB default charset=utf8;

create table permission_group (
   id bigint not null auto_increment,
   name varchar(60) not null,

   primary key (id)
) engine=InnoDB default charset=utf8;

create table permission_type (
    id bigint not null auto_increment,
    description varchar(60) not null,
    name varchar(100) not null,

    primary key (id)
) engine=InnoDB default charset=utf8;

create table permission_group_permission_type (
    permission_group_id bigint not null,
    permission_type_id bigint not null,

    primary key (permission_group_id, permission_type_id)
) engine=InnoDB default charset=utf8;

create table product (
     id bigint not null auto_increment,
     restaurant_id bigint not null,
     name varchar(80) not null,
     description text not null,
     price decimal(10,2) not null,
     active tinyint(1) not null,

     primary key (id)
) engine=InnoDB default charset=utf8;

create table restaurant (
     id bigint not null auto_increment,
     kitchen_id bigint not null,
     name varchar(80) not null,
     shipping_fee decimal(10,2) not null,
     updated_at datetime not null,
     created_at datetime not null,
     address_zip_code varchar(9) not null,
     address_address1 varchar(100) not null,
     address_address2 varchar(100) not null,
     address_number varchar(20) not null,
     address_neighborhood varchar(60) not null,
     address_city_id bigint(20) not null,

     primary key (id)
) engine=InnoDB default charset=utf8;

create table restaurant_type_payment (
    restaurant_id bigint not null,
    type_payment_id bigint not null,

    primary key (restaurant_id, type_payment_id)
) engine=InnoDB default charset=utf8;

create table user (
     id bigint not null auto_increment,
     name varchar(80) not null,
     email varchar(255) not null,
     password varchar(255) not null,
     created_at datetime not null,

     primary key (id)
) engine=InnoDB default charset=utf8;

create table user_permission_group (
    user_id bigint not null,
    permission_group_id bigint not null,

    primary key (user_id, permission_group_id)
) engine=InnoDB default charset=utf8;

alter table permission_group_permission_type add constraint fk_permission_group_permission_type_group
    foreign key (permission_group_id) references permission_group (id);

alter table permission_group_permission_type add constraint fk_permission_group_permission_type
    foreign key (permission_type_id) references permission_type (id);

alter table product add constraint fk_product_restaurant
    foreign key (restaurant_id) references restaurant (id);

alter table restaurant add constraint fk_restaurant_kitchen
    foreign key (kitchen_id) references kitchen (id);

alter table restaurant add constraint fk_restaurant_city
    foreign key (address_city_id) references city (id);

alter table restaurant_type_payment add constraint fk_restaurant_type_payment
    foreign key (type_payment_id) references type_payment (id);

alter table restaurant_type_payment add constraint fk_restaurant_type_payment_restaurant
    foreign key (restaurant_id) references restaurant (id);

alter table user_permission_group add constraint fk_user_permission_group
    foreign key (permission_group_id) references permission_group (id);

alter table user_permission_group add constraint fk_user_permission_group_user
    foreign key (user_id) references user (id);