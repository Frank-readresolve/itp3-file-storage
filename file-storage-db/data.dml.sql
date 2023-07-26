DELETE FROM customers;

INSERT INTO customers(customer_number, customer_name, first_name, last_name, email, consent) 
	VALUES 
		(nextval('customer_number_seq'), 'Simplon93100', 'Frank', 'MARSHALL', 'frank2@rearesolve.io',  true),
		(nextval('customer_number_seq'), 'SG92060', 'Lindsay', 'GRESSET', 'lindsay@gmail.com',  false),
		(nextval('customer_number_seq'),'BDDFDIRE94033', 'Maroua', 'SOLTANI', 'maroua@hotmail.fr',  true),