DROP TABLE IF EXISTS Users;

CREATE TABLE Users(
username VARCHAR(20) PRIMARY KEY,
password VARCHAR(20) NOT NULL,
userType VARCHAR(10) NOT NULL
);

alter table Customer
ADD FOREIGN KEY (username) REFERENCES Users(username);