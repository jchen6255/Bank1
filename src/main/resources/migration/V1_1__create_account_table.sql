DROP TABLE IF EXISTS Account;

CREATE TABLE Account(
accountNumber INT NOT NULL AUTO_INCREMENT ,
accountType VARCHAR(20)NOT NULL,
amount DOUBLE NOT NULL,
version INT,
customerId INT,
PRIMARY KEY (accountNumber));