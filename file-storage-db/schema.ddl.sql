DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS subscriptions;
DROP SEQUENCE IF EXISTS customer_number_seq;
DROP SEQUENCE IF EXISTS subscription_code_seq;

CREATE SEQUENCE customer_number_seq INCREMENT BY 1 START WITH 10000;

CREATE SEQUENCE subscription_code_seq INCREMENT BY 1;

CREATE TABLE customers (
	id SERIAL,
    customer_number INTEGER NOT NULL UNIQUE,
    customer_name VARCHAR(100) NOT NULL UNIQUE,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    api_key VARCHAR(64) NOT NULL UNIQUE,
    consent BOOLEAN,
	    CONSTRAINT pk_customer_id
			PRIMARY KEY(id)
);


CREATE TABLE subscriptions (
	id SERIAL,
	subscription_code VARCHAR NOT NULL UNIQUE,
	subscription_name VARCHAR(100) NOT NULL UNIQUE,
	description VARCHAR(1000) NOT NULL,
	free_subscription BOOLEAN,
	duration_in_months INTEGER NOT NULL,
	maximum_stored_files INTEGER NOT NULL,
		CONSTRAINT pk_subscription_id
			PRIMARY KEY(id)
);