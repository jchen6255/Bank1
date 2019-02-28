DROP TABLE IF EXISTS REPORT;

CREATE TABLE REPORT(
reportId INT AUTO_INCREMENT,
accountNumnber INT,
reportDate DATE,
moneyFlow DOUBLE,
month INT,
year INT, 
PRIMARY KEY (reportId)
);