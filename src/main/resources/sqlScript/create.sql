CREATE TABLE registedPerson (
runningId INT AUTO_INCREMENT,
title VARCHAR(3), 
firstName VARCHAR(50), 
lastName VARCHAR(50),
birthDate VARCHAR(10),
mobile VARCHAR(10),
email VARCHAR(50),
address VARCHAR(256),
tShirtSize VARCHAR(2),
tShirtPickUpPoint VARCHAR(50),
payInSlipPath VARCHAR(100),
paid BOOLEAN,
PRIMARY KEY (runningId)
);