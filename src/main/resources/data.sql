-- User Profiles
INSERT INTO user_profiles (user_id, first_name, last_name, email, phone, address, active) VALUES
                                                                                              ('user-1', 'John', 'Doe', 'john.doe@example.com', '1234567890', '123 Main St, New York, NY', true),
                                                                                              ('user-2', 'Jane', 'Smith', 'jane.smith@example.com', '0987654321', '456 Oak Ave, Boston, MA', true),
                                                                                              ('user-3', 'Robert', 'Johnson', 'robert.j@example.com', '5551234567', '789 Pine Rd, Chicago, IL', true);

-- Products
INSERT INTO products (product_id, name, description, price, category, stock, active) VALUES
                                                                                         ('prod-1', 'Laptop', 'High performance business laptop', 999.99, 'Electronics', 50, true),
                                                                                         ('prod-2', 'Smartphone', 'Latest model smartphone', 699.99, 'Electronics', 100, true),
                                                                                         ('prod-3', 'Headphones', 'Noise cancelling wireless headphones', 199.99, 'Electronics', 75, true),
                                                                                         ('prod-4', 'Desk Chair', 'Ergonomic office chair', 249.99, 'Furniture', 30, true),
                                                                                         ('prod-5', 'Coffee Mug', 'Ceramic coffee mug with logo', 9.99, 'Home', 200, true);

-- Orders
INSERT INTO orders (order_id, user_id, status, order_date, total_amount) VALUES
                                                                             ('order-1', 'user-1', 'COMPLETED', '2025-01-15 10:30:00', 999.99),
                                                                             ('order-2', 'user-2', 'PROCESSING', '2025-02-20 14:15:00', 899.98),
                                                                             ('order-3', 'user-1', 'SHIPPED', '2025-03-05 09:45:00', 249.99);

-- Order Items (assuming you have an order_items table)
INSERT INTO order_items (order_id, product_id, quantity, unit_price) VALUES
                                                                         ('order-1', 'prod-1', 1, 999.99),
                                                                         ('order-2', 'prod-2', 1, 699.99),
                                                                         ('order-2', 'prod-3', 1, 199.99),
                                                                         ('order-3', 'prod-4', 1, 249.99);

-- Payments
INSERT INTO payments (payment_id, order_id, amount, payment_method, payment_status, transaction_date, currency) VALUES
                                                                                                                    ('pay-1', 'order-1', 999.99, 'CREDIT_CARD', 'COMPLETED', '2025-01-15 10:35:00', 'USD'),
                                                                                                                    ('pay-2', 'order-2', 899.98, 'PAYPAL', 'PENDING', '2025-02-20 14:20:00', 'USD'),
                                                                                                                    ('pay-3', 'order-3', 249.99, 'BANK_TRANSFER', 'PROCESSING', '2025-03-05 09:50:00', 'USD');

-- Notifications
INSERT INTO notifications (notification_id, user_id, message, sent_date, read_status, notification_type) VALUES
                                                                                                             ('notif-1', 'user-1', 'Your order #order-1 has been shipped', '2025-01-16 08:00:00', true, 'ORDER_UPDATE'),
                                                                                                             ('notif-2', 'user-2', 'Payment received for order #order-2', '2025-02-21 09:30:00', false, 'PAYMENT_CONFIRMATION'),
                                                                                                             ('notif-3', 'user-1', 'Your review is needed for product Laptop', '2025-03-06 11:15:00', false, 'PRODUCT_REVIEW');