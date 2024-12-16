-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-10-2019 a las 20:46:35
-- Versión del servidor: 5.5.32
-- Versión de PHP: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `codigo`
--
CREATE DATABASE IF NOT EXISTS `codigo` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `codigo`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `representacion`
--

CREATE TABLE IF NOT EXISTS `representacion` (
  `caracter` varchar(1) NOT NULL,
  `traduccion` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `representacion`
--

INSERT INTO `representacion` (`caracter`, `traduccion`) VALUES
('A', '220'),
('B', '230'),
('C', '0040'),
('D', '250'),
('E', '3000'),
('F', '330'),
('G', '01100'),
('H', '350'),
('I', '420'),
('J', '1030'),
('K', '440'),
('L', '450'),
('M', '520'),
('N', '530'),
('O', '11100'),
('P', '550'),
('Q', '221'),
('R', '231'),
('S', '0041'),
('T', '251'),
('U', '01001'),
('V', '331'),
('W', '341'),
('X', '351'),
('Y', '421'),
('Z', '4011'),
(' ', '441'),
('.', '451'),
(',', '521'),
(':', '1131'),
('!', '541'),
('?', '551'),
('0', '0'),
('1', '1'),
('2', '00'),
('3', '01'),
('4', '10'),
('5', '11');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
