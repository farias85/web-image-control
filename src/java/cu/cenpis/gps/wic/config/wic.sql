# SQL Manager 2007 for MySQL 4.1.2.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : wic


SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `wic`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_spanish_ci';

USE `wic`;

#
# Structure for the `diagnostico` table : 
#

CREATE TABLE `diagnostico` (
  `id_diagnostico` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text COLLATE latin1_spanish_ci,
  PRIMARY KEY (`id_diagnostico`)
) ENGINE=InnoDB AUTO_INCREMENT=1005 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

#
# Structure for the `especialidad` table : 
#

CREATE TABLE `especialidad` (
  `id_espacialidad` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text COLLATE latin1_spanish_ci,
  PRIMARY KEY (`id_espacialidad`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

#
# Structure for the `medico` table : 
#

CREATE TABLE `medico` (
  `id_medico` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre_apellidos` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text COLLATE latin1_spanish_ci,
  PRIMARY KEY (`id_medico`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

#
# Structure for the `paciente` table : 
#

CREATE TABLE `paciente` (
  `id_paciente` bigint(20) NOT NULL AUTO_INCREMENT,
  `historia_clinica` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `apellidos` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `edad` int(11) NOT NULL,
  `sexo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_paciente`),
  UNIQUE KEY `historia_clinica` (`historia_clinica`),
  UNIQUE KEY `UK_htmfhy4cymlv9k58qblymv5kl` (`historia_clinica`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

#
# Structure for the `procedencia` table : 
#

CREATE TABLE `procedencia` (
  `id_procedencia` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text COLLATE latin1_spanish_ci,
  PRIMARY KEY (`id_procedencia`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

#
# Structure for the `tipo_estudio` table : 
#

CREATE TABLE `tipo_estudio` (
  `id_tipo_estudio` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text COLLATE latin1_spanish_ci,
  PRIMARY KEY (`id_tipo_estudio`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

#
# Structure for the `usuario` table : 
#

CREATE TABLE `usuario` (
  `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `apellidos` varchar(100) COLLATE latin1_spanish_ci NOT NULL,
  `email` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `contrasenna` varchar(200) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

#
# Structure for the `modalidad` table : 
#

CREATE TABLE `modalidad` (
  `id_modalidad` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text COLLATE latin1_spanish_ci,
  PRIMARY KEY (`id_modalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

#
# Structure for the `estudio` table : 
#

CREATE TABLE `estudio` (
  `id_estudio` bigint(20) NOT NULL AUTO_INCREMENT,
  `rmi_id` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `fecha` date NOT NULL,
  `impresion_diagnostica` text COLLATE latin1_spanish_ci NOT NULL,
  `positivo` tinyint(1) NOT NULL,
  `paciente` bigint(20) NOT NULL,
  `especialidad` bigint(20) NOT NULL,
  `medico` bigint(20) NOT NULL,
  `tipo_estudio` bigint(20) NOT NULL,
  `diagnostico` bigint(20) NOT NULL,
  `usuario` bigint(20) NOT NULL,
  `procedencia` bigint(20) NOT NULL,
  `modalidad` bigint(20) NOT NULL,
  PRIMARY KEY (`id_estudio`),
  KEY `Refpaciente11` (`paciente`),
  KEY `Refespecialidad12` (`especialidad`),
  KEY `Refmedico13` (`medico`),
  KEY `Reftipo_estudio15` (`tipo_estudio`),
  KEY `Refdiagnostico17` (`diagnostico`),
  KEY `Refusuario18` (`usuario`),
  KEY `Refprocedencia21` (`procedencia`),
  KEY `modalidad_diagnostica` (`modalidad`),
  CONSTRAINT `Refdiagnostico17` FOREIGN KEY (`diagnostico`) REFERENCES `diagnostico` (`id_diagnostico`),
  CONSTRAINT `Refespecialidad12` FOREIGN KEY (`especialidad`) REFERENCES `especialidad` (`id_espacialidad`),
  CONSTRAINT `Refmedico13` FOREIGN KEY (`medico`) REFERENCES `medico` (`id_medico`),
  CONSTRAINT `Refpaciente11` FOREIGN KEY (`paciente`) REFERENCES `paciente` (`id_paciente`),
  CONSTRAINT `Refprocedencia21` FOREIGN KEY (`procedencia`) REFERENCES `procedencia` (`id_procedencia`),
  CONSTRAINT `Reftipo_estudio15` FOREIGN KEY (`tipo_estudio`) REFERENCES `tipo_estudio` (`id_tipo_estudio`),
  CONSTRAINT `Refusuario18` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `estudio_modalidad_fk` FOREIGN KEY (`modalidad`) REFERENCES `modalidad` (`id_modalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=1004 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

#
# Structure for the `rol` table : 
#

CREATE TABLE `rol` (
  `id_rol` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `descripcion` text COLLATE latin1_spanish_ci,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

#
# Structure for the `usuario_rol` table : 
#

CREATE TABLE `usuario_rol` (
  `usuario` bigint(20) NOT NULL,
  `rol` bigint(20) NOT NULL,
  PRIMARY KEY (`usuario`,`rol`),
  KEY `Refrol23` (`rol`),
  CONSTRAINT `Refrol23` FOREIGN KEY (`rol`) REFERENCES `rol` (`id_rol`),
  CONSTRAINT `Refusuario22` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

#
# Data for the `diagnostico` table  (LIMIT 0,500)
#

INSERT INTO `diagnostico` (`id_diagnostico`, `nombre`, `descripcion`) VALUES 
  (1002,'Locura',NULL),
  (1003,'te diagnostico esto',NULL),
  (1004,'dsfsdf',NULL);

COMMIT;

#
# Data for the `especialidad` table  (LIMIT 0,500)
#

INSERT INTO `especialidad` (`id_espacialidad`, `nombre`, `descripcion`) VALUES 
  (1001,'Especialidad X',NULL),
  (1002,'especial from mi',NULL),
  (1003,'asdsad',NULL);

COMMIT;

#
# Data for the `medico` table  (LIMIT 0,500)
#

INSERT INTO `medico` (`id_medico`, `nombre_apellidos`, `descripcion`) VALUES 
  (1001,'Maria Soler',NULL),
  (1002,'medico de la vista',NULL),
  (1003,'asdsad',NULL);

COMMIT;

#
# Data for the `paciente` table  (LIMIT 0,500)
#

INSERT INTO `paciente` (`id_paciente`, `historia_clinica`, `nombre`, `apellidos`, `edad`, `sexo`) VALUES 
  (1001,'1254','Felipe','Rdguez',23,1),
  (1002,'12546','dominico ','martimex',36,1),
  (1003,'123','fdsfsdf','123',123,1);

COMMIT;

#
# Data for the `procedencia` table  (LIMIT 0,500)
#

INSERT INTO `procedencia` (`id_procedencia`, `nombre`, `descripcion`) VALUES 
  (1001,'Clínico',NULL),
  (1002,'procede de aqui',NULL),
  (1003,'asdasdas',NULL);

COMMIT;

#
# Data for the `tipo_estudio` table  (LIMIT 0,500)
#

INSERT INTO `tipo_estudio` (`id_tipo_estudio`, `nombre`, `descripcion`) VALUES 
  (1001,'Mi Tipo',NULL),
  (1002,'un estudio',NULL),
  (1003,'asdasd',NULL);

COMMIT;

#
# Data for the `usuario` table  (LIMIT 0,500)
#

INSERT INTO `usuario` (`id_usuario`, `nombre`, `apellidos`, `email`, `contrasenna`) VALUES 
  (1,'Curran','Copeland','adipiscing@Cum.org','1000:5b42403663313565386337:0abef6ff8eab59d32f2d3fe028afb26b40fd28d453717474018de88e7d1dad89065e613c987696476111d1bef24f46d2d9eed4e7262080a3ce9c17759718ad44'),
  (2,'Darius','Gallegos','dignissim@egetmagna.net','1000:5b42403233623864396633:6b056d0632f37056b8985e091762dd826d2daab7a20517bfec9a85e92a13a00dc859ba94ee3856032b0a076f249a29d209cf9182589be691355e2d978fb65070');

COMMIT;

#
# Data for the `modalidad` table  (LIMIT 0,500)
#

INSERT INTO `modalidad` (`id_modalidad`, `nombre`, `descripcion`) VALUES 
  (1,'Modalidad',NULL),
  (2,'hjh','45454');

COMMIT;

#
# Data for the `estudio` table  (LIMIT 0,500)
#

INSERT INTO `estudio` (`id_estudio`, `rmi_id`, `fecha`, `impresion_diagnostica`, `positivo`, `paciente`, `especialidad`, `medico`, `tipo_estudio`, `diagnostico`, `usuario`, `procedencia`, `modalidad`) VALUES 
  (1003,'123','2017-02-15','asdasd',1,1003,1003,1003,1003,1004,2,1003,1);

COMMIT;

#
# Data for the `rol` table  (LIMIT 0,500)
#

INSERT INTO `rol` (`id_rol`, `nombre`, `descripcion`) VALUES 
  (1,'ROLE_ADMIN',NULL),
  (2,'ROLE_USER',NULL);

COMMIT;

#
# Data for the `usuario_rol` table  (LIMIT 0,500)
#

INSERT INTO `usuario_rol` (`usuario`, `rol`) VALUES 
  (1,1),
  (2,2);

COMMIT;

