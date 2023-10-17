
CREATE DATABASE demo_db;



CREATE TABLE IF NOT EXISTS fruits
( id INTEGER NOT NULL AUTO_INCREMENT,
  img VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  article VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  price DECIMAL(6,2) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS orders
( id INTEGER NOT NULL AUTO_INCREMENT,
  order_code VARCHAR(255) NOT NULL,
  buyer_name VARCHAR(255) NOT NULL,
  buyer_phone VARCHAR(255) NOT NULL,
  buyer_email VARCHAR(255) NOT NULL,
  content VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);


INSERT INTO
 fruits (img, name, article, description, price)
VALUES
 ('apple1.jpeg', 'Apple', 'XXYZ123', 'Lorem ipsum orange', 14.95),
 ('apr.jpeg', 'Apricot', 'XXQWE234', 'Lorem ipsum blue', 65.00),
 ('grape.jpeg', 'Grape', 'XEM090988', 'Lorem ipsum green', 6.76),
 ('pear.jpg', 'Pear', 'KA301099', 'Lorem ipsum black', 80.22);