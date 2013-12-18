drop table if exists Customers ;

create table Customers (ID BIGINT NOT NULL AUTO_INCREMENT, forename VARCHAR(40),
surname VARCHAR(40), phoneNumber VARCHAR(40), email VARCHAR(40),
PRIMARY KEY (ID) ) Engine=INNODB;


drop table if exists Apartments;

create table Apartments (customer bigint not null, road varchar(40),
houseNumber varchar(40), zipCode varchar(40), location varchar(40),
primary key (road, houseNumber, zipCode, location),
key (customer), foreign key (customer) references Customers(ID) ) ENGINE=INNODB;