DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS subscriptions;
DROP SEQUENCE IF EXISTS Customers_customer_number_seq;

DROP SEQUENCE IF EXISTS customers_customer_number_seq;

CREATE TABLE customers (
	id SERIAL,
    customer_number SERIAL UNIQUE,
    customer_name VARCHAR(100) NOT NULL UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    consent BOOLEAN,
	    CONSTRAINT pk_customer_id
			PRIMARY KEY(id)
);

select setval('customers_customer_number_seq', 10000, false);

CREATE TABLE subscriptions (
	id SERIAL,
	subscription_code VARCHAR UNIQUE,
	subscription_name VARCHAR(100) NOT NULL,
	description VARCHAR(1000) NOT NULL,
	free_subscription BOOLEAN,
	duration_in_months int NOT null,
	maximum_stored_files int NOT NULL,
		CONSTRAINT pk_subscription_id
			PRIMARY KEY(id)
);
