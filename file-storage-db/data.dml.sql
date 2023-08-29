DELETE FROM customers;
DELETE FROM subscriptions;
DELETE FROM roles;


INSERT INTO customers (customer_name, first_name, last_name, email, consent) VALUES 
	('Simplon93100', 'Frank', 'MARSHALL', 'frank2@rearesolve.io',  true),
    ('SG92060', 'Lindsay', 'GRESSET', 'lindsay@gmail.com',  false),
    ('BDDFDIRE94033', 'Maroua', 'SOLTANI', 'maroua@hotmail.fr',  true);

INSERT INTO subscriptions(subscription_name, description, free_subscription, duration_in_months, maximum_stored_files) 
	VALUES 
		('Bijou80', 'un bijou', true, 3 , 367),
		('Bijou8777', 'un bijou en or pour Maroua', false, 11 , 6367);
		
INSERT INTO roles(contact_role_code,contact_role_name)
	VALUES
		('ABCDE','Manager')
		('MBGFR','Developper')
		
		
		
