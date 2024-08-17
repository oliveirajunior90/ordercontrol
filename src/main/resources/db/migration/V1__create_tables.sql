CREATE TABLE product (
      id uuid not null primary key,
      name VARCHAR(255) NOT NULL,
      description TEXT,
      price NUMERIC(10, 2) NOT NULL,
      ingredient JSONB NOT NULL
);


CREATE TABLE orders (
    id uuid not null primary key,
    customer_name VARCHAR(255) NOT NULL,
    customer_email VARCHAR(255) NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'PENDING',
    order_items JSONB NOT NULL
);

create table ingredient (
    id serial not null primary key,
    name varchar(255) not null,
    quantity_in_stock numeric(10, 2) not null,
    unity varchar(255) not null
);

