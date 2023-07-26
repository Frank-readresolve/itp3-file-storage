DROP TABLE IF EXISTS customers;
DROP SEQUENCE IF EXISTS customers_customer_number_seq;

CREATE TABLE customers (
	id SERIAL PRIMARY KEY,
	customer_number SERIAL UNIQUE,
	customer_name VARCHAR(100) NOT NULL UNIQUE,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
	email VARCHAR NOT NULL,
	consent BOOLEAN
);

select setval('customers_customer_number_seq', 10000, false);
