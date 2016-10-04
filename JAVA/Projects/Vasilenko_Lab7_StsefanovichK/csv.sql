CREATE TABLE IF NOT EXISTS dataBase(
   name    VARCHAR(23) NOT NULL PRIMARY KEY
  ,shortTitle VARCHAR(6) NOT NULL
  ,dateUpdate DATE 
  ,address VARCHAR(10)
  ,dateFoundation DATE  NOT NULL
  ,countEmployees INTEGER  NOT NULL
  ,auditor VARCHAR(6)
  ,phone   VARCHAR(17)
  ,email   VARCHAR(23)
  ,branch  VARCHAR(20) NOT NULL
  ,activity VARCHAR(20) NOT NULL
  ,internetAddress VARCHAR(15) NOT NULL
);
INSERT INTO dataBase(name,shortTitle,dateUpdate,address,dateFoundation,countEmployees,auditor,phone,email,branch,activity,internetAddress) VALUES ('Augustina Incorporation','AugInc','11.02.1998','New-York','01.01.1970',500,'Mikki','+375 29 355-27-46','freeplayercot@gmail.com','Soc.Ingenering','Marketing','github.io');
INSERT INTO dataBase(name,shortTitle,dateUpdate,address,dateFoundation,countEmployees,auditor,phone,email,branch,activity,internetAddress) VALUES ('Felix Incorporation','FInc',NULL,'Washington','01.01.1990',1000,NULL,'+375 29 345-11-76',NULL,'Soc.Ingenering','Marketing','felicity.com');
INSERT INTO dataBase(name,shortTitle,dateUpdate,address,dateFoundation,countEmployees,auditor,phone,email,branch,activity,internetAddress) VALUES ('ElliotHackCorp','E-Corp','20.11.1978',NULL,'20.06.1960',250,'Jennis',NULL,NULL,'Soc.Ingenering','Software development','fsoc.sh');
INSERT INTO dataBase(name,shortTitle,dateUpdate,address,dateFoundation,countEmployees,auditor,phone,email,branch,activity,internetAddress) VALUES ('Na-na-na Corporation','NaCorp','9.02.1994','Minsk','13.04.1989',1700,NULL,'+375 17 355-27-46','free_playerq@mail.ru','Soc.Ingenering','Filosofy','github.io');
INSERT INTO dataBase(name,shortTitle,dateUpdate,address,dateFoundation,countEmployees,auditor,phone,email,branch,activity,internetAddress) VALUES ('Fix Jey Department','FJD',NULL,'Moscow','10.07.1959',100,'Maus',NULL,NULL,'Filosofy','Software development','kmb.ufoctf.ru');
INSERT INTO dataBase(name,shortTitle,dateUpdate,address,dateFoundation,countEmployees,auditor,phone,email,branch,activity,internetAddress) VALUES ('Wayne Enterptaise','WAYNE',NULL,NULL,'23.06.1991',700,NULL,NULL,NULL,'Software development','Filosofy','countersite.org');
