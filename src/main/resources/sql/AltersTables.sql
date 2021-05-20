ALTER TABLE Cities
MODIFY COLUMN states_id INT NULL

UPDATE Cities SET states_id = s.id
FROM Cities c INNER JOIN States s
ON c.stateCode = s.stateCode

UPDATE Cities as a
Inner join Cities as b
on b.id = a.id inner join States on b.stateCode = States.stateCode
set a.states_id = States.id

ALTER TABLE Citizens
MODIFY COLUMN licenses_id INT NULL

ALTER TABLE `mydb`.`Employees`
CHANGE COLUMN `dob` `dob` DATE NOT NULL ,
CHANGE COLUMN `start_date` `start_date` DATE NOT NULL;