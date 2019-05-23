-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-05-2019 a las 08:42:43
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.1.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_final`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `Delete_Factura` (IN `id` INT)  NO SQL
BEGIN
DELETE FROM `linea` WHERE linea.id_factura = id;
DELETE FROM factura WHERE factura.id_factura = id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertDatos_Factura` (IN `total` INT, IN `nombre` VARCHAR(32), IN `apellidos` VARCHAR(32), IN `telefono` VARCHAR(9), IN `direccion` VARCHAR(32), IN `tarjetaCredito` VARCHAR(16))  NO SQL
BEGIN

INSERT INTO `factura`(`total`, `Nombre`, `Apellidos`, `Telefono`, `Direccion`, `tarjetaCredito`) VALUES (total, nombre, apellidos, telefono, direccion, tarjetaCredito);

SELECT LAST_INSERT_ID() as id;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InsertDatos_Lineas` (IN `id_producto` INT, IN `cantidad` INT, IN `precio` DOUBLE, IN `id_factura` INT)  NO SQL
BEGIN

INSERT INTO `linea`(`id_factura`, `id_producto`, `precio`, `cantidad`) VALUES (id_factura, id_producto, precio, cantidad);

END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `LoadData_Facturas` ()  NO SQL
SELECT * FROM `factura`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `LoadData_Lineas` ()  NO SQL
SELECT * FROM `linea`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `LoadData_Marcas` ()  NO SQL
SELECT * FROM `marca`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `LoadData_Productos` ()  NO SQL
SELECT * FROM `producto`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SelectFacture_by_Id` (IN `id` INT)  NO SQL
SELECT * FROM `factura` WHERE factura.id_factura = id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SelectProducto_by_Id` (IN `id` INT)  NO SQL
SELECT * FROM `producto` WHERE producto.id_producto = id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SelectProducts_by_Marca` (IN `id` INT)  NO SQL
SELECT * FROM `producto` WHERE producto.id_marca = id$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `id_factura` int(11) NOT NULL,
  `total` double DEFAULT NULL,
  `Nombre` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `Apellidos` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `Telefono` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `Direccion` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `tarjetaCredito` varchar(16) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`id_factura`, `total`, `Nombre`, `Apellidos`, `Telefono`, `Direccion`, `tarjetaCredito`) VALUES
(47, 22860, 'ksda', 'jdklfsdklfbsa', '12345678', '94824', '43241'),
(48, 22970, 'nombre', 'apelli2', '73137040', '2131', '43241');

--
-- Disparadores `factura`
--
DELIMITER $$
CREATE TRIGGER `factura_AD` AFTER DELETE ON `factura` FOR EACH ROW INSERT INTO `registro_factura`(`total`, `Nombre`, `Apellidos`, `Telefono`, `Direccion`, `tarjetaCredito`, `Fecha_eliminacion`, `Usuario`) VALUES (old.total, old.Nombre, old.Apellidos, old.Telefono, old.Direccion, old.tarjetaCredito, now(), CURRENT_USER)
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `linea`
--

CREATE TABLE `linea` (
  `id_linea` int(11) NOT NULL,
  `id_factura` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `precio` double DEFAULT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `linea`
--

INSERT INTO `linea` (`id_linea`, `id_factura`, `id_producto`, `precio`, `cantidad`) VALUES
(62, 47, 1, 1210, 11),
(63, 47, 3, 960, 12),
(64, 47, 2, 320, 4),
(65, 47, 4, 770, 7),
(66, 47, 6, 400, 5),
(67, 47, 5, 1980, 9),
(68, 47, 8, 1260, 7),
(69, 47, 9, 5040, 28),
(70, 47, 7, 2080, 26),
(71, 47, 11, 2720, 34),
(72, 47, 10, 6120, 34),
(73, 48, 1, 1320, 12),
(74, 48, 3, 960, 12),
(75, 48, 2, 320, 4),
(76, 48, 4, 770, 7),
(77, 48, 6, 400, 5),
(78, 48, 5, 1980, 9),
(79, 48, 8, 1260, 7),
(80, 48, 9, 5040, 28),
(81, 48, 7, 2080, 26),
(82, 48, 11, 2720, 34),
(83, 48, 10, 6120, 34);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `marca`
--

CREATE TABLE `marca` (
  `id_Marca` int(11) NOT NULL,
  `Nombre` varchar(32) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `marca`
--

INSERT INTO `marca` (`id_Marca`, `Nombre`) VALUES
(1, 'Adidas'),
(2, 'Nike'),
(3, 'Jordan'),
(4, 'Champion'),
(5, 'Yeezy'),
(6, 'Puma'),
(7, 'Rebook');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `Nombre` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `precio` double DEFAULT NULL,
  `id_marca` int(11) NOT NULL,
  `imagen` varchar(300) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id_producto`, `Nombre`, `precio`, `id_marca`, `imagen`) VALUES
(1, 'Jordan 1s', 110, 3, 'https://stockx.imgix.net/Air-Jordan-1-Retro-High-Shadow-2018-1.jpg?fit=fill&bg=FFFFFF&w=700&h=500&au'),
(2, 'Superstar ', 80, 1, 'https://assets.adidas.com/images/w_600,f_auto,q_auto/d285610e30664900b857a7fa00ed0201_9366/Zapatilla'),
(3, 'Cortes ', 80, 2, 'https://c.static-nike.com/a/images/t_PDP_1280_v1/f_auto/zsdadsgdquownvmcmt3q/classic-cortez-zapatill'),
(4, 'Eighteen classic', 110, 4, 'https://imagescdn.simons.ca/images/14699/195/10/A1_2.jpg?__=3'),
(5, 'yeezy 700', 220, 5, 'http://lojadobigode.com.br/wp-content/uploads/2019/01/yeezy-700.jpg'),
(6, 'Suede classic', 80, 6, 'https://throwback-sneakers.com/15679-large_default/puma-suede-classic-black.jpg'),
(7, 'Classic Leather', 80, 7, 'https://sgfm.elcorteingles.es/SGFM/dctm/MEDIA03/201812/07/00117731101667____11__640x640.jpg'),
(8, 'Jordan 5s', 180, 3, 'https://basketcountry.es/1905-large_default/air-jordan-5-retro.jpg'),
(9, 'UltraBoost 4.0', 180, 1, 'https://chemasport.es/13727-thickbox_default/zapatillas-adidas-ultraboost-blanco.jpg'),
(10, 'Vapormax Flyknit', 180, 2, 'https://image.tfgmedia.co.za/image/1/process/486x486?source=http://cdn.tfgmedia.co.za/06/ProductImages/31702964.jpg'),
(11, 'Rally pro', 80, 4, 'https://i1.adis.ws/i/hibbett/M0388_0201_right?w=580&h=580&fmt=jpg&bg=rgb(255,255,255)&img404=404&v=0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registro_factura`
--

CREATE TABLE `registro_factura` (
  `id_factura` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `Nombre` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `Apellidos` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `Telefono` int(11) NOT NULL,
  `Direccion` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `tarjetaCredito` int(11) NOT NULL,
  `Fecha_eliminacion` datetime NOT NULL,
  `Usuario` varchar(32) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `registro_factura`
--

INSERT INTO `registro_factura` (`id_factura`, `total`, `Nombre`, `Apellidos`, `Telefono`, `Direccion`, `tarjetaCredito`, `Fecha_eliminacion`, `Usuario`) VALUES
(1, 760, 'ksda', 'jdklfsdklfbsa', 12345678, '94824', 134, '2019-05-21 14:48:11', 'root@localhost'),
(2, 760, 'ksda', 'jdklfsdklfbsa', 12345678, '94824', 54352, '2019-05-22 09:00:50', 'root@localhost'),
(3, 760, 'ksda', 'jdklfsdklfbsa', 12345678, '94824', 32431, '2019-05-22 09:00:50', 'root@localhost'),
(4, 760, '', '', 0, '', 0, '2019-05-22 09:00:50', 'root@localhost'),
(5, 760, 'ksda', 'jdklfsdklfbsa', 12345678, '94824', 532, '2019-05-22 09:00:50', 'root@localhost'),
(6, 760, 'ksda', 'jdklfsdklfbsa', 12345678, '94824', 31543, '2019-05-22 09:00:50', 'root@localhost'),
(7, 760, 'ksda', 'jdklfsdklfbsa', 12345678, '94824', 324523, '2019-05-22 09:00:50', 'root@localhost'),
(8, 760, 'Asier', 'Gusmano Rodriguez', 12345678, 'Su puta casa', 312423532, '2019-05-22 09:04:08', 'root@localhost'),
(9, 22750, 'Asier', 'Gusmano Rodriguez', 12345678, 'Sillycon Valley', 254252, '2019-05-22 09:09:58', 'root@localhost'),
(10, 22750, 'ksda', 'jdklfsdklfbsa', 12345678, '94824', 65345, '2019-05-22 09:17:17', 'root@localhost'),
(11, 22750, 'ksda', 'jdklfsdklfbsa', 12345678, '94824', 123425, '2019-05-22 09:17:17', 'root@localhost'),
(12, 22750, 'ksda', 'jdklfsdklfbsa', 12345678, '94824', 123425, '2019-05-22 09:19:10', 'root@localhost'),
(13, 22750, 'ksda', 'jdklfsdklfbsa', 12345678, '94824', 123425, '2019-05-22 09:19:15', 'root@localhost');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`id_factura`);

--
-- Indices de la tabla `linea`
--
ALTER TABLE `linea`
  ADD PRIMARY KEY (`id_linea`),
  ADD KEY `id_factura` (`id_factura`),
  ADD KEY `id_producto` (`id_producto`);

--
-- Indices de la tabla `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`id_Marca`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `id_filtros` (`id_marca`),
  ADD KEY `Marca` (`id_marca`);

--
-- Indices de la tabla `registro_factura`
--
ALTER TABLE `registro_factura`
  ADD PRIMARY KEY (`id_factura`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `id_factura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT de la tabla `linea`
--
ALTER TABLE `linea`
  MODIFY `id_linea` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT de la tabla `marca`
--
ALTER TABLE `marca`
  MODIFY `id_Marca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `registro_factura`
--
ALTER TABLE `registro_factura`
  MODIFY `id_factura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `linea`
--
ALTER TABLE `linea`
  ADD CONSTRAINT `linea_ibfk_2` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id_factura`),
  ADD CONSTRAINT `linea_ibfk_3` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`id_marca`) REFERENCES `marca` (`id_Marca`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
