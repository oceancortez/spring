CREATE SCHEMA `laicnanifnalpym` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

CREATE TABLE `laicnanifnalpym`.`test_laicnanifnalpym` (
  `idtest` INT NOT NULL,
  PRIMARY KEY (`idTest`));
----------------------------------------------------------------------------------------------------------------  
CREATE TABLE `laicnanifnalpym`.`user` (
  `id_user` BIGINT NOT NULL AUTO_INCREMENT,
  `nam_user` VARCHAR(60) NOT NULL,
  `nam_email` VARCHAR(60) NOT NULL,
  `nam_password` VARCHAR(60) NOT NULL,
  `ind_user_status` ENUM('ACTIVE','CANCELLED','INACTIVE') NOT NULL,
  `dat_creation` DATETIME NOT NULL,
  `dat_last_login` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_user`),
  UNIQUE INDEX `nam_email_UNIQUE` (`nam_email` ASC));
  
  ALTER TABLE `laicnanifnalpym`.`user` 
ADD COLUMN `nam_role` VARCHAR(60) NOT NULL AFTER `dat_last_login`;

  
  
  CREATE TABLE `laicnanifnalpym`.`account` (
`id_account` BIGINT(20) NOT NULL AUTO_INCREMENT ,
`num_agency_account` VARCHAR(20) NOT NULL ,
`nam_account` VARCHAR(60) NOT NULL ,
`ind_account_type` ENUM('CURRENT','INVESTMENT','SAVINGS') NOT NULL ,
`ind_account_status` ENUM('ACTIVE','CANCELLED','INACTIVE') NOT NULL,
`dat_creation` DATETIME NOT NULL,
 PRIMARY KEY (`id_account`),
`dat_update` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);

ALTER TABLE `laicnanifnalpym`.`account` 
ADD COLUMN `id_user` BIGINT(20) NULL AFTER `dat_update`,
ADD INDEX `fk_id_user_idx` (`id_user` ASC);
ALTER TABLE `laicnanifnalpym`.`account` 
ADD CONSTRAINT `fk_id_user`
  FOREIGN KEY (`id_user`)
  REFERENCES `laicnanifnalpym`.`user` (`id_user`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


CREATE TABLE `laicnanifnalpym`.`credit_card` (
`id_credit_card` BIGINT(20) NOT NULL AUTO_INCREMENT ,
`num_last_credit_card` INT(4) NOT NULL ,
`nam_credit_card` VARCHAR(60) NOT NULL ,
`ind_flag_card` ENUM('ELO','MASTERCARD','VISA') NOT NULL ,
`ind_credit_card_status` ENUM('ACTIVE','CANCELLED','INACTIVE') NOT NULL,
`dat_creation` DATETIME NOT NULL,
 PRIMARY KEY (`id_credit_card`),
`dat_update` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);


------------------------------------------------------------------------------------------------------------------------
-- FAZER O INSERT PARA FUNCIONAR
CREATE TABLE `laicnanifnalpym`.`user_credit_card` (
  `id_user` BIGINT(20) NOT NULL,
  `id_credit_card` BIGINT(20) NOT NULL,
  INDEX `fk_user_credit_card` (`id_user` ASC),
  INDEX `fk_credit_card_user` (`id_credit_card` ASC),
  CONSTRAINT `fk_user_credit_card`
    FOREIGN KEY (`id_user`)
    REFERENCES `laicnanifnalpym`.`user` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_credit_card_user`
    FOREIGN KEY (`id_credit_card`)
    REFERENCES `laicnanifnalpym`.`credit_card` (`id_credit_card`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    
   
    CREATE TABLE `laicnanifnalpym`.`recipe_type` (
  `id_recipe_type` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nam_recipe_type` VARCHAR(60) NOT NULL,
  `nam_recipe_subtype` VARCHAR(60) NULL,
  PRIMARY KEY (`id_recipe_type`),
  UNIQUE INDEX `nam_recipe_type_UNIQUE` (`nam_recipe_type` ASC),
  UNIQUE INDEX `nam_recipe_subtype_UNIQUE` (`nam_recipe_subtype` ASC));
  
  
  ALTER TABLE `laicnanifnalpym`.`recipe_type` 
ADD COLUMN `id_user` BIGINT(20) NULL AFTER `nam_recipe_subtype`,
ADD INDEX `fk_id_user_idx` (`id_user` ASC);
ALTER TABLE `laicnanifnalpym`.`recipe_type` 
ADD CONSTRAINT `fk_id_user`
  FOREIGN KEY (`id_user`)
  REFERENCES `laicnanifnalpym`.`user` (`id_user`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  
  CREATE TABLE `laicnanifnalpym`.`recipe` (
  `id_recipe` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `des_description` VARCHAR(60) NOT NULL,
  `id_recipe_type` BIGINT(20) NOT NULL,
  `id_account` BIGINT(20) NOT NULL,
  `id_user` BIGINT(20) NOT NULL,
  `ind_value` VARCHAR(45) NOT NULL,
  `ind_recipe_status` ENUM('FIXED','OPEN','RECEIVED') NOT NULL,
  `dat_creation` DATETIME NOT NULL,
  PRIMARY KEY (`id_recipe`));
  
ALTER TABLE `laicnanifnalpym`.`recipe` 
ADD INDEX `fk_id_recipe_typex` (`id_recipe_type` ASC),
ADD CONSTRAINT `fk_id_recipe_type`
  FOREIGN KEY (`id_recipe_type`)
  REFERENCES `laicnanifnalpym`.`recipe_type` (`id_recipe_type`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


-- 18-06-16
ALTER TABLE `laicnanifnalpym`.`recipe` 
ADD INDEX `fk_id_recipe_type_idx` (`id_recipe_type` ASC);

ALTER TABLE `laicnanifnalpym`.`recipe` 
ADD CONSTRAINT `fk_id_recipe_type`
  FOREIGN KEY (`id_recipe_type`)
  REFERENCES `laicnanifnalpym`.`recipe_type` (`id_recipe_type`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


ALTER TABLE `laicnanifnalpym`.`recipe` 
ADD INDEX `fk_id_account_idx` (`id_account` ASC),
ADD INDEX `fk_id_user_idx` (`id_user` ASC);

ALTER TABLE `laicnanifnalpym`.`recipe` 
ADD CONSTRAINT `fk_id_account`
  FOREIGN KEY (`id_account`)
  REFERENCES `laicnanifnalpym`.`account` (`id_account`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_id_user`
  FOREIGN KEY (`id_user`)
  REFERENCES `laicnanifnalpym`.`user` (`id_user`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  
  -- NÃO ESTÁ SENDO MAIS USADO .. 20-07-2016
  
--  CREATE TABLE `laicnanifnalpym`.`user_recipe_type` (
--  `id_user` BIGINT(20) NOT NULL,
--  `id_recipe_type` BIGINT(20) NOT NULL,
--  INDEX `fk_user_recipe_type` (`id_user` ASC),
--  INDEX `fk_recipe_type_user` (`id_recipe_type` ASC),
--  CONSTRAINT `fk_user_recipe_type`
--    FOREIGN KEY (`id_user`)
--    REFERENCES `laicnanifnalpym`.`user` (`id_user`)
--    ON DELETE NO ACTION
--    ON UPDATE NO ACTION,
--  CONSTRAINT `fk_recipe_type_user`
--    FOREIGN KEY (`id_recipe_type`)
--    REFERENCES `laicnanifnalpym`.`recipe_type` (`id_recipe_type`)
--    ON DELETE NO ACTION
--    ON UPDATE NO ACTION);
--    
    
     
    -- NÃO ESTÁ SENDO MAIS USADO .. 20-07-2016
--    -- FAZER O INSERT PARA FUNCIONAR
--    CREATE TABLE `laicnanifnalpym`.`user_account` (
--  `id_user` BIGINT(20) NOT NULL,
--  `id_account` BIGINT(20) NOT NULL,
--  INDEX `fk_user_account` (`id_user` ASC),
--  INDEX `fk_account_user` (`id_account` ASC),
--  CONSTRAINT `fk_user_account`
--    FOREIGN KEY (`id_user`)
--    REFERENCES `laicnanifnalpym`.`user` (`id_user`)
--    ON DELETE NO ACTION
--    ON UPDATE NO ACTION,
--  CONSTRAINT `fk_account_user`
--    FOREIGN KEY (`id_account`)
--    REFERENCES `laicnanifnalpym`.`account` (`id_account`)
--    ON DELETE NO ACTION
--    ON UPDATE NO ACTION);
    
    
    -- FAZER O INSERT PARA FUNCIONAR

-- 14-06-2016 --------------------------------------------
  
  

Script Inicial


SELECT * FROM laicnanifnalpym.recipe;

INSERT INTO `laicnanifnalpym`.`recipe` (`id_recipe`, `des_description`, `id_recipe_type`, `id_account`, `id_user`, `ind_value`, `ind_recipe_status`,`dat_creation`) 
VALUES
 ('1', 'teste', '1', '1', '1', '500', 'OPEN', now());
 
 
SELECT * FROM laicnanifnalpym.recipe_type;

INSERT INTO `laicnanifnalpym`.`recipe_type` (`id_recipe_type`, `nam_recipe_type`, `nam_recipe_subtype`) VALUES ('1', 'TESTE', 'TESTE');

SELECT * FROM laicnanifnalpym.user;

INSERT INTO `laicnanifnalpym`.`user` (`id_user`, `nam_user`, `nam_email`, `nam_password`, `ind_user_status`,`dat_creation`,`dat_last_login`, `nam_role`)
 VALUES
 ('1', 'oxi', 'oxi@gmail.com', '123', 'ACTIVE',now(),now(), 'ADMIN');
 
 SELECT * FROM laicnanifnalpym.account;
 
 INSERT INTO `laicnanifnalpym`.`account` (`id_account`, `num_agency_account`, `nam_account`, `ind_account_type`, `ind_account_status`,`dat_creation`,`dat_update`) VALUES ('1', '8848 64903-7', 'Itau', 'CURRENT', 'ACTIVE', now(),now());







