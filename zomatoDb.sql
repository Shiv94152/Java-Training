
-- zomato.sql

-- DROP DATABASE IF EXISTS zomato;
CREATE DATABASE IF NOT EXISTS zomato;
USE zomato;

-- ---------------------------------------------------------
-- Customer Table
-- ---------------------------------------------------------
CREATE TABLE Customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(15),
    password VARCHAR(255) NOT NULL
);

-- ---------------------------------------------------------
-- Restaurant Table
-- ---------------------------------------------------------
CREATE TABLE Restaurant (
    restaurant_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(200),
    phone VARCHAR(15)
);

-- ---------------------------------------------------------
-- Menu Table
-- ---------------------------------------------------------
CREATE TABLE Menu (
    menu_id INT AUTO_INCREMENT PRIMARY KEY,
    restaurant_id INT,
    item_name VARCHAR(100) NOT NULL,
    price DECIMAL(8,2) NOT NULL,
    FOREIGN KEY (restaurant_id) REFERENCES Restaurant(restaurant_id)
);

-- ---------------------------------------------------------
-- Delivery Partner Table
-- ---------------------------------------------------------
CREATE TABLE DeliveryPartner (
    partner_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone VARCHAR(15)
);

-- ---------------------------------------------------------
-- Order Table
-- ---------------------------------------------------------
CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    restaurant_id INT,
    partner_id INT,
    total_amount DECIMAL(10,2),
    order_status VARCHAR(50),
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
    FOREIGN KEY (restaurant_id) REFERENCES Restaurant(restaurant_id),
    FOREIGN KEY (partner_id) REFERENCES DeliveryPartner(partner_id)
);

-- ---------------------------------------------------------
-- Insert sample data
-- ---------------------------------------------------------

-- Customers
INSERT INTO Customer (name, email, phone, password) VALUES
('Ankit Sharma', 'ankit.sharma@gmail.com', '9876543210', 'password@123'),
('Priya Verma', 'priya.verma@gmail.com', '9876501122', 'securepass'),
('Rahul Mehra', 'rahul.mehra@gmail.com', '9876512345', 'rahulpass'),
('Sneha Kapoor', 'sneha.kapoor@gmail.com', '9876523456', 'snehasecure'),
('Vikas Jain', 'vikas.jain@gmail.com', '9876534567', 'vikaspass');

-- Restaurants
INSERT INTO Restaurant (name, address, phone) VALUES
('Punjabi Tadka', 'Saket, New Delhi', '01122334455'),
('Biryani Blues', 'Banjara Hills, Hyderabad', '04022334455'),
('Dosa Point', 'JP Nagar, Bangalore', '08022334455'),
('The Veggie Hub', 'Kothrud, Pune', '02022334455'),
('Bombay Sandwich', 'Churchgate, Mumbai', '02222334455');

-- Menu Items
INSERT INTO Menu (restaurant_id, item_name, price) VALUES
(1, 'Butter Chicken', 320.00),
(2, 'Hyderabadi Biryani', 250.00),
(3, 'Masala Dosa', 120.00),
(4, 'Paneer Tikka', 180.00),
(5, 'Bombay Grilled Sandwich', 90.00),
(1, 'Dal Makhani', 220.00),
(2, 'Mutton Biryani', 320.00),
(3, 'Rava Idli', 100.00),
(4, 'Veg Thali', 160.00),
(5, 'Vada Pav', 60.00);

-- Delivery Partners
INSERT INTO DeliveryPartner (name, phone) VALUES
('Rohit Kumar', '9998800001'),
('Manoj Singh', '9998800002'),
('Deepak Joshi', '9998800003'),
('Arjun Rathore', '9998800004'),
('Suresh Yadav', '9998800005');

-- Orders
INSERT INTO Orders (customer_id, restaurant_id, partner_id, total_amount, order_status) VALUES
(1, 1, 1, 540.00, 'Delivered'),
(2, 2, 2, 250.00, 'Delivered'),
(3, 3, 3, 120.00, 'Preparing'),
(4, 4, 4, 180.00, 'Delivered'),
(5, 5, 5, 90.00, 'Out for delivery');

-- ---------------------------------------------------------
-- Some DML Operations
-- ---------------------------------------------------------

-- Update an order status
UPDATE Orders SET order_status = 'Delivered' WHERE order_id = 5;

-- Delete a customer who canceled account
DELETE FROM Customer WHERE customer_id = 5;

-- Change price of Masala Dosa
UPDATE Menu SET price = 140.00 WHERE item_name = 'Masala Dosa';

-- Insert a new customer
INSERT INTO Customer (name, email, phone, password) VALUES
('Ritu Saxena', 'ritu.saxena@gmail.com', '9876547777', 'ritu@pass');

-- Place new order
INSERT INTO Orders (customer_id, restaurant_id, partner_id, total_amount, order_status) VALUES
(6, 3, 2, 280.00, 'Pending');

-- ---------------------------------------------------------
-- Some SELECT queries to check data
-- ---------------------------------------------------------

-- list orders with customer names
SELECT o.order_id, c.name AS customer, r.name AS restaurant, o.total_amount, o.order_status
FROM Orders o
JOIN Customer c ON o.customer_id = c.customer_id
JOIN Restaurant r ON o.restaurant_id = r.restaurant_id;

-- check menu for a restaurant
SELECT m.item_name, m.price
FROM Menu m
JOIN Restaurant r ON m.restaurant_id = r.restaurant_id
WHERE r.name = 'Punjabi Tadka';

-- ---------------------------------------------------------
-- Done
-- ---------------------------------------------------------
