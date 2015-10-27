-- MySQL Workbench Synchronization
-- Generated: 2015-10-27 15:03
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Walter Gandarella

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE TABLE IF NOT EXISTS `pi2015`.`usuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(200) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `senha` VARCHAR(128) NOT NULL,
  `banco` VARCHAR(45) NULL DEFAULT NULL,
  `agencia` VARCHAR(10) NULL DEFAULT NULL,
  `conta` VARCHAR(15) NULL DEFAULT NULL,
  `gerente` BIT(1) NOT NULL DEFAULT 0,
  `datacriacao` DATETIME NOT NULL,
  `dataedicao` TIMESTAMP NOT NULL,
  `telefone_fixo` VARCHAR(15) NULL DEFAULT NULL,
  `telefone_celular` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

CREATE TABLE IF NOT EXISTS `pi2015`.`acao` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `datainicio` DATETIME NOT NULL,
  `datafim` DATETIME NOT NULL,
  `descricao` VARCHAR(500) NULL DEFAULT NULL,
  `local` VARCHAR(300) NOT NULL,
  `latitude` DECIMAL(16,14) NULL DEFAULT NULL,
  `longitude` DECIMAL(16,14) NULL DEFAULT NULL,
  `valor` FLOAT(11) NOT NULL DEFAULT 0,
  `titulo` VARCHAR(200) NOT NULL,
  `datacriacao` DATETIME NOT NULL,
  `dataedicao` TIMESTAMP NOT NULL,
  `usuario_id` INT(11) NOT NULL,
  `tipoacao_id` INT(11) NOT NULL,
  `cliente_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_acao_usuario1_idx` (`usuario_id` ASC),
  INDEX `fk_acao_tipoacao1_idx` (`tipoacao_id` ASC),
  INDEX `fk_acao_cliente1_idx` (`cliente_id` ASC),
  CONSTRAINT `fk_acao_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `pi2015`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_acao_tipoacao1`
    FOREIGN KEY (`tipoacao_id`)
    REFERENCES `pi2015`.`tipoacao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_acao_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `pi2015`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

CREATE TABLE IF NOT EXISTS `pi2015`.`tipoacao` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  `datacriacao` DATETIME NOT NULL,
  `dataedicao` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

CREATE TABLE IF NOT EXISTS `pi2015`.`cliente` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(200) NOT NULL,
  `contato` VARCHAR(100) NOT NULL,
  `email` VARCHAR(200) NOT NULL,
  `datacriacao` DATETIME NOT NULL,
  `dataedicao` TIMESTAMP NOT NULL,
  `telefone_fixo` VARCHAR(15) NULL DEFAULT NULL,
  `telefone_celular` VARCHAR(15) NULL DEFAULT NULL,
  `fax` VARCHAR(15) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

CREATE TABLE IF NOT EXISTS `pi2015`.`usuario_acao` (
  `usuario_id` INT(11) NOT NULL,
  `acao_id` INT(11) NOT NULL,
  `confirmado` BIT(1) NOT NULL DEFAULT 0,
  `lider` BIT(1) NOT NULL DEFAULT 0,
  `datacadastro` DATETIME NOT NULL,
  `dataedicao` TIMESTAMP NOT NULL,
  PRIMARY KEY (`usuario_id`, `acao_id`),
  INDEX `fk_usuario_has_acao_acao1_idx` (`acao_id` ASC),
  INDEX `fk_usuario_has_acao_usuario1_idx` (`usuario_id` ASC),
  CONSTRAINT `fk_usuario_has_acao_usuario1`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `pi2015`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_has_acao_acao1`
    FOREIGN KEY (`acao_id`)
    REFERENCES `pi2015`.`acao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
