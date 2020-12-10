CREATE TABLE `via` (
	`Identificador` INT(20) NOT NULL,
	`Tipo` VARCHAR(45) NOT NULL,
	`CalleCarrera` VARCHAR(10) NOT NULL,
	`Numero` INT(10) NOT NULL,
	`Congestion` DECIMAL(15,5) NOT NULL,
	PRIMARY KEY (`Identificador`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

CREATE TABLE `agente` (
	`Nombre` VARCHAR(45) NOT NULL,
	`CodigoAgente` VARCHAR(25) NOT NULL,
	`AñosExperiencia` DECIMAL(15,5) NULL DEFAULT NULL,
	`CodigoSecretaria` VARCHAR(45) NOT NULL,
	`ViaActual` INT(10) NULL DEFAULT NULL,
	PRIMARY KEY (`CodigoAgente`),
	INDEX `FK_agente_via` (`ViaActual`),
	CONSTRAINT `FK_agente_via` FOREIGN KEY (`ViaActual`) REFERENCES `via` (`Identificador`) ON UPDATE CASCADE ON DELETE CASCADE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;
