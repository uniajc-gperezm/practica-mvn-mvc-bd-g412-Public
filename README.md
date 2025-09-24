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

# Estrucutra de JDBC para conectar JAVA a MySQL

La estructura principal para conectar Java con MySQL se basa en el driver JDBC de MySQL, conocido como MySQL Connector/J. Este driver traduce las llamadas de Java a llamadas compatibles con el protocolo de red de MySQL. La conexión se realiza utilizando la clase `DriverManager` y una URL JDBC que especifica el host, el puerto y el nombre de la base de datos, junto con las credenciales del usuario. 
Java

```java
package com.uniajc;

// 1. Importar las clases necesarias de JDBC
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EjemploConexion {

    public static void main(String[] args) {
        // 2. Definir los parámetros de conexión
        String url = "jdbc:mysql://{host}:{port}/{database-name}"; // Ejemplo: jdbc:mysql://localhost:3306/mi_base_de_datos
        String usuario = "{user}"; // Ejemplo: root
        String contrasena = "{password}"; // La contraseña de tu usuario

        // 3. Establecer la conexión
        try {
            // Cargar el driver JDBC de MySQL (opcional en versiones modernas, pero buena práctica)
            // Class.forName("com.mysql.cj.jdbc.Driver"); // Para versiones modernas del driver

            Connection conn = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("¡Conexión exitosa!");

            // Aquí iría el resto de la lógica para interactuar con la base de datos (consultas, etc.)

            // 4. Cerrar la conexión cuando ya no sea necesaria
            conn.close();
            System.out.println("Conexión cerrada.");

        } catch (SQLException e) {
            System.err.println("Error al conectar o manejar la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
```

## Elementos clave de la estructura:

1. **Driver JDBC (MySQL Connector/J):**
Es el componente principal que permite a una aplicación Java comunicarse con una base de datos MySQL. 
Es un driver JDBC "Tipo 4", lo que significa que es puramente Java y no requiere ningún componente nativo adicional. 
2. `DriverManager:`
Es una clase estándar de JDBC que gestiona un registro de drivers JDBC y puede usarse para establecer una conexión a una base de datos. 
3. **URL de la Base de Datos (JDBC URL):**
Una cadena de texto que identifica el driver JDBC a utilizar y la ubicación de la base de datos. 
La sintaxis para MySQL es jdbc:mysql://{host}:{port}/{database-name}. 
4. `Connection:`
Un objeto que representa la conexión activa entre la aplicación Java y la base de datos MySQL. 
5. `SQLException:`
Una excepción que se lanza para indicar un error al interactuar con la base de datos, como credenciales incorrectas o problemas de red. 

## Pasos para la conexión:
1. **Descargar el MySQL Connector/J:** Asegúrate de tener el archivo .jar del conector y añádelo a tu proyecto Java (a través de tu IDE o sistema de gestión de dependencias como Maven o Gradle). 
2. **Cargar el driver (opcional en versiones modernas):** Aunque en versiones recientes de Java y el driver JDBC no es siempre necesario, se puede cargar explícitamente usando Class.forName("com.mysql.cj.jdbc.Driver"); para asegurar que el driver esté disponible. 
3. **Establecer la conexión:** Usa DriverManager.**getConnection() con la URL JDBC, nombre de usuario y contraseña para obtener un objeto Connection. 
4. **Ejecutar consultas y operaciones:** Utiliza el objeto Connection para crear Statement u Objetos PreparedStatement y ejecutar tus consultas (SELECT, INSERT, UPDATE, DELETE). 
5. **Cerrar la conexión:** Libera los recursos y cierra la conexión llamando al método close() del objeto Connection para evitar fugas de recursos. 

## Recursos útiles
- [Documentación oficial de Maven](https://maven.apache.org/guides/index.html)
- [Guía de estructura de proyectos Maven](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)
