create table produto (
    id VARCHAR(255) NOT NULL PRIMARY KEY,
    productName VARCHAR(60) NOT NULL,
    productDescription VARCHAR(450) NOT NULL, 
    price NUMERIC(18, 2)
);