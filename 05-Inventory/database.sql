CREATE DATABASE Inventory;

USE Inventory;

CREATE TABLE Category(
	cate_id INT AUTO_INCREMENT PRIMARY KEY,
	cate_name VARCHAR(20) NOT NULL
);

CREATE TABLE Item(
	item_id INT AUTO_INCREMENT PRIMARY KEY,
	item_name VARCHAR(50) NOT NULL,
	item_price DECIMAL(10, 2) UNSIGNED NOT NULL,
	item_quantity INT UNSIGNED,
	item_stored DATE,
	type_id INT,
	FOREIGN KEY(type_id) REFERENCES Category(cate_id)
);