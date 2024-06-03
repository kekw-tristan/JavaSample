DROP DATABASE if EXISTS javaprojekt;
CREATE DATABASE if NOT EXISTS javaprojekt
DEFAULT CHARACTER SET utf8mb4
COLLATE UTF8MB4_GENERAL_CI;

USE javaprojekt;

DROP TABLE if EXISTS address;
CREATE TABLE if NOT EXISTS address
(
    addressID 	 INT 			  NOT NULL AUTO_INCREMENT
    ,street 	 	 VARCHAR(100) NOT NULL
    ,houseNumber VARCHAR(10)  NOT NULL
    ,country		 VARCHAR(50)  NOT NULL
    ,city			 VARCHAR(50)  NOT NULL
    ,postalCode  VARCHAR(5)   NOT NULL

    -- Primärschlüssel
    ,CONSTRAINT address_pk PRIMARY KEY (addressID)
    );

DROP TABLE if EXISTS account;
CREATE TABLE if NOT EXISTS account
(
    accountID INT 			  NOT NULL AUTO_INCREMENT
    ,username VARCHAR(30)  NOT NULL UNIQUE
    ,email 	 VARCHAR(100) NOT NULL UNIQUE
    ,PASSWORD VARCHAR(20)  NOT NULL

    -- Primärschlüssel
    ,CONSTRAINT account_pk PRIMARY KEY (accountID)
    );

DROP TABLE if EXISTS customer;
CREATE TABLE if NOT EXISTS customer
(
    customerID 	 INT 			  NOT NULL AUTO_INCREMENT
    ,firstName 	 VARCHAR(100) NOT NULL
    ,lastName 	 VARCHAR(100) NOT NULL
    ,email 		 VARCHAR(100) NOT NULL UNIQUE
    ,addressID   INT 			  NOT NULL
    ,phoneNumber VARCHAR(12)  NOT NULL UNIQUE
    ,birthDate 	 DATE 		  NOT NULL
    ,accountID 	 INT 			  NOT NULL

    -- Primärschlüssel
    ,CONSTRAINT customer_pk PRIMARY KEY (customerID)

    -- Fremdschlüssel
    ,CONSTRAINT customer_address_fk FOREIGN KEY (addressID) REFERENCES address(addressID)
    ,CONSTRAINT customer_account_fk FOREIGN KEY (accountID) REFERENCES account(accountID)
    );

DROP TABLE if EXISTS employee;
CREATE TABLE if NOT EXISTS employee
(
    employeeID 		 INT 			  NOT NULL AUTO_INCREMENT
    ,firstName 		 VARCHAR(100) NOT NULL
    ,lastName 		 VARCHAR(100) NOT NULL
    ,birtDate 		 DATE 		  NOT NULL
    ,employmentDate DATE 		  NOT NULL
    ,email 			 VARCHAR(100) NOT NULL UNIQUE
    ,addressID 		 INT 			  NOT NULL
    ,salary 			 FLOAT 		  NOT NULL
    ,accountID		 INT 			  NOT NULL

    -- Primärschlüssel
    ,CONSTRAINT employee_pk PRIMARY KEY (employeeID)

    -- Fremdschlüssel
    ,CONSTRAINT employee_address_fk FOREIGN KEY (addressID) REFERENCES address(addressID)
    ,CONSTRAINT employee_account_fk FOREIGN KEY (accountID) REFERENCES account(accountID)
    );

DROP TABLE if EXISTS article;
CREATE TABLE if NOT EXISTS article
(
    articleID 	 INT 			  NOT NULL AUTO_INCREMENT
    ,NAME			 VARCHAR(100) NOT NULL
    ,pricePerDay FLOAT		  NOT NULL
    ,producer 	 VARCHAR(100) NOT NULL
    ,inWarehouse BOOLEAN 	  NOT NULL

    -- Primärschlüssel
    ,CONSTRAINT article_pk PRIMARY KEY (articleID)
    );

DROP TABLE if EXISTS warehouse;
CREATE TABLE if NOT EXISTS warehouse
(
    warehouseID INT NOT NULL AUTO_INCREMENT
    ,addressID  INT NOT NULL
    -- ,storage
    -- ,storageBroken

    -- Primärschlüssel
    ,CONSTRAINT warehouse_pk PRIMARY KEY (warehouseID)
    );

DROP TABLE if EXISTS studio;
CREATE TABLE if NOT EXISTS studio
(
    studioID INT NOT NULL AUTO_INCREMENT
    ,pricePerDay FLOAT NOT NULL
    ,addressID INT NOT NULL
    -- ,inventory

    -- Primärschlüssel
    ,CONSTRAINT studio_pk PRIMARY KEY (studioID)

    -- Fremdschlüssel
    ,CONSTRAINT studio_address_fk FOREIGN KEY (addressID) REFERENCES address(addressID)
    );

DROP TABLE if EXISTS studioCalender;
CREATE TABLE if NOT EXISTS studioCalender
(
    studioCalenderID INT NOT NULL AUTO_INCREMENT
    -- ,entryList
    ,studioID INT NOT NULL

    -- Primärschlüssel
    ,CONSTRAINT studioCalender_pk PRIMARY KEY (studioCalenderID)

    -- Fremdschlüssel
    ,CONSTRAINT studioCalender_studio_fk FOREIGN KEY (studioID) REFERENCES studio(studioID)
    );

DROP TABLE if EXISTS studioCalenderEntry;
CREATE TABLE if NOT EXISTS studioCalenderEntry
(
    studioCalenderEntryID INT NOT NULL auto_increment
    ,startDate DATE NOT NULL
    ,endDate DATE NOT NULL
    ,firstName VARCHAR(100) NOT NULL
    ,lastName VARCHAR(100) NOT NULL
    -- ,renterAccount

    -- Primärschlüssel
    ,CONSTRAINT studioCalenderEntry_pk PRIMARY KEY (studioCalenderEntryID)
    );