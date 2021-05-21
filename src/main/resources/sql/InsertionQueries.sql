INSERT into States (name, stateCode)
values ('Alaska', 'AK'),
('Alabama', 'AL'),
('Arizona', 'AZ'),
('Arkansas', 'AR'),
('California', 'CA'),
('Colorado', 'CO')
('Connecticut','CT'),
('Delaware','DE'),
('District of Columbia','DC'),
('Florida','FL',),
('Georgia', 'GA'),
('Hawaii', 'HI'),
('Idaho', 'ID'),
('Illinois', 'IL'),
('Indiana', 'IN'),
('Iowa', 'IA'),
('Kansas','KS'),
('Kentucky','KY'),
('Louisiana','LA'),
('Maine','ME'),
('Maryland','MD'),
('Massachusetts','MA'),
('Michigan','MI'),
('Minnesota','MN'),
('Mississippi','MS'),
('Missouri', 'MO'),
('Montana','MT'),
('Nebraska', 'NE'),
('Nevada','NV'),
('New Hampshire','NH'),
('New Jersey','NJ'),
('New Mexico','NM'),
('New York','NY'),
('North Carolina','NC'),
('North Dakota','ND'),
('Ohio','OH'),
('Oklahoma', 'OK'),
('Oregon','OR'),
('Pennsylvania','PA'),
('Puerto Rico','PR'),
('Rhode Island','RI'),
('South Carolina','SC'),
('South Dakota','SD'),
('Tennessee','TN'),
('Texas','TX'),
('Utah','UT'),
('Vermont','VT'),
('Virginia','VA'),
('Washington','WA'),
('West Virginia','WV'),
('Wisconsin','WI'),
('Wyoming','WY');

INSERT INTO Citizens (first_name, last_name, ssn)
VALUES ('John', 'Smith', '333-00-1111'),
('Jose', 'Sana', '333-00-2222'),
('Moe', 'Wino', '333-00-3333'),
('Nati', 'Moore', '333-00-4444'),
('Andrew', 'Varela', '333-00-5555');

INSERT INTO TownHalls (county)
Values('Los Angeles'),
('San Bernardino'),
('Orange'),
('Alameda')

INSERT INTO DMVs (town, name, time_open, time_close, townHalls_id)
values ('Los Angeles', 'LA DMV', '8:00', '16:00', 1),
('Agoura Hills', 'AH DMV', '8:00', '17:00', 2),
('Los Feliz', 'LF DMV', '8:00', '18:00', 3),
('Pasadena', 'PA DMV', '8:00', '18:00', 3)

INSERT INTO Tax_Bills (townHalls_id, properties_id)
Values(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5)

INSERT INTO Taxes (description, exp_date, amount, tax_bills_id)
Values ('School Tax', '2021-10-09', 1890.87, 1),
('County Tax', '2021-10-09', 10.55, 1),
('City Tax', '2021-10-09', 90.22, 1),
('State Tax', '2021-10-09', 490.11, 1),
('School Tax', '2021-09-09', 1890.87, 2),
('County Tax', '2021-09-09', 10.55, 2),
('City Tax', '2021-09-09', 90.22, 2),
('State Tax', '2021-09-09', 490.11, 2),
('School Tax', '2021-11-01', 1890.87, 3),
('County Tax', '2021-11-01', 10.55, 3),
('City Tax', '2021-11-01', 90.22, 3),
('State Tax', '2021-11-01', 490.11, 3)

INSERT INTO Licenses (number, exp_date, dmvs_id)
values(9023332, '2025-01-02', 1),
(83229982, '2030-09-10', 2),
(27898762, '2021-04-08', 3)


ALTER TABLE `mydb`.`Employees`
CHANGE COLUMN `dob` `dob` DATE NOT NULL ,
CHANGE COLUMN `start_date` `start_date` DATE NOT NULL ;


INSERT INTO DMVs (town, name, time_open, time_close, townHalls_id)
values ('Los Angeles', 'LA DMV', '8:00', '16:00', 1),
('Agoura Hills', 'AH DMV', '8:00', '17:00', 1),
('Los Feliz', 'LF DMV', '8:00', '18:00', 1)


