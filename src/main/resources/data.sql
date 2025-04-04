create table if not exists produto (
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    product_name VARCHAR(60) NOT NULL,
    product_description VARCHAR(450) NOT NULL, 
    price NUMERIC(18, 2)
);