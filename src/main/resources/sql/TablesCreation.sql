-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`TownHalls`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`TownHalls` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `county` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`DMVs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`DMVs` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `town` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `time_open` TIME NOT NULL,
  `time_close` TIME NOT NULL,
  `townHalls_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_DMVs_TownHalls1_idx` (`townHalls_id` ASC) VISIBLE,
  CONSTRAINT `fk_DMVs_TownHalls1`
    FOREIGN KEY (`townHalls_id`)
    REFERENCES `mydb`.`TownHalls` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Licenses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Licenses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` INT NOT NULL,
  `exp_date` DATE NOT NULL,
  `dmvs_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Licenses_DMVs1_idx` (`dmvs_id` ASC) VISIBLE,
  CONSTRAINT `fk_Licenses_DMVs1`
    FOREIGN KEY (`dmvs_id`)
    REFERENCES `mydb`.`DMVs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Citizens`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Citizens` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `ssn` VARCHAR(45) NOT NULL,
  `licenses_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Citizens_Licenses1_idx` (`licenses_id` ASC) VISIBLE,
  CONSTRAINT `fk_Citizens_Licenses1`
    FOREIGN KEY (`licenses_id`)
    REFERENCES `mydb`.`Licenses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`States`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`States` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `stateCode` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cities` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `stateCode` VARCHAR(2) NOT NULL,
  `states_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Cities_States1_idx` (`states_id` ASC) VISIBLE,
  CONSTRAINT `fk_Cities_States1`
    FOREIGN KEY (`states_id`)
    REFERENCES `mydb`.`States` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Properties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Properties` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `street_number` VARCHAR(45) NOT NULL,
  `street_address` VARCHAR(45) NOT NULL,
  `apartment_num` VARCHAR(45) NULL,
  `owner` VARCHAR(45) NOT NULL,
  `citizens_id` INT NOT NULL,
  `townHalls_id` INT NOT NULL,
  `cities_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Properties_Citizens1_idx` (`citizens_id` ASC) VISIBLE,
  INDEX `fk_Properties_TownHalls1_idx` (`townHalls_id` ASC) VISIBLE,
  INDEX `fk_Properties_Cities1_idx` (`cities_id` ASC) VISIBLE,
  CONSTRAINT `fk_Properties_Citizens1`
    FOREIGN KEY (`citizens_id`)
    REFERENCES `mydb`.`Citizens` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Properties_TownHalls1`
    FOREIGN KEY (`townHalls_id`)
    REFERENCES `mydb`.`TownHalls` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Properties_Cities1`
    FOREIGN KEY (`cities_id`)
    REFERENCES `mydb`.`Cities` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Cities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cities` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `stateCode` VARCHAR(2) NOT NULL,
  `states_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Cities_States1_idx` (`states_id` ASC) VISIBLE,
  CONSTRAINT `fk_Cities_States1`
    FOREIGN KEY (`states_id`)
    REFERENCES `mydb`.`States` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Counties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Counties` (
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Telephones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Telephones` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `number` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NULL,
  `citizens_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_telephones_Citizens1_idx` (`citizens_id` ASC) VISIBLE,
  CONSTRAINT `fk_telephones_Citizens1`
    FOREIGN KEY (`citizens_id`)
    REFERENCES `mydb`.`Citizens` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tax_Bills`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Tax_Bills` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `townHalls_id` INT NOT NULL,
  `properties_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Tax_Bills_TownHalls1_idx` (`townHalls_id` ASC) VISIBLE,
  INDEX `fk_Tax_Bills_Properties1_idx` (`properties_id` ASC) VISIBLE,
  CONSTRAINT `fk_Tax_Bills_TownHalls1`
    FOREIGN KEY (`townHalls_id`)
    REFERENCES `mydb`.`TownHalls` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tax_Bills_Properties1`
    FOREIGN KEY (`properties_id`)
    REFERENCES `mydb`.`Properties` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Taxes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Taxes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  `exp_date` DATE NOT NULL,
  `amount` DOUBLE NOT NULL,
  `tax_bills_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Taxes_Tax_Bills1_idx` (`tax_bills_id` ASC) VISIBLE,
  CONSTRAINT `fk_Taxes_Tax_Bills1`
    FOREIGN KEY (`tax_bills_id`)
    REFERENCES `mydb`.`Tax_Bills` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Vehicles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Vehicles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `make` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `year` YEAR(4) NOT NULL,
  `license_plate` VARCHAR(10) NOT NULL,
  `dmvs_id` INT NOT NULL,
  `citizens_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Vehicles_DMVs1_idx` (`dmvs_id` ASC) VISIBLE,
  INDEX `fk_Vehicles_Citizens1_idx` (`citizens_id` ASC) VISIBLE,
  CONSTRAINT `fk_Vehicles_DMVs1`
    FOREIGN KEY (`dmvs_id`)
    REFERENCES `mydb`.`DMVs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehicles_Citizens1`
    FOREIGN KEY (`citizens_id`)
    REFERENCES `mydb`.`Citizens` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Types_of_Properties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Types_of_Properties` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NULL,
  `properties_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Types_of_Properties_Properties1_idx` (`properties_id` ASC) VISIBLE,
  CONSTRAINT `fk_Types_of_Properties_Properties1`
    FOREIGN KEY (`properties_id`)
    REFERENCES `mydb`.`Properties` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Smog_Checks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Smog_Checks` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `passed_date` DATE NOT NULL,
  `exp_date` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Smog_Checks_Orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Smog_Checks_Orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `vehicles_id` INT NOT NULL,
  `smog_checks_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Vehicles_has_Smog_Checks_Smog_Checks1_idx` (`smog_checks_id` ASC) VISIBLE,
  INDEX `fk_Vehicles_has_Smog_Checks_Vehicles1_idx` (`vehicles_id` ASC) VISIBLE,
  CONSTRAINT `fk_Vehicles_has_Smog_Checks_Vehicles1`
    FOREIGN KEY (`vehicles_id`)
    REFERENCES `mydb`.`Vehicles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Vehicles_has_Smog_Checks_Smog_Checks1`
    FOREIGN KEY (`smog_checks_id`)
    REFERENCES `mydb`.`Smog_Checks` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Telephone_Type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Telephone_Type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Employees`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Employees` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `ssn` VARCHAR(45) NOT NULL,
  `dob` DATE NOT NULL,
  `start_date` DATE NOT NULL,
  `townHall_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Employees_TownHalls1_idx` (`townHall_id` ASC) VISIBLE,
  CONSTRAINT `fk_Employees_TownHalls1`
    FOREIGN KEY (`townHall_id`)
    REFERENCES `mydb`.`TownHalls` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
