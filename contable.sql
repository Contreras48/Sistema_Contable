-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 28-11-2017 a las 21:35:40
-- Versión del servidor: 5.7.20
-- Versión de PHP: 7.0.25-1+0~20171027135825.8+stretch~1.gbp75b787

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `contable`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Cuenta`
--

CREATE TABLE `Cuenta` (
  `codigo` int(11) NOT NULL,
  `id_tipo` int(11) DEFAULT NULL,
  `nombre` varchar(60) NOT NULL,
  `balance` int(1) NOT NULL,
  `descripcion` varchar(75) DEFAULT NULL,
  `saldo` float(10,2) DEFAULT NULL,
  `tipo_saldo` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Detalle_Libro_Diario`
--

CREATE TABLE `Detalle_Libro_Diario` (
  `id_movimiento` int(11) NOT NULL,
  `partida` int(11) NOT NULL,
  `codigo` int(11) NOT NULL,
  `cargo` float(10,2) DEFAULT NULL,
  `abono` float(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Libro_Diario`
--

CREATE TABLE `Libro_Diario` (
  `partida` int(11) NOT NULL,
  `fecha` varchar(12) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Saldo`
--

CREATE TABLE `Saldo` (
  `id` int(1) NOT NULL,
  `tipo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Saldo`
--

INSERT INTO `Saldo` (`id`, `tipo`) VALUES
(0, 'Deudor'),
(1, 'Acreedor');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Tipo_Balance`
--

CREATE TABLE `Tipo_Balance` (
  `tipo` int(1) NOT NULL,
  `balance` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Tipo_Balance`
--

INSERT INTO `Tipo_Balance` (`tipo`, `balance`) VALUES
(1, 'Normal'),
(2, 'Ajuste');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Tipo_Cuenta`
--

CREATE TABLE `Tipo_Cuenta` (
  `id_tipo` int(11) NOT NULL,
  `nombre_tipo` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `Tipo_Cuenta`
--

INSERT INTO `Tipo_Cuenta` (`id_tipo`, `nombre_tipo`) VALUES
(1, 'Activo'),
(2, 'Pasivo'),
(3, 'Capital'),
(4, 'Ingresos'),
(5, 'Gastos'),
(6, 'Retiros');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Cuenta`
--
ALTER TABLE `Cuenta`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `codigo` (`codigo`),
  ADD KEY `id_tipo` (`id_tipo`),
  ADD KEY `balance` (`balance`),
  ADD KEY `id` (`tipo_saldo`);

--
-- Indices de la tabla `Detalle_Libro_Diario`
--
ALTER TABLE `Detalle_Libro_Diario`
  ADD PRIMARY KEY (`id_movimiento`),
  ADD KEY `partida` (`partida`),
  ADD KEY `codigo` (`codigo`);

--
-- Indices de la tabla `Libro_Diario`
--
ALTER TABLE `Libro_Diario`
  ADD PRIMARY KEY (`partida`);

--
-- Indices de la tabla `Saldo`
--
ALTER TABLE `Saldo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `Tipo_Balance`
--
ALTER TABLE `Tipo_Balance`
  ADD PRIMARY KEY (`tipo`);

--
-- Indices de la tabla `Tipo_Cuenta`
--
ALTER TABLE `Tipo_Cuenta`
  ADD PRIMARY KEY (`id_tipo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Detalle_Libro_Diario`
--
ALTER TABLE `Detalle_Libro_Diario`
  MODIFY `id_movimiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `Tipo_Cuenta`
--
ALTER TABLE `Tipo_Cuenta`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Cuenta`
--
ALTER TABLE `Cuenta`
  ADD CONSTRAINT `Cuenta_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `Tipo_Cuenta` (`id_tipo`),
  ADD CONSTRAINT `Cuenta_ibfk_2` FOREIGN KEY (`balance`) REFERENCES `Tipo_Balance` (`tipo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Cuenta_ibfk_3` FOREIGN KEY (`tipo_saldo`) REFERENCES `Saldo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Detalle_Libro_Diario`
--
ALTER TABLE `Detalle_Libro_Diario`
  ADD CONSTRAINT `Detalle_Libro_Diario_ibfk_1` FOREIGN KEY (`partida`) REFERENCES `Libro_Diario` (`partida`),
  ADD CONSTRAINT `Detalle_Libro_Diario_ibfk_2` FOREIGN KEY (`codigo`) REFERENCES `Cuenta` (`codigo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
