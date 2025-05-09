-- Updated data.sql
INSERT INTO products (product_id, name, description, price, category, stock, active) VALUES
                                                                                         ('prod-1', 'Laptop', 'High performance laptop', 999.99, 'Electronics', 50, true),
                                                                                         ('prod-2', 'Smartphone', 'Latest model smartphone', 699.99, 'Electronics', 100, true),
                                                                                         ('prod-3', 'Headphones', 'Noise cancelling headphones', 199.99, 'Electronics', 75, true);

INSERT INTO user_profiles (user_id, first_name, last_name, email, phone, address, active) VALUES
                                                                                              ('user-1', 'John', 'Doe', 'john.doe@example.com', '1234567890', '123 Main St', true),
                                                                                              ('user-2', 'Jane', 'Smith', 'jane.smith@example.com', '0987654321', '456 Oak Ave', true);