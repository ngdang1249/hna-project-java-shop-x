CREATE TABLE TestTable
(Col1 int IDENTITY,
Col2 varchar(50),
Col3 int);  

CREATE table APP.ADDRESS (
ID          INTEGER NOT NULL
PRIMARY KEY GENERATED ALWAYS AS IDENTITY
(START WITH 1, INCREMENT BY 1),
LASTNAME    VARCHAR(30),
FIRSTNAME   VARCHAR(30),
MIDDLENAME  VARCHAR(30),
PHONE       VARCHAR(20),
EMAIL       VARCHAR(30),
ADDRESS1    VARCHAR(30),
ADDRESS2    VARCHAR(30),
CITY        VARCHAR(30),
STATE       VARCHAR(30),
POSTALCODE  VARCHAR(20),
COUNTRY     VARCHAR(30) )

customer
name 	VARCHAR(45) 	✓
email 	VARCHAR(45) 	✓
phone 	VARCHAR(45) 	✓
address 	VARCHAR(45) 	✓
city_region 	VARCHAR(2) 	✓
cc_number 	VARCHAR(19) 	✓

category
Column 	Datatype 	PK 	NN 	UN 	AI
id 	TINYINT 	✓ 	✓ 	✓ 	✓
name 	VARCHAR(45) 	  	✓


customer_order
Column 	Datatype 	PK 	NN 	UN 	AI 	Default
id 	INT 	✓ 	✓ 	✓ 	✓ 	 
amount 	DECIMAL(6,2) 	  	✓ 	  	  	 
date_created 	TIMESTAMP 	  	✓ 	  	  	CURRENT_TIMESTAMP
confirmation_number 	INT 	  	✓ 	✓

product
Column 	Datatype 	PK 	NN 	UN 	AI 	Default
id 	INT 	✓ 	✓ 	✓ 	✓ 	 
name 	VARCHAR(45) 	  	✓ 	  	  	 
price 	DECIMAL(5,2) 	  	✓ 	  	  	 
description 	TINYTEXT 	  	  	  	  	 
last_update 	TIMESTAMP 	  	✓ 	  	  	CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
