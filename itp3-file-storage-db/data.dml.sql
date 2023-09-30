DELETE FROM customers;
DELETE FROM subscriptions;
DELETE FROM roles;

INSERT INTO roles(contact_role_code, contact_role_name)
    VALUES
        ('OTHER','Other');
		
		
		
