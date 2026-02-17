-- V1__init_schema.sql
-- Creates users, books, orders, order_items and indexes

CREATE TABLE IF NOT EXISTS users (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  role VARCHAR(50) NOT NULL,
  created_at TIMESTAMP DEFAULT now()
);

CREATE TABLE IF NOT EXISTS books (
  id BIGSERIAL PRIMARY KEY,
  title VARCHAR(500) NOT NULL,
  authors VARCHAR(1000),
  genre VARCHAR(255),
  isbn VARCHAR(100),
  price NUMERIC(12,2) NOT NULL DEFAULT 0.00,
  description TEXT,
  stock INTEGER NOT NULL DEFAULT 0,
  image_url TEXT,
  created_at TIMESTAMP DEFAULT now()
);

CREATE INDEX IF NOT EXISTS idx_books_title ON books (lower(title));
CREATE INDEX IF NOT EXISTS idx_books_authors ON books (lower(authors));
CREATE INDEX IF NOT EXISTS idx_books_genre ON books (lower(genre));

CREATE TABLE IF NOT EXISTS orders (
  id BIGSERIAL PRIMARY KEY,
  user_id BIGINT NOT NULL REFERENCES users(id) ON DELETE RESTRICT,
  status VARCHAR(50) NOT NULL DEFAULT 'PENDING',
  payment_status VARCHAR(50) NOT NULL DEFAULT 'UNPAID',
  total_price NUMERIC(14,2) NOT NULL DEFAULT 0.00,
  created_at TIMESTAMP DEFAULT now()
);

CREATE TABLE IF NOT EXISTS order_items (
  id BIGSERIAL PRIMARY KEY,
  order_id BIGINT NOT NULL REFERENCES orders(id) ON DELETE CASCADE,
  book_id BIGINT NOT NULL REFERENCES books(id) ON DELETE RESTRICT,
  quantity INTEGER NOT NULL,
  unit_price NUMERIC(12,2) NOT NULL,
  subtotal NUMERIC(14,2) NOT NULL
);

CREATE INDEX IF NOT EXISTS idx_orders_user_id ON orders (user_id);
