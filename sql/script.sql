-- CRIANDO A BASE OXI
CREATE SCHEMA `oxi` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

-- CRIANDO TABELA USUARIO
CREATE TABLE `oxi`.`usuario` (
  `ID_USUARIO` BIGINT NOT NULL AUTO_INCREMENT COMMENT '',
  `NOM_USUARIO` VARCHAR(100) NOT NULL COMMENT '',
  `LOGIN_USUARIO` VARCHAR(100) NOT NULL COMMENT '',
  `EMAIL_USUARIO` VARCHAR(100) NOT NULL COMMENT '',
  `SENHA_USUARIO` VARCHAR(100) NOT NULL COMMENT '',
  `DT_ULT_ALT_USUARIO` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '',
  `DT_CAD_USUARIO`TIMESTAMP NULL COMMENT '',
  PRIMARY KEY (`ID_USUARIO`)  COMMENT '',
  UNIQUE INDEX `LOGIN_USUARIO_UNIQUE` (`LOGIN_USUARIO` ASC)  COMMENT '',
  UNIQUE INDEX `EMAIL_USUARIO_UNIQUE` (`EMAIL_USUARIO` ASC)  COMMENT '')
COMMENT = 'TABELA PARA FAZER O LOGIN';


-- Inserindo o primeio usuario
INSERT INTO `oxi`.`usuario` (`NOM_USUARIO`, `LOGIN_USUARIO`, `EMAIL_USUARIO`, `SENHA_USUARIO`) VALUES ('ocean martim cortez', 'theoceaan', 'theoceaan@gmail.com', '123');

-- alterando a data de cadastro
UPDATE `oxi`.`usuario` SET `DT_CAD_USUARIO`='2015-09-20 16:07:06' WHERE `ID_USUARIO`='1';

