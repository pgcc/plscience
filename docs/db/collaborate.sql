-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 31/01/2014 às 19h09min
-- Versão do Servidor: 5.5.35
-- Versão do PHP: 5.3.10-1ubuntu3.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `collaborate`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `Adminuser`
--

CREATE TABLE IF NOT EXISTS `Adminuser` (
  `idAdminuser` int(11) NOT NULL AUTO_INCREMENT,
  `nameScientist` varchar(100) NOT NULL,
  `login` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `CPF` varchar(100) NOT NULL,
  `E-mail` varchar(100) NOT NULL,
  `institution` varchar(100) NOT NULL,
  PRIMARY KEY (`idAdminuser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Extraindo dados da tabela `Adminuser`
--

INSERT INTO `Adminuser` (`idAdminuser`, `nameScientist`, `login`, `password`, `CPF`, `E-mail`, `institution`) VALUES
(5, 'ADMINISTRADOR', 'admin', '202cb962ac59075b964b07152d234b70', '01934617733', 'dignus07@gmail.com', 'UFJF');

-- --------------------------------------------------------

--
-- Estrutura da tabela `Artifact`
--

CREATE TABLE IF NOT EXISTS `Artifact` (
  `idArtifact` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `Purpose` varchar(250) DEFAULT NULL,
  `Local` varchar(200) NOT NULL,
  `Status` varchar(45) NOT NULL,
  `type` varchar(100) NOT NULL,
  `artifactType` char(1) NOT NULL,
  PRIMARY KEY (`idArtifact`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Extraindo dados da tabela `Artifact`
--

INSERT INTO `Artifact` (`idArtifact`, `Name`, `Purpose`, `Local`, `Status`, `type`, `artifactType`) VALUES
(1, 'SequenceAligningFeatureModel', 'Modelo de Features sobre Alinhamento de Sequencia', 'http://plscience.superdignus.com/SequenceAligningFeatureModelv1b.xml', '1', 'FeatureModel', 'W'),
(2, 'SequenceAligningMapping', 'Mapear as features nas classes da Ontologia', 'http://plscience.superdignus.com/SequenceAligningMappingv1b.xml', '1', 'MappingFile', 'W'),
(3, 'SequenceAligningOntology', 'Ontologia sobre alinhamento de Sequencia', 'http://plscience.superdignus.com/SequenceAligningOntologyv1b.owl', '1', 'Ontology', 'W'),
(4, 'BioinformaticFeatureModel', 'Criar workflows para o domínio de Bioinformática', '/PL-Science/backup/SequenceAligningFeatureModelv2.xml', '1', 'FeatureModel', 'L'),
(5, 'BioinformaticMappingFile', 'Mapear as features do modelo nas classes da Ontologia', '/PL-Science/backup/SequenceAligningMappingv2.xml', '1', 'MappingFile', 'L'),
(6, 'BioinformaticOntology', 'Ontologia sobre Bioinformática', '/PL-Science/backup/SequenceAligningOntologyv2.owl', '1', 'Ontology', 'L');

-- --------------------------------------------------------

--
-- Estrutura da tabela `ArtifactsUsed`
--

CREATE TABLE IF NOT EXISTS `ArtifactsUsed` (
  `idArtifactUsed` int(11) NOT NULL AUTO_INCREMENT,
  `idWhere` int(11) NOT NULL,
  `idArtifact` int(11) NOT NULL,
  `idRationale` int(11) NOT NULL,
  PRIMARY KEY (`idArtifactUsed`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=101 ;

--
-- Extraindo dados da tabela `ArtifactsUsed`
--

INSERT INTO `ArtifactsUsed` (`idArtifactUsed`, `idWhere`, `idArtifact`, `idRationale`) VALUES
(1, 1, 3, 1),
(2, 1, 1, 0),
(3, 1, 2, 0),
(4, 1, 3, 0),
(5, 2, 1, 0),
(6, 2, 2, 0),
(7, 2, 3, 0),
(8, 3, 1, 0),
(9, 3, 2, 0),
(10, 3, 3, 0),
(11, 4, 1, 0),
(12, 4, 2, 0),
(13, 4, 3, 0),
(14, 5, 1, 0),
(15, 5, 2, 0),
(16, 5, 3, 0),
(17, 6, 1, 0),
(18, 6, 2, 0),
(19, 6, 3, 0),
(20, 7, 1, 0),
(21, 7, 2, 0),
(22, 7, 3, 0),
(23, 8, 1, 0),
(24, 8, 2, 0),
(25, 8, 3, 0),
(26, 9, 1, 0),
(27, 9, 2, 0),
(28, 9, 3, 0),
(29, 10, 1, 0),
(30, 10, 2, 0),
(31, 10, 3, 0),
(32, 11, 1, 0),
(33, 11, 2, 0),
(34, 11, 3, 0),
(35, 12, 1, 0),
(36, 12, 2, 0),
(37, 12, 3, 0),
(38, 13, 1, 0),
(39, 13, 2, 0),
(40, 13, 3, 0),
(41, 14, 1, 14),
(42, 14, 2, 14),
(43, 14, 3, 14),
(44, 16, 1, 16),
(45, 16, 2, 16),
(46, 16, 3, 16),
(47, 17, 1, 17),
(48, 17, 2, 17),
(49, 17, 3, 17),
(50, 18, 1, 18),
(51, 18, 2, 18),
(52, 18, 3, 18),
(53, 19, 1, 19),
(54, 19, 2, 19),
(55, 19, 3, 19),
(56, 20, 1, 20),
(57, 20, 2, 20),
(58, 20, 3, 20),
(59, 21, 1, 21),
(60, 21, 2, 21),
(61, 21, 3, 21),
(62, 22, 1, 22),
(63, 22, 2, 22),
(64, 22, 3, 22),
(65, 23, 1, 23),
(66, 23, 2, 23),
(67, 23, 3, 23),
(68, 24, 1, 24),
(69, 24, 2, 24),
(70, 24, 3, 24),
(71, 25, 1, 25),
(72, 25, 2, 25),
(73, 25, 3, 25),
(74, 26, 1, 26),
(75, 26, 2, 26),
(76, 26, 3, 26),
(77, 27, 1, 27),
(78, 27, 2, 27),
(79, 27, 3, 27),
(80, 28, 1, 28),
(81, 28, 2, 28),
(82, 28, 3, 28),
(83, 29, 1, 29),
(84, 29, 2, 29),
(85, 29, 3, 29),
(86, 30, 1, 30),
(87, 30, 2, 30),
(88, 30, 3, 30),
(89, 31, 1, 31),
(90, 31, 2, 31),
(91, 31, 3, 31),
(92, 32, 1, 32),
(93, 32, 2, 32),
(94, 32, 3, 32),
(95, 33, 1, 33),
(96, 33, 2, 33),
(97, 33, 3, 33),
(98, 34, 1, 34),
(99, 34, 2, 34),
(100, 34, 3, 34);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Communication`
--

CREATE TABLE IF NOT EXISTS `Communication` (
  `idComunication` int(11) NOT NULL AUTO_INCREMENT,
  `message` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci,
  `idRationale` int(11) NOT NULL,
  `Subfeature` varchar(200) DEFAULT NULL,
  `idScientist_Receptor` int(11) NOT NULL,
  `idScientist_Emissor` int(11) NOT NULL,
  `data` varchar(20) NOT NULL,
  `hora` varchar(20) NOT NULL,
  `lidaSN` int(1) NOT NULL,
  PRIMARY KEY (`idComunication`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=12 ;

--
-- Extraindo dados da tabela `Communication`
--

INSERT INTO `Communication` (`idComunication`, `message`, `idRationale`, `Subfeature`, `idScientist_Receptor`, `idScientist_Emissor`, `data`, `hora`, `lidaSN`) VALUES
(1, 'Rolezinho', 2, NULL, 5, 7, '27/01/2014', '16:58:44', 1),
(2, 'aadfasdfasdfasd', 24, NULL, 7, 1, '28/01/2014', '17:40:49', 0),
(3, 'Testando a Regina', 27, NULL, 7, 1, '30/01/2014', '10:6:38', 0),
(4, 'Magnus', 24, NULL, 0, 7, '30/01/2014', '10:8', 1),
(5, 'OlÃ¡ Camarada viva o linux', 27, NULL, 1, 7, '30/01/2014', '10:34:15', 0),
(6, 'Fernanda use o Linux!', 27, NULL, 9, 1, '30/01/2014', '10:44:58', 0),
(7, 'universodasandra@gmail.com', 27, NULL, 12, 9, '30/01/2014', '10:46:39', 0),
(8, 'Raphael cpf cof como vai?', 27, NULL, 6, 7, '30/01/2014', '13:30:3', 1),
(9, 'sim sim', 24, NULL, 0, 7, '31/01/2014', '12:5:47', 1),
(10, 'Oi Window Ã© 10 desavergonhado', 27, NULL, 5, 1, '31/01/2014', '14:12:1', 1),
(11, 'Oi Fernanda!', 27, NULL, 9, 1, '31/01/2014', '14:13:38', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `HowTable`
--

CREATE TABLE IF NOT EXISTS `HowTable` (
  `idHow` int(11) NOT NULL AUTO_INCREMENT,
  `description` longtext COMMENT 'Opção escolhida pelo usuário (caminho percorrido)',
  PRIMARY KEY (`idHow`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=35 ;

--
-- Extraindo dados da tabela `HowTable`
--

INSERT INTO `HowTable` (`idHow`, `description`) VALUES
(1, 'akamjanhab'),
(2, NULL),
(3, NULL),
(4, NULL),
(5, NULL),
(6, NULL),
(7, NULL),
(8, NULL),
(9, NULL),
(10, NULL),
(11, NULL),
(12, NULL),
(13, NULL),
(14, NULL),
(15, NULL),
(16, NULL),
(17, NULL),
(18, 'SEQUENCEALIGNING >>> APPLICATION_TYPE >>> ISOLATED_APPLICATION >>> SEQUENCING_PLATFORM >>> SANGER >>> BIOINFORMATICS_TASK >>> BASE_CALLING >>> '),
(19, NULL),
(20, NULL),
(21, NULL),
(22, 'SEQUENCEALIGNING >>> APPLICATION_TYPE >>> ISOLATED_APPLICATION >>> SEQUENCING_PLATFORM >>> SANGER >>> BIOINFORMATICS_TASK >>> BASE_CALLING >>> '),
(23, NULL),
(24, NULL),
(25, NULL),
(26, NULL),
(27, NULL),
(28, NULL),
(29, NULL),
(30, NULL),
(31, NULL),
(32, NULL),
(33, 'SEQUENCEALIGNING >>> APPLICATION_TYPE >>> ISOLATED_APPLICATION >>> SEQUENCING_PLATFORM >>> SANGER >>> BIOINFORMATICS_TASK >>> BASE_CALLING >>> '),
(34, 'SEQUENCEALIGNING >>> APPLICATION_TYPE >>> ISOLATED_APPLICATION >>> SEQUENCING_PLATFORM >>> SANGER >>> BIOINFORMATICS_TASK >>> BASE_CALLING >>> ');

-- --------------------------------------------------------

--
-- Estrutura da tabela `Notes`
--

CREATE TABLE IF NOT EXISTS `Notes` (
  `idNotes` int(11) NOT NULL AUTO_INCREMENT,
  `Description` longtext NOT NULL,
  `Subfeatures` varchar(200) DEFAULT NULL,
  `idRationale` int(11) NOT NULL,
  PRIMARY KEY (`idNotes`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Extraindo dados da tabela `Notes`
--

INSERT INTO `Notes` (`idNotes`, `Description`, `Subfeatures`, `idRationale`) VALUES
(1, 'asdfasdfasdfasdf', NULL, 2),
(2, 'dsddf', NULL, 24);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Rationale`
--

CREATE TABLE IF NOT EXISTS `Rationale` (
  `idRationale` int(11) NOT NULL AUTO_INCREMENT,
  `idWho` int(11) NOT NULL,
  `idWhen` int(11) NOT NULL,
  `idWhere` int(11) NOT NULL,
  `idWhat` int(11) NOT NULL,
  `idHow` int(11) NOT NULL,
  `idNewRationale` int(11) DEFAULT NULL,
  PRIMARY KEY (`idRationale`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=35 ;

--
-- Extraindo dados da tabela `Rationale`
--

INSERT INTO `Rationale` (`idRationale`, `idWho`, `idWhen`, `idWhere`, `idWhat`, `idHow`, `idNewRationale`) VALUES
(1, 1, 1, 1, 1, 1, NULL),
(2, 2, 2, 2, 2, 2, NULL),
(3, 3, 3, 3, 3, 3, NULL),
(4, 4, 4, 4, 4, 4, NULL),
(5, 5, 5, 5, 5, 5, NULL),
(6, 6, 6, 6, 6, 6, NULL),
(7, 7, 7, 7, 7, 7, NULL),
(8, 8, 8, 8, 8, 8, NULL),
(9, 9, 9, 9, 9, 9, NULL),
(10, 10, 10, 10, 10, 10, NULL),
(11, 11, 11, 11, 11, 11, NULL),
(12, 12, 12, 12, 12, 12, NULL),
(13, 13, 13, 13, 13, 13, NULL),
(14, 14, 14, 14, 14, 14, NULL),
(15, 15, 15, 15, 15, 15, NULL),
(16, 16, 16, 16, 16, 16, NULL),
(17, 17, 17, 17, 17, 17, NULL),
(18, 18, 18, 18, 18, 18, NULL),
(19, 19, 19, 19, 19, 19, NULL),
(20, 20, 20, 20, 20, 20, NULL),
(21, 21, 21, 21, 21, 21, NULL),
(22, 22, 22, 22, 22, 22, NULL),
(23, 23, 23, 23, 23, 23, NULL),
(24, 24, 24, 24, 24, 24, NULL),
(25, 25, 25, 25, 25, 25, NULL),
(26, 26, 26, 26, 26, 26, NULL),
(27, 27, 27, 27, 27, 27, NULL),
(28, 28, 28, 28, 28, 28, NULL),
(29, 29, 29, 29, 29, 29, NULL),
(30, 30, 30, 30, 30, 30, NULL),
(31, 31, 31, 31, 31, 31, NULL),
(32, 32, 32, 32, 32, 32, NULL),
(33, 33, 33, 33, 33, 33, NULL),
(34, 34, 34, 34, 34, 34, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `Roles`
--

CREATE TABLE IF NOT EXISTS `Roles` (
  `role_id` int(11) NOT NULL,
  `role_description` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `Roles`
--

INSERT INTO `Roles` (`role_id`, `role_description`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER'),
(3, 'ROLE_ADMIN_USER');

-- --------------------------------------------------------

--
-- Estrutura da tabela `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `idScientist` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `login` varchar(32) NOT NULL,
  `password` varchar(45) NOT NULL,
  `NameScientist` varchar(100) DEFAULT NULL,
  `CPFScientist` varchar(45) DEFAULT NULL,
  `emailScientist` varchar(100) DEFAULT NULL,
  `InstitutionScientist` varchar(100) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idScientist`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Extraindo dados da tabela `User`
--

INSERT INTO `User` (`idScientist`, `role_id`, `login`, `password`, `NameScientist`, `CPFScientist`, `emailScientist`, `InstitutionScientist`, `Status`) VALUES
(1, 3, 'magnus', '55e9259a444abe5d9e63f18de4627051', 'Magnus Ribeiro', '28734305408', 'dignus07@gmail.com', 'UFJF', '1'),
(5, 3, 'Jonathan', '202cb962ac59075b964b07152d234b70', 'Jonathan', '24188614579', 'jsmuniz7@yahoo.com', 'UFJF', '1'),
(6, 2, 'Raphael', '202cb962ac59075b964b07152d234b70', 'Raphael', '66252683647', 'raphael@gmail.com', 'UFJF', '1'),
(7, 2, 'Regina', '202cb962ac59075b964b07152d234b70', 'Regina Braga', '68983525711', 'regina@acessa.com', 'UFJF', '1'),
(8, 2, 'jose_maria', '202cb962ac59075b964b07152d234b70', 'José Maria David', '18404276471', 'jmdavid@gmail.com', 'UFJF', '1'),
(9, 2, 'Fernanda', '202cb962ac59075b964b07152d234b70', 'Fernanda Campos', '48487895670', 'fernanda.campos@ufjf.edu.br', 'UFJF', '1'),
(10, 2, 'manoel', 'd5238ce9d8378a7315caee97b49a0ccf', 'Manoel Francisco de Miranda', '01982982734', 'manoel@filirmino', 'UFJF', '1'),
(11, 2, 'kibe', 'cf2942adf455d9672c0824e3c7609c1e', 'Francisco de Assis', '3983763542', 'frabcisco@gmail.com', 'UFJF', '1'),
(12, 2, 'sandra', 'f40a37048732da05928c3d374549c832', 'Sandra Ribeiro', '0928726521', 'univerdosa@gmail.com', 'ufjf', '1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `WhatTable`
--

CREATE TABLE IF NOT EXISTS `WhatTable` (
  `idWhat` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(200) NOT NULL,
  `ProductName` varchar(80) DEFAULT NULL,
  `PurposeProduct` longtext,
  `urlProduct` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idWhat`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=35 ;

--
-- Extraindo dados da tabela `WhatTable`
--

INSERT INTO `WhatTable` (`idWhat`, `description`, `ProductName`, `PurposeProduct`, `urlProduct`) VALUES
(1, 'EDIT ARTIFACT', NULL, NULL, NULL),
(2, 'PRODUCT DEVELOPMENT', 'ddd', 'ss', NULL),
(3, 'PRODUCT DEVELOPMENT', 'a', 'a', NULL),
(4, 'PRODUCT DEVELOPMENT', 'aa', 'aa', NULL),
(5, 'PRODUCT DEVELOPMENT', 'z', 'z', NULL),
(6, 'PRODUCT DEVELOPMENT', 'z', 'z', NULL),
(7, 'PRODUCT DEVELOPMENT', 'a', 'a', NULL),
(8, 'PRODUCT DEVELOPMENT', 'ss', 'ss', NULL),
(9, 'PRODUCT DEVELOPMENT', 'ss', 'bb', NULL),
(10, 'PRODUCT DEVELOPMENT', 'ddd', 'dd', NULL),
(11, 'PRODUCT DEVELOPMENT', 'xax', 'ax', NULL),
(12, 'PRODUCT DEVELOPMENT', 'a', 'a', NULL),
(13, 'PRODUCT DEVELOPMENT', 'a', 'a', NULL),
(14, 'PRODUCT DEVELOPMENT', 'SS', 'SS', NULL),
(15, 'PRODUCT DEVELOPMENT', 'ss', 'sss', NULL),
(16, 'PRODUCT DEVELOPMENT', 'd', 'd', NULL),
(17, 'PRODUCT DEVELOPMENT', 'a', 'a', NULL),
(18, 'PRODUCT DEVELOPMENT', 'ddd', 'ddd', '/PL-Science/backup/'),
(19, 'PRODUCT DEVELOPMENT', 'ee', 'ee', NULL),
(20, 'PRODUCT DEVELOPMENT', 'ee', 'ee', NULL),
(21, 'PRODUCT DEVELOPMENT', 'aa', 'aa', NULL),
(22, 'PRODUCT DEVELOPMENT', '22', '22', '/PL-Science/backup/'),
(23, 'PRODUCT DEVELOPMENT', 'SSs', 'ss', NULL),
(24, 'PRODUCT DEVELOPMENT', 'sws', 'swsw', NULL),
(25, 'PRODUCT DEVELOPMENT', 'dd', 'dd', NULL),
(26, 'PRODUCT DEVELOPMENT', 'sdfg', 'sdfgs', NULL),
(27, 'PRODUCT DEVELOPMENT', 'sdfg', 'sdfgs', NULL),
(28, 'PRODUCT DEVELOPMENT', 'a', 'aa', NULL),
(29, 'PRODUCT DEVELOPMENT', 'DC', 'CDC', NULL),
(30, 'PRODUCT DEVELOPMENT', 'wdwd', 'wdwdwd', NULL),
(31, 'PRODUCT DEVELOPMENT', 'wdwd', 'wdwdwd', NULL),
(32, 'PRODUCT DEVELOPMENT', 'ee', 'ee', NULL),
(33, 'PRODUCT DEVELOPMENT', 'ddd', 'ss', '/PL-Science/backup/'),
(34, 'PRODUCT DEVELOPMENT', 'ss', 'ss', '/PL-Science/backup/');

-- --------------------------------------------------------

--
-- Estrutura da tabela `WhenTable`
--

CREATE TABLE IF NOT EXISTS `WhenTable` (
  `idWhen` int(11) NOT NULL AUTO_INCREMENT,
  `day` int(11) DEFAULT NULL,
  `month` int(11) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `minute` int(11) DEFAULT NULL,
  PRIMARY KEY (`idWhen`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=35 ;

--
-- Extraindo dados da tabela `WhenTable`
--

INSERT INTO `WhenTable` (`idWhen`, `day`, `month`, `year`, `time`, `minute`) VALUES
(1, 27, 1, 14, 14, 16),
(2, 27, 1, 2014, 16, 55),
(3, 27, 1, 2014, 16, 57),
(4, 27, 1, 2014, 17, 2),
(5, 27, 1, 2014, 17, 5),
(6, 27, 1, 2014, 17, 11),
(7, 27, 1, 2014, 17, 22),
(8, 27, 1, 2014, 17, 55),
(9, 27, 1, 2014, 18, 0),
(10, 27, 1, 2014, 18, 4),
(11, 27, 1, 2014, 18, 11),
(12, 28, 1, 2014, 12, 46),
(13, 28, 1, 2014, 13, 28),
(14, 28, 1, 2014, 13, 36),
(15, 28, 1, 2014, 13, 58),
(16, 28, 1, 2014, 14, 10),
(17, 28, 1, 2014, 14, 20),
(18, 28, 1, 2014, 15, 31),
(19, 28, 1, 2014, 16, 40),
(20, 28, 1, 2014, 16, 42),
(21, 28, 1, 2014, 16, 43),
(22, 28, 1, 2014, 17, 6),
(23, 28, 1, 2014, 17, 17),
(24, 28, 1, 2014, 17, 22),
(25, 28, 1, 2014, 17, 38),
(26, 30, 1, 2014, 9, 58),
(27, 30, 1, 2014, 9, 59),
(28, 30, 1, 2014, 10, 5),
(29, 30, 1, 2014, 13, 19),
(30, 31, 1, 2014, 12, 6),
(31, 31, 1, 2014, 12, 7),
(32, 31, 1, 2014, 12, 16),
(33, 31, 1, 2014, 13, 55),
(34, 31, 1, 2014, 14, 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `WhereTable`
--

CREATE TABLE IF NOT EXISTS `WhereTable` (
  `idWhere` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID_Artefato',
  PRIMARY KEY (`idWhere`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=35 ;

--
-- Extraindo dados da tabela `WhereTable`
--

INSERT INTO `WhereTable` (`idWhere`) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7),
(8),
(9),
(10),
(11),
(12),
(13),
(14),
(15),
(16),
(17),
(18),
(19),
(20),
(21),
(22),
(23),
(24),
(25),
(26),
(27),
(28),
(29),
(30),
(31),
(32),
(33),
(34);

-- --------------------------------------------------------

--
-- Estrutura da tabela `WhoTable`
--

CREATE TABLE IF NOT EXISTS `WhoTable` (
  `idWho` int(11) NOT NULL AUTO_INCREMENT,
  `idScientist` int(11) NOT NULL COMMENT 'Saber QUEM é o Cientista Logado na Aplicação que está realizando a operação.',
  PRIMARY KEY (`idWho`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=35 ;

--
-- Extraindo dados da tabela `WhoTable`
--

INSERT INTO `WhoTable` (`idWho`, `idScientist`) VALUES
(1, 1),
(2, 1),
(3, 7),
(4, 5),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(11, 1),
(12, 1),
(13, 1),
(14, 1),
(15, 1),
(16, 7),
(17, 1),
(18, 1),
(19, 1),
(20, 1),
(21, 1),
(22, 9),
(23, 7),
(24, 1),
(25, 1),
(26, 1),
(27, 1),
(28, 1),
(29, 1),
(30, 7),
(31, 7),
(32, 7),
(33, 1),
(34, 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
