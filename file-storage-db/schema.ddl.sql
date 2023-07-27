DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS subscriptions;
DROP SEQUENCE IF EXISTS Customers_customer_number_seq;

DROP SEQUENCE IF EXISTS customers_customer_number_seq;

CREATE TABLE customers (

    id SERIAL PRIMARY KEY,
    customer_number SERIAL UNIQUE,
    customer_name VARCHAR(100) NOT NULL UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL,
    consent BOOLEAN
);

select setval('customers_customer_number_seq', 10000, false);

CREATE TABLE subscriptions (
	id SERIAL PRIMARY KEY,
	subscriptions_code SERIAL unique,
	subscription_name VARCHAR(100) NOT NULL,
	description VARCHAR(1000) NOT NULL,
	free_subscription BOOLEAN,
	duration_in_months int CHECK (duration_in_months >=1 AND duration_in_months <= 12) NOT null,
	maximum_stored_files int CHECK (maximum_stored_files >=11 AND maximum_stored_files <= 10000) NOT NULL
);
