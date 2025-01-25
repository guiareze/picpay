CREATE DATABASE picpay;

USE picpay;

CREATE TABLE users(
user_id varchar(36),
user_name varchar(50) NOT NULL,
user_document varchar(11) NOT NULL,
user_email varchar(50) NOT NULL,
user_password varchar(50) NOT NULL,
PRIMARY KEY (user_id)
);

CREATE TABLE account(
account_id varchar(36),
account_amount decimal(10,2),
user_id varchar(36) NOT NULL,
PRIMARY KEY (account_id) ,
FOREIGN KEY (user_id) REFERENCES users(user_id)
);