-- phpMyAdmin SQL Dump
-- version 4.0.10.10
-- http://www.phpmyadmin.net
--
-- Servidor: 127.5.139.130:3306
-- Tempo de Geração: 25/11/2015 às 21:17
-- Versão do servidor: 5.5.45
-- Versão do PHP: 5.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de dados: `acoesdb`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `acao`
--

CREATE TABLE IF NOT EXISTS `acao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `datainicio` datetime NOT NULL,
  `datafim` datetime NOT NULL,
  `descricao` varchar(500) COLLATE utf8_bin DEFAULT NULL,
  `local` varchar(300) COLLATE utf8_bin NOT NULL,
  `latitude` decimal(16,14) DEFAULT NULL,
  `longitude` decimal(16,14) DEFAULT NULL,
  `valor` float NOT NULL DEFAULT '0',
  `titulo` varchar(200) COLLATE utf8_bin NOT NULL,
  `datacriacao` datetime NOT NULL,
  `dataedicao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario_id` int(11) NOT NULL,
  `tipoacao_id` int(11) DEFAULT NULL,
  `cliente_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_acao_usuario1_idx` (`usuario_id`),
  KEY `fk_acao_tipoacao1_idx` (`tipoacao_id`),
  KEY `fk_acao_cliente1_idx` (`cliente_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura para tabela `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) COLLATE utf8_bin NOT NULL,
  `contato` varchar(100) COLLATE utf8_bin NOT NULL,
  `email` varchar(200) COLLATE utf8_bin NOT NULL,
  `datacriacao` datetime NOT NULL,
  `dataedicao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `telefone_fixo` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `telefone_celular` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `fax` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=4 ;

--
-- Fazendo dump de dados para tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `contato`, `email`, `datacriacao`, `dataedicao`, `telefone_fixo`, `telefone_celular`, `fax`) VALUES
(2, 'Viva Salute', 'Everton', 'contato@viva.com', '2015-11-23 15:23:48', '2015-11-23 18:24:22', '(71) 33333333', '(71) 99999999', '(71) 55555555'),
(3, 'WGBN Software House', 'Walter', 'contato@wgbn.com.br', '2015-11-25 07:26:02', '2015-11-25 12:26:34', '(71) 35080443', '(71) 992053595', '');

-- --------------------------------------------------------

--
-- Estrutura para tabela `tipoacao`
--

CREATE TABLE IF NOT EXISTS `tipoacao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) COLLATE utf8_bin NOT NULL,
  `datacriacao` datetime NOT NULL,
  `dataedicao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=2 ;

--
-- Fazendo dump de dados para tabela `tipoacao`
--

INSERT INTO `tipoacao` (`id`, `tipo`, `datacriacao`, `dataedicao`) VALUES
(1, 'Degustação', '2015-11-10 00:00:00', '2015-11-24 10:43:07');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) COLLATE utf8_bin NOT NULL,
  `email` varchar(200) COLLATE utf8_bin NOT NULL,
  `senha` varchar(128) COLLATE utf8_bin NOT NULL,
  `banco` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `agencia` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `conta` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `gerente` tinyint(1) NOT NULL DEFAULT '0',
  `datacriacao` datetime NOT NULL,
  `dataedicao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `telefone_fixo` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `telefone_celular` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=6 ;

--
-- Fazendo dump de dados para tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `email`, `senha`, `banco`, `agencia`, `conta`, `gerente`, `datacriacao`, `dataedicao`, `telefone_fixo`, `telefone_celular`) VALUES
(3, 'Walter Gandarella', 'walter.wgbn@gmail.com', '8D969EEF6ECAD3C29A3A629280E686CF0C3F5D5A86AFF3CA12020C923ADC6C92', 'Caixa', '2789', '013-2789-8', 1, '2015-11-23 10:31:10', '2015-11-23 13:32:09', '71 35080443', '71 92053595'),
(4, 'Theo Gandarella', 'wgbn.theo@gmail.com', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 'Santander', '1234', '123-4', 0, '2015-11-23 11:42:02', '2015-11-23 14:42:32', '(71) 35080443', '(71) 982500599');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario_acao`
--

CREATE TABLE IF NOT EXISTS `usuario_acao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` int(11) NOT NULL,
  `acao_id` int(11) NOT NULL,
  `confirmado` tinyint(1) NOT NULL DEFAULT '0',
  `lider` tinyint(1) NOT NULL DEFAULT '0',
  `datacadastro` datetime NOT NULL,
  `dataedicao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_usuario_has_acao_acao1_idx` (`acao_id`),
  KEY `fk_usuario_has_acao_usuario1_idx` (`usuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `acao`
--
ALTER TABLE `acao`
  ADD CONSTRAINT `fk_acao_cliente1` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_acao_tipoacao1` FOREIGN KEY (`tipoacao_id`) REFERENCES `tipoacao` (`id`) ON DELETE SET NULL ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_acao_usuario1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Restrições para tabelas `usuario_acao`
--
ALTER TABLE `usuario_acao`
  ADD CONSTRAINT `fk_usuario_has_acao_acao1` FOREIGN KEY (`acao_id`) REFERENCES `acao` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuario_has_acao_usuario1` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
