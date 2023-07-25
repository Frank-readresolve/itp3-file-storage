DROP TABLE IF EXISTS customers;

CREATE TABLE customers (
	customer_number SERIAL PRIMARY KEY,
	customer_name VARCHAR(100) NOT NULL UNIQUE,
	first_name VARCHAR(100) NOT NULL,
	last_name VARCHAR(100) NOT NULL,
	email VARCHAR NOT NULL,
	consent BOOLEAN
);