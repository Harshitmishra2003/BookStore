-- V2__seed_test_data.sql
-- Test users (passwords are bcrypt hashes of 'password' for demo only)
INSERT INTO users (name, email, password, role)
VALUES
('Admin User', 'admin@bookstore.local', '$2a$10$u1a1qZ1GqJmWq7nG1qf1J.5ZlqZQy4yZq1a1qZ1GqJmWq7nG1qf1J', 'ADMIN'),
('Customer One', 'alice@bookstore.local', '$2a$10$u1a1qZ1GqJmWq7nG1qf1J.5ZlqZQy4yZq1a1qZ1GqJmWq7nG1qf1J', 'CUSTOMER');

INSERT INTO books (title, authors, genre, isbn, price, description, stock, image_url)
VALUES
('Spring in Action', 'Craig Walls', 'Programming', '9781617294945', 399.00, 'Comprehensive guide to Spring', 10, ''),
('Clean Code', 'Robert C. Martin', 'Programming', '9780132350884', 499.00, 'Clean code principles', 5, ''),
('The Pragmatic Programmer', 'Andrew Hunt, David Thomas', 'Programming', '9780201616224', 450.00, 'Classic programming book', 7, '');

-- small sample order
INSERT INTO orders (user_id, status, payment_status, total_price)
VALUES (2, 'PENDING', 'UNPAID', 898.00);

INSERT INTO order_items (order_id, book_id, quantity, unit_price, subtotal)
VALUES (1, 1, 1, 399.00, 399.00),
       (1, 2, 1, 499.00, 499.00);
