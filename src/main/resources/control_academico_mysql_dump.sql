-- MySQL dump provided by instructor
-- Database: control-academico
-- Server version 8.0.37
--
-- Table structure for table `asistencias`

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asistencias` (
  `asistencia_id` int NOT NULL AUTO_INCREMENT,
  `estudiante_id` int DEFAULT NULL,
  `curso_id` int DEFAULT NULL,
  `fecha_clase` date DEFAULT NULL,
  `estado_asistencia` enum('presente','ausente','tardanza') COLLATE utf8mb4_general_ci DEFAULT NULL,
  `novedades` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`asistencia_id`),
  KEY `estudiante_id` (`estudiante_id`),
  KEY `curso_id` (`curso_id`),
  CONSTRAINT `asistencias_ibfk_1` FOREIGN KEY (`estudiante_id`) REFERENCES `estudiantes` (`estudiante_id`),
  CONSTRAINT `asistencias_ibfk_2` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`curso_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Table structure for table `calificaciones`

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calificaciones` (
  `calificacion_id` int NOT NULL AUTO_INCREMENT,
  `estudiante_id` int DEFAULT NULL,
  `componente_evaluacion_id` int DEFAULT NULL,
  `nota` decimal(3,2) NOT NULL,
  `comentarios_calificacion` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`calificacion_id`),
  KEY `estudiante_id` (`estudiante_id`),
  KEY `componente_evaluacion_id` (`componente_evaluacion_id`),
  CONSTRAINT `calificaciones_ibfk_1` FOREIGN KEY (`estudiante_id`) REFERENCES `estudiantes` (`estudiante_id`),
  CONSTRAINT `calificaciones_ibfk_2` FOREIGN KEY (`componente_evaluacion_id`) REFERENCES `componentes_evaluacion` (`componente_evaluacion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Table structure for table `clases`

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clases` (
  `clase_id` int NOT NULL AUTO_INCREMENT,
  `curso_id` int DEFAULT NULL,
  `numero_clase` int DEFAULT NULL,
  `fecha_clase` date DEFAULT NULL,
  `tema_clase` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `descripcion_clase` text COLLATE utf8mb4_general_ci,
  `comentarios_clase` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`clase_id`),
  KEY `curso_id` (`curso_id`),
  CONSTRAINT `clases_ibfk_1` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`curso_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Table structure for table `componentes_evaluacion`

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `componentes_evaluacion` (
  `componente_evaluacion_id` int NOT NULL AUTO_INCREMENT,
  `corte_evaluacion_id` int DEFAULT NULL,
  `nombre_componente` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `porcentaje` decimal(5,2) NOT NULL,
  PRIMARY KEY (`componente_evaluacion_id`),
  KEY `corte_evaluacion_id` (`corte_evaluacion_id`),
  CONSTRAINT `componentes_evaluacion_ibfk_1` FOREIGN KEY (`corte_evaluacion_id`) REFERENCES `cortes_evaluacion` (`corte_evaluacion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Table structure for table `cortes_evaluacion`

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cortes_evaluacion` (
  `corte_evaluacion_id` int NOT NULL AUTO_INCREMENT,
  `curso_id` int DEFAULT NULL,
  `periodo_academico_id` int DEFAULT NULL,
  `nombre_corte` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `porcentaje` decimal(5,2) NOT NULL,
  `comentarios_corte` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`corte_evaluacion_id`),
  KEY `curso_id` (`curso_id`),
  KEY `periodo_academico_id` (`periodo_academico_id`),
  CONSTRAINT `cortes_evaluacion_ibfk_1` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`curso_id`),
  CONSTRAINT `cortes_evaluacion_ibfk_2` FOREIGN KEY (`periodo_academico_id`) REFERENCES `periodos_academicos` (`periodo_academico_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Table structure for table `cursos`

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `curso_id` int NOT NULL AUTO_INCREMENT,
  `nombre_curso` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `periodo_academico_id` int DEFAULT NULL,
  `docente_id` int DEFAULT NULL,
  `descripcion_curso` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`curso_id`),
  KEY `periodo_academico_id` (`periodo_academico_id`),
  KEY `docente_id` (`docente_id`),
  CONSTRAINT `cursos_ibfk_1` FOREIGN KEY (`periodo_academico_id`) REFERENCES `periodos_academicos` (`periodo_academico_id`),
  CONSTRAINT `cursos_ibfk_2` FOREIGN KEY (`docente_id`) REFERENCES `docentes` (`docente_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Table structure for table `docentes`

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docentes` (
  `docente_id` int NOT NULL AUTO_INCREMENT,
  `nombre_docente` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `identificacion` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `tipo_identificacion` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `genero` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `correo` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `titulo_estudios` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `idiomas` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `certificaciones` text COLLATE utf8mb4_general_ci,
  PRIMARY KEY (`docente_id`),
  UNIQUE KEY `identificacion` (`identificacion`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Table structure for table `docentes_cursos`

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docentes_cursos` (
  `docente_id` int NOT NULL,
  `curso_id` int NOT NULL,
  PRIMARY KEY (`docente_id`,`curso_id`),
  KEY `curso_id` (`curso_id`),
  CONSTRAINT `docentes_cursos_ibfk_1` FOREIGN KEY (`docente_id`) REFERENCES `docentes` (`docente_id`),
  CONSTRAINT `docentes_cursos_ibfk_2` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`curso_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Table structure for table `estudiantes`

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estudiantes` (
  `estudiante_id` int NOT NULL AUTO_INCREMENT,
  `identificacion` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `correo_institucional` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `correo_personal` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `telefono` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `es_vocero` tinyint(1) DEFAULT '0',
  `comentarios` text COLLATE utf8mb4_general_ci,
  `tipo_documento` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `genero` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`estudiante_id`),
  UNIQUE KEY `identificacion` (`identificacion`),
  UNIQUE KEY `correo_institucional` (`correo_institucional`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Table structure for table `periodos_academicos`

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodos_academicos` (
  `periodo_academico_id` int NOT NULL AUTO_INCREMENT,
  `nombre_periodo` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  PRIMARY KEY (`periodo_academico_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

-- Dumping routines for database 'control-academico'
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-10-24 20:39:04

-- Nota: "esto me dio el profe"
