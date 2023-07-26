DROP TABLE IF EXISTS customers;
DROP SEQUENCE IF EXISTS Customers_customer_number_seq;


CREATE TABLE customers (

    id SERIAL PRIMARY KEY,
    customer_number SERIAL UNIQUE,
    customer_name VARCHAR(100) NOT NULL UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    consent BOOLEAN
);

SELECT setval('customers_customer_number_seq', 10000, true);
