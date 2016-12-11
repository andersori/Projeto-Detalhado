-- MySQL Script generated by MySQL Workbench
-- 12/11/16 02:41:49
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema banco_pradoc
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema banco_pradoc
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `banco_pradoc` DEFAULT CHARACTER SET utf8 ;
USE `banco_pradoc` ;

-- -----------------------------------------------------
-- Table `banco_pradoc`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_pradoc`.`usuario` (
  `id` INT NOT NULL,
  `nome` VARCHAR(70) NOT NULL,
  `telefone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `cpf` VARCHAR(45) NULL,
  `username` VARCHAR(40) NOT NULL,
  `senha` VARCHAR(50) NOT NULL,
  `instituicao_ensino` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pradoc`.`arquivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_pradoc`.`arquivo` (
  `id` INT NOT NULL,
  `id_usuario` INT NULL,
  `caminho` VARCHAR(45) NULL,
  `url` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_arquivo_id_usuario_idx` (`id_usuario` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pradoc`.`evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_pradoc`.`evento` (
  `id` INT NOT NULL,
  `id_usuario_organizador` INT NOT NULL,
  `id_documento_modelo` INT NULL,
  `nome` VARCHAR(45) NULL,
  `fim_submicao` DATE NULL,
  `nota_de_aprovacao` DECIMAL(6,2) NULL,
  `descricao` TEXT(500) NULL,
  `inicio_submicao` DATE NULL,
  `inicio_avalicao` DATE NULL,
  `fim_avaliacao` DATE NULL,
  `inicio_recurso` DATE NULL,
  `fim_recurso` DATE NULL,
  `instituicao` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_evento_id_usuario_organizador_idx` (`id_usuario_organizador` ASC),
  INDEX `fk_evento_id_documento_modelo_idx` (`id_documento_modelo` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pradoc`.`area_conhecimento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_pradoc`.`area_conhecimento` (
  `id` INT NOT NULL,
  `id_evento` INT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_area_conhecimento_id_evento_idx` (`id_evento` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pradoc`.`competencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_pradoc`.`competencia` (
  `id` INT NOT NULL,
  `id_evento` INT NOT NULL,
  `titulo` VARCHAR(45) NOT NULL,
  `valor_max` DECIMAL(6,2) NOT NULL,
  `descricao` TEXT(400) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_competencia_id_evento_idx` (`id_evento` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pradoc`.`participacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_pradoc`.`participacao` (
  `id` INT NOT NULL,
  `id_evento` INT NOT NULL,
  `id_arquivo` INT NOT NULL,
  `resultado_final` DECIMAL(6,2) NULL,
  `status` VARCHAR(45) NULL,
  `valido` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_participacao_id_evento_idx` (`id_evento` ASC),
  INDEX `fk_participacao_id_arquivo_idx` (`id_arquivo` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pradoc`.`avaliacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_pradoc`.`avaliacao` (
  `id_competencia` INT NOT NULL,
  `id_participacao` INT NOT NULL,
  `valor_obtido` DECIMAL(6,2) NULL,
  `observacao` TEXT(400) NULL,
  INDEX `fk_avaliacao_id_competencia_idx` (`id_competencia` ASC),
  INDEX `fk_avaliacao_id_participacao_idx` (`id_participacao` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pradoc`.`avaliador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_pradoc`.`avaliador` (
  `id_usuario` INT NOT NULL,
  `id_evento` INT NOT NULL,
  INDEX `fk_avaliador_id_usuario_idx` (`id_usuario` ASC),
  INDEX `fk_avaliador_id_evento_idx` (`id_evento` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pradoc`.`formacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_pradoc`.`formacao` (
  `id_usuario` INT NOT NULL,
  `id_area_conhecimento` INT NULL,
  `tipo` VARCHAR(45) NULL,
  `instituicao` VARCHAR(45) NULL,
  `data_inicio` VARCHAR(45) NULL,
  `data_termino` VARCHAR(45) NULL,
  INDEX `fk_formacao_id_conhecimento_idx` (`id_area_conhecimento` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `banco_pradoc`.`email_participacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `banco_pradoc`.`email_participacao` (
  `id_participacao` INT NOT NULL,
  `email` VARCHAR(45) NULL,
  INDEX `fk_email_participacao_idx` (`id_participacao` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
