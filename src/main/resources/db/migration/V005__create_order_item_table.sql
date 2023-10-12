CREATE TABLE order_item (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(80),
    unitPrice decimal(10,2) NOT NULL,
    totalPrice decimal(10,2) NOT NULL,
    observation varchar(100),
    order_id bigint,
    product_id bigint,

    PRIMARY KEY (id),

    CONSTRAINT fk_order_item_order FOREIGN KEY (order_id) REFERENCES `order` (id),
    CONSTRAINT fk_order_item_product FOREIGN KEY (product_id) REFERENCES product (id)
) ENGINE=InnoDB DEFAULT charset=utf8;