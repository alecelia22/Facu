CREATE TABLE `detalle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cantidad` decimal(6,2) NOT NULL,
  `precio_unitario` decimal(8,2) NOT NULL,
  `subtotal` decimal(8,2) NOT NULL,
  `id_factura` int(11) NOT NULL,
  `id_arancel` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FX_detalle_factura_idx` (`id_factura`),
  CONSTRAINT `FK_factura_detalle` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
)