INSERT INTO Properties (street_number, street_address, apartment_num, owner, citizens_id, townHalls_id, cities_id)
values (1234, 'Nagle', '5A', (SELECT last_name FROM Citizens where id = 1) , 1, 1, 24),
(4321, 'Fulton', '7B', (SELECT last_name FROM Citizens where id = 2), 2, 1, 45),
(678, 'Sunset', '9Y', (SELECT last_name FROM Citizens where id = 3), 3, 1, 24),
(1000, 'Buebank Blvd', '203', (SELECT last_name FROM Citizens where id = 4), 4, 1, 90),
(900, 'Alter', '600', (SELECT last_name FROM Citizens where id = 5), 5, 1, 24)



INSERT INTO Citizens (first_name, last_name, ssn)
Values
('Moses', 'Levy', '333-22-1111'),
('Jorge', 'Lozardo', '333-22-2222'),
('Claudio', 'Leuco', '333-22-3333'),
('John', 'Smith', '333-22-4444'),
('Alfredo', 'Roseti', '333-22-5555'),
('Carlos', 'Bilardo', '333-22-6666'),
('Carlos', 'Monzon', '333-22-7777'),
('Viviana', 'Etbul', '333-22-8888'),
('Natalia', 'Wino', '333-22-9999')


INSERT INTO Employees(first_name,last_name,ssn,dob,start_date,townHall_id)
VALUES ('Julian', 'Waing', '444-00-1111', '2000-09-01', '2021-10-09', 1),
('Aldana', 'Solved', '444-00-2222', '1989-07-02', '2020-11-02', 1),
('Groovy', 'Salvador', '444-00-3333', '1989-07-03', '2020-11-03', 1),
('Andres', 'Sling', '444-00-4444', '1985-07-05', '2018-11-04', 1),
('Teofilo', 'Kravetz', '444-00-5555', '1980-07-02', '2017-11-02', 1)

INSERT INTO Properties(street_number,street_address,apartment_num,owner,citizens_id,townHalls_id,cities_id)
VALUES(1234, 'Oakley', '7A', 'John Smith', 5, 1, 1),
(2345, 'Just', 'B', 'Jose Sana', 6, 1, 2),
(3456, 'Nagle', 'Back door', 'Moe Wino', 7, 1, 3),
(4567, 'Fulton', '100', 'Nati Moore', 8, 1, 4),
(5678, 'Sunset', '9002', 'Andrew Varela', 9, 1, 5)

INSERT INTO Licenses (number,exp_date,dmvs_id)
VALUES(1234561, '2024-10-01', 4),
(1234562, '2025-10-01', 5),
(1234563, '2026-10-01', 6),
(1234564, '2027-10-01', 7),
(1234565, '2028-10-01', 4)

INSERT INTO Smog_Checks (passed_date,exp_date)
VALUES('2017-10-01', '2022-10-01'),
('2018-10-01', '2023-10-01'),
('2019-10-01', '2024-10-01'),
('2020-10-01', '2025-10-01'),
('2021-10-01', '2026-10-01')

INSERT INTO Vehicles (make, model, year, license_plate, dmvs_id, citizens_id)
VALUES('Toyota', 'Corolla', 2015,'123456789', 4, 5),
('Honda', 'Fit', 2016,'123456790', 5, 6),
('Ford', 'Focus', 2017,'123456791', 6, 7),
('BMW', '323', 2018,'123456792', 7, 8)

INSERT INTO Smog_Checks_Orders(vehicles_id,smog_checks_id)
VALUES(1, 1),
(2,2),
(3,3),
(4,4)

INSERT INTO Tax_Bills (townHalls_id, properties_id)
Values(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5)

INSERT INTO Taxes (description, exp_date, amount, tax_bills_id)
Values ('School Tax', '2021-10-09', 1890.87, 16),
('County Tax', '2021-10-09', 10.55, 16),
('City Tax', '2021-10-09', 90.22, 16),
('State Tax', '2021-10-09', 490.11, 16),
('School Tax', '2021-09-09', 1890.87, 18),
('County Tax', '2021-09-09', 10.55, 18),
('City Tax', '2021-09-09', 90.22, 18),
('State Tax', '2021-09-09', 490.11, 18),
('School Tax', '2021-11-01', 1890.87, 20),
('County Tax', '2021-11-01', 10.55, 20),
('City Tax', '2021-11-01', 90.22, 20),
('State Tax', '2021-11-01', 490.11, 20)

INSERT INTO Telephones(number,type,citizens_id)
VALUES('15-4444-3333','Celular',5),
('011-4444-4444','Home',5),
('011-4444-5555','Work',5),
('011-4444-6666','Celular',5)