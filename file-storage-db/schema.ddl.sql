DROP TABLE IF EXISTS customers;
DROP SEQUENCE IF EXISTS customer_number_sequence;


CREATE SEQUENCE customer_number_sequence
     INCREMENT BY 1
     START WITH 10000;


CREATE TABLE customers (
    id SERIAL PRIMARY KEY,
    customer_number INT UNIQUE nextval('customer_number_sequence'),
    customer_name VARCHAR(100) NOT NULL UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    consent BOOLEAN
);