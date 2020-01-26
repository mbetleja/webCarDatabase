CREATE TABLE carDatabase(id BIGINT PRIMARY KEY AUTO_INCREMENT
                                ,brand VARCHAR(20)
                                ,model VARCHAR(30)
                                ,colour VARCHAR (30)
                                ,yearOfProduction date
                                ,vin VARCHAR (20),
                                PRIMARY KEY (id));
