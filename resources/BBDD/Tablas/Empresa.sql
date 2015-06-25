CREATE TABLE `empresa` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `razon_social` varchar(45) NOT NULL,
  `domicilio` varchar(45) NOT NULL,
  `condicion_iva` varchar(45) NOT NULL,
  `cuit` int(11) NOT NULL,
  `ingresos_brutos` varchar(45) NOT NULL,
  `inicio_actividades` date NOT NULL,
  PRIMARY KEY (`id`)
)