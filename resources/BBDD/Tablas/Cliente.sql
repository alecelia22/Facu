CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cuit` int(11) NOT NULL,
  `razon social` varchar(45) NOT NULL,
  `condicion_iva` varchar(45) NOT NULL,
  `domicilio` varchar(45) NOT NULL,
  `condicion_venta` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
)