-- Create database (optional if already created)
-- DROP DATABASE IF EXISTS coffee_shop;
-- CREATE DATABASE coffee_shop;

-- enum
DROP TYPE IF EXISTS position_type;
CREATE TYPE position_type AS ENUM ('BARISTA', 'WAITER', 'CONFECTIONER');

-- Drop and recreate tables
DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS work_schedule;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS staff;
DROP TABLE IF EXISTS menu_items;

CREATE TABLE menu_items (
    id SERIAL PRIMARY KEY,
    name_en VARCHAR(100),
    name_ua VARCHAR(100),
    price DECIMAL(10,2) NOT NULL,
    item_type VARCHAR(20) NOT NULL CHECK (item_type IN ('DRINK', 'DESSERT')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT at_least_one_name CHECK (name_en IS NOT NULL OR name_ua IS NOT NULL)
);

CREATE TABLE staff (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address TEXT,
    position position_type NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE customers (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    birth_date DATE NOT NULL,
    phone VARCHAR(20) NOT NULL,
    address TEXT NOT NULL,
    discount_percent DECIMAL(5,2) DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE work_schedule (
    id SERIAL PRIMARY KEY,
    staff_id INTEGER REFERENCES staff(id),
    work_date DATE NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    customer_id INTEGER REFERENCES customers(id),
    staff_id INTEGER REFERENCES staff(id),
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE order_items (
    id SERIAL PRIMARY KEY,
    order_id INTEGER REFERENCES orders(id),
    menu_item_id INTEGER REFERENCES menu_items(id),
    quantity INTEGER NOT NULL,
    price_at_time DECIMAL(10,2) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
