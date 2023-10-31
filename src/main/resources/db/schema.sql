-- BD Creation
CREATE DATABASE IF NOT EXISTS management-sys;
USE management-sys;

-- Table Customer
CREATE TABLE Customer (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(255) NOT NULL,
    customer_email VARCHAR(255),
    customer_phone VARCHAR(15),
    customer_address VARCHAR(255),
    registration_date DATE,
    date_of_birth DATE,
    gender ENUM('Male', 'Female', 'Other'),
    UNIQUE (customer_email),
   
);

-- Table CustomerIdCard
CREATE TABLE CustomerIdCard (
    card_id INT AUTO_INCREMENT PRIMARY KEY,
    card_number VARCHAR(20) NOT NULL,
    expiration_date DATE,
    issuing_authority VARCHAR(255),
    card_type VARCHAR(50),
    issue_date DATE,
    customer_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
    UNIQUE (card_number),
    
);

-- Table Order
CREATE TABLE Order (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    order_date DATE,
    customer_id INT NOT NULL,
    total_amount DECIMAL(10, 2),
    order_status VARCHAR(20),
    shipping_address VARCHAR(255),
    payment_method VARCHAR(50),
    shipping_method VARCHAR(50),
    order_notes TEXT,
    tracking_number VARCHAR(30),
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
    
);

-- Table OrderItem
CREATE TABLE OrderItem (
    order_item_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT NOT NULL,
    service_id INT,
    product_id INT,
    quantity_ordered INT NOT NULL,
    unit_price DECIMAL(10, 2),
    total_price DECIMAL(10, 2),
    order_item_status VARCHAR(20),
    order_item_notes TEXT,
    FOREIGN KEY (order_id) REFERENCES Order(order_id),
    FOREIGN KEY (service_id) REFERENCES Service(service_id),
    FOREIGN KEY (product_id) REFERENCES Product(product_id),
   
);

-- Table Service
CREATE TABLE Service (
    service_id INT AUTO_INCREMENT PRIMARY KEY,
    service_name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    availability INT NOT NULL,
    service_type VARCHAR(50),
    service_duration INT,
    stock_id INT NOT NULL,
    FOREIGN KEY (stock_id) REFERENCES Stock(stock_id),
    
);

-- Table Product
CREATE TABLE Product (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    description TEXT,
    price DECIMAL(10, 2) NOT NULL,
    stock_quantity INT NOT NULL,
    manufacturer VARCHAR(255),
    product_category VARCHAR(50),
    stock_id INT NOT NULL,
    FOREIGN KEY (stock_id) REFERENCES Stock(stock_id),
   
);

-- Table Stock
CREATE TABLE Stock (
    stock_id INT AUTO_INCREMENT PRIMARY KEY,
    quantity_in_stock INT NOT NULL,
    last_updated DATETIME,
   
);

-- Table Payment
CREATE TABLE Payment (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    payment_amount DECIMAL(10, 2),
    payment_date DATE,
    customer_id INT NOT NULL,
    service_id INT,
    product_id INT,
    FOREIGN KEY (customer_id) REFERENCES Customer(customer_id),
    FOREIGN KEY (service_id) REFERENCES Service(service_id),
    FOREIGN KEY (product_id) REFERENCES Product(product_id),
    
);
