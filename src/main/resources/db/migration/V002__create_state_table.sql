CREATE TABLE state (
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(80),

    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT charset=utf8;

CREATE TABLE city (
   id bigint NOT NULL AUTO_INCREMENT,
   name varchar(80),
   state_id bigint,

   PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT charset=utf8;

ALTER TABLE city ADD CONSTRAINT fk_city_state FOREIGN KEY (state_id) REFERENCES state (id);