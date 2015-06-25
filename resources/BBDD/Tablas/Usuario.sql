CREATE TABLE `lsc_schema`.`usuario` (
  `id` BIGINT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellido` VARCHAR(45) NOT NULL,
  `usuario` VARCHAR(15) NOT NULL,
  `password` VARCHAR(16) NOT NULL,
  `rol` VARCHAR(10) NOT NULL,
  `activo` INT(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));