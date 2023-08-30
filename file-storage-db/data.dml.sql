DELETE FROM customers;
DELETE FROM subscriptions;
DELETE FROM roles;


INSERT INTO customers (role_id, customer_number, customer_name, first_name, last_name, email, consent) VALUES 
    (1, 1, 'Simplon93100', 'Frank', 'MARSHALL', 'frank@rearesolve.io',  true),
    (2, 2, 'SG92060', 'Lindsay', 'GRESSET', 'lindsay@gmail.com',  false)

INSERT INTO subscriptions(subscription_name, description, free_subscription, duration_in_months, maximum_stored_files) 
    VALUES 
        ('Bijou80', 'un bijou', true, 3 , 367),
        ('Bijou8777', 'un bijou en or pour Maroua', false, 11 , 6367);

INSERT INTO roles(contact_role_code, contact_role_name)
    VALUES
        ('ABCDE','Manager'),
        ('MBGFR','Developper');
		
		
		
