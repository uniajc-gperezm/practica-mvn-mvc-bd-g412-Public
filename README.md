# Proyecto Maven: practica-mvn-mvc-bd-g412

Este repositorio contiene un proyecto Java estructurado con Maven, utilizando el patrón Modelo-Vista-Controlador (MVC) y acceso a bases de datos (MySQL y SQLite).

## Estructura del Proyecto

La estructura típica de un proyecto Maven es la siguiente:

```
practica-mvn-mvc-bd-g412/
│
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/uniajc/
│   │   │       ├── Main.java
│   │   │       ├── controlador/
│   │   │       │   └── ControladorEstudiante.java
│   │   │       ├── modelo/
│   │   │       │   └── Estudiante.java
│   │   │       └── vista/
│   │   │           └── VistaEstudiante.java
│   │   └── resources/
│   └── test/
│       └── java/
└── target/
```

- **pom.xml**: Archivo de configuración principal de Maven.
- **src/main/java/**: Código fuente principal de la aplicación.
- **src/main/resources/**: Archivos de recursos (configuración, plantillas, etc.).
- **src/test/java/**: Código fuente de pruebas.
- **target/**: Archivos generados y compilados por Maven.

## Explicación del archivo `pom.xml`

El archivo `pom.xml` (Project Object Model) es el corazón de cualquier proyecto Maven. Define la configuración del proyecto, sus dependencias, plugins y otras propiedades.

### Estructura básica de un `pom.xml`

```xml
<project>
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.uniajc</groupId>
  <artifactId>practica-mvn-mvc-bd-g412</artifactId>
  <version>1.0-SNAPSHOT</version>
  <properties>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
  </properties>
  <dependencies>
    <!-- Dependencias aquí -->
  </dependencies>
</project>
```

- **modelVersion**: Versión del modelo de POM utilizada.
- **groupId**: Identificador único del grupo o empresa (similar a un paquete Java).
- **artifactId**: Nombre del artefacto (proyecto).
- **version**: Versión del proyecto.
- **properties**: Propiedades del proyecto, como la versión de Java utilizada para compilar.
- **dependencies**: Lista de dependencias externas necesarias para el proyecto.

### Dependencias en este proyecto

```xml
<dependency>
  <groupId>com.mysql</groupId>
  <artifactId>mysql-connector-j</artifactId>
  <version>8.0.33</version>
</dependency>
<dependency>
  <groupId>org.xerial</groupId>
  <artifactId>sqlite-jdbc</artifactId>
  <version>3.49.1.0</version>
</dependency>
```

Estas dependencias permiten la conexión a bases de datos MySQL y SQLite desde Java.

## ¿Cómo compilar y ejecutar?

1. **Compilar el proyecto:**
   ```
   mvn clean compile
   ```
2. **Ejecutar pruebas (si existen):**
   ```
   mvn test
   ```
3. **Empaquetar el proyecto:**
   ```
   mvn package
   ```

## Recursos útiles
- [Documentación oficial de Maven](https://maven.apache.org/guides/index.html)
- [Guía de estructura de proyectos Maven](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)
