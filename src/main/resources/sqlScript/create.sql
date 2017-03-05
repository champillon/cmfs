DROP DATABASE carnival;
CREATE DATABASE carnival DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

CREATE TABLE carnival.registedPerson (
runningId INT AUTO_INCREMENT,
title VARCHAR(3), 
firstName VARCHAR(50), 
lastName VARCHAR(50),
firstNameEn VARCHAR(50), 
lastNameEn VARCHAR(50),
birthDate VARCHAR(10),
mobile VARCHAR(10),
email VARCHAR(50),
payInSlipPath VARCHAR(100),
paid BOOLEAN,
runnerId VARCHAR(5),
coRunner VARCHAR(250),
PRIMARY KEY (runningId)
);