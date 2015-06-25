CREATE TABLE `arancel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(5) NOT NULL,
  `precio_socio` decimal(6,2) DEFAULT NULL,
  `precio_no_socio` decimal(6,2) DEFAULT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
)