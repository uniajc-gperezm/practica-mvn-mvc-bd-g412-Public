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

# Uso de archivos properties en Java

Los archivos `.properties` en Java se utilizan para almacenar información de configuración en formato clave-valor. Son muy útiles para separar la configuración del código fuente, facilitando cambios sin necesidad de recompilar la aplicación.

## ¿Cómo funciona?
- Un archivo `config.properties` típico puede contener:
  ```properties
  URL=jdbc:mysql://localhost:3306/practica-mvc
  USERNAME=root
  PASSWORD=admin
  ```
- En Java, se utiliza la clase `Properties` para leer estos valores:
  ```java
  Properties properties = new Properties();
  properties.load(new FileInputStream("config.properties"));
  String url = properties.getProperty("URL");
  String user = properties.getProperty("USERNAME");
  String password = properties.getProperty("PASSWORD");
  ```
- Esto permite cambiar la configuración de la base de datos (o cualquier otro parámetro) sin modificar el código fuente.

## Ventajas
- **Flexibilidad:** Cambia parámetros de conexión, rutas, o cualquier configuración sin recompilar.
- **Seguridad:** Puedes excluir archivos de configuración sensibles del control de versiones.
- **Mantenibilidad:** Centraliza la configuración en un solo lugar.

## Ejemplo en este proyecto
En este repositorio, la clase `ConexionDatabase` utiliza un archivo `config.properties` para obtener los datos de conexión a la base de datos. Así, puedes modificar el usuario, contraseña o URL de la base de datos fácilmente editando el archivo de propiedades.

## Recursos útiles
- [Documentación oficial de Maven](https://maven.apache.org/guides/index.html)
- [Guía de estructura de proyectos Maven](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)
- [Guía para el uso de properties](https://www.arquitecturajava.com/java-properties-files-y-como-usarlos/)

# Gestión de estudiantes desde la base de datos

Se ha implementado la funcionalidad para insertar y listar estudiantes directamente desde la base de datos utilizando JDBC. El flujo sigue el patrón MVC:

## Cambios en el Modelo (`Estudiante`)
- Se agregaron métodos estáticos para interactuar con la base de datos:
  - `insertarEstudiante(Estudiante estudiante)`: Inserta un estudiante en la tabla `estudiante`.
  - `obtenerTodosLosEstudiantes()`: Recupera todos los estudiantes de la base de datos y los retorna como una lista.

```java
public static void insertarEstudiante(Estudiante estudiante) {
  // ...
  Connection conexion = ConexionDatabase.getConnection();
  PreparedStatement preparedStatement = conexion.prepareStatement(sql);
  // ...
  preparedStatement.executeUpdate();
}

public static List<Estudiante> obtenerTodosLosEstudiantes() {
  // ...
  Connection conexion = ConexionDatabase.getConnection();
  Statement statement = conexion.createStatement();
  ResultSet resultSet = statement.executeQuery(sql);
  // ...
}
```

## Cambios en el Controlador (`ControladorEstudiante`)
- El controlador ahora utiliza los métodos del modelo para crear y listar estudiantes:
  - `crearEstudiante(Estudiante estudiante)`: Llama a `insertarEstudiante` y muestra un mensaje de confirmación.
  - `listaTodosLosEstudiantes()`: Llama a `obtenerTodosLosEstudiantes` y retorna la lista.
  - `mostrarVista()`: Recupera la lista y la pasa a la vista.

```java
public void crearEstudiante(Estudiante estudiante) {
  Estudiante.insertarEstudiante(estudiante);
  System.out.println("Estudiante creado: " + estudiante.getNombre() + ", Edad: " + estudiante.getEdad());
}

public List<Estudiante> listaTodosLosEstudiantes() {
  return Estudiante.obtenerTodosLosEstudiantes();
}

public void mostrarVista() {
  List<Estudiante> estudiantes = listaTodosLosEstudiantes();
  vista.mostrarDetallesEstudiante(estudiantes);
}
```

## Cambios en la Vista (`VistaEstudiante`)
- La vista ahora recibe una lista de estudiantes y muestra sus detalles:

```java
public void mostrarDetallesEstudiante(List<Estudiante> estudiantes) {
  System.out.println("=== Detalles de los Estudiantes ===");
  for (Estudiante estudiante : estudiantes) {
    System.out.println("Nombre: " + estudiante.getNombre());
    System.out.println("Edad: " + estudiante.getEdad());
    System.out.println("---------------------------");
  }
}
```

## Ejemplo de uso en `Main`

```java
Connection conexion = ConexionDatabase.getConnection();
Estudiante modelo = new Estudiante();
modelo.setNombre("Juan Perez");
modelo.setEdad(20);
VistaEstudiante vista = new VistaEstudiante();
ControladorEstudiante controlador = new ControladorEstudiante(modelo, vista);
controlador.crearEstudiante(modelo);
controlador.mostrarVista();
```

Con este flujo, los estudiantes se insertan y consultan directamente desde la base de datos, y la vista muestra la información actualizada.

## Métodos para actualizar, eliminar y consultar estudiantes por ID

Se han añadido métodos para actualizar, eliminar y consultar estudiantes por su identificador único (`id`). Esto permite una gestión completa de los registros en la base de datos.

### Modelo (`Estudiante`)
- `updateEstudiante(Estudiante estudiante)`: Actualiza los datos de un estudiante existente en la base de datos según su `id`.
- `deleteEstudiante(Estudiante estudiante)`: Elimina un estudiante de la base de datos usando su `id`.
- `consultarEstudiantePorId(int id)`: Busca y retorna un estudiante por su `id`.

```java
public static void updateEstudiante(Estudiante estudiante) {
  String sql = "UPDATE estudiante SET nombre = ?, edad = ? WHERE id = ?";
  // ...
  preparedStatement.setString(1, estudiante.getNombre());
  preparedStatement.setInt(2, estudiante.getEdad());
  preparedStatement.setInt(3, estudiante.getId());
  preparedStatement.executeUpdate();
}

public static void deleteEstudiante(Estudiante estudiante) {
  String sql = "DELETE FROM estudiante WHERE id = ?";
  // ...
  preparedStatement.setInt(1, estudiante.getId());
  preparedStatement.executeUpdate();
}

public static Estudiante consultarEstudiantePorId(int id) {
  String sql = "SELECT id, nombre, edad FROM estudiante WHERE id = ?";
  // ...
  preparedStatement.setInt(1, id);
  ResultSet resultSet = preparedStatement.executeQuery();
  // ...
}
```

### Controlador (`ControladorEstudiante`)
- `actualizarEstudiante(Estudiante estudiante)`: Llama al método del modelo para actualizar un estudiante y muestra un mensaje de confirmación.
- `eliminarEstudiante(Estudiante estudiante)`: Llama al método del modelo para eliminar un estudiante y muestra un mensaje de confirmación.
- `consultarEstudiantePorId(int id)`: Llama al método del modelo para buscar un estudiante por su `id` y retorna el resultado.

```java
public void actualizarEstudiante(Estudiante estudiante) {
  Estudiante.updateEstudiante(estudiante);
  System.out.println("Estudiante actualizado: " + estudiante.getNombre() + ", Edad: " + estudiante.getEdad());
}

public void eliminarEstudiante(Estudiante estudiante) {
  Estudiante.deleteEstudiante(estudiante);
  System.out.println("Estudiante elimninado: " + estudiante.getNombre() + ", Edad: " + estudiante.getEdad());
}

public Estudiante consultarEstudiantePorId(int id) {
  return Estudiante.consultarEstudiantePorId(id);
}
```

### ¿Cómo funciona?
- Para **actualizar** un estudiante, se debe tener el `id` del registro y los nuevos datos. El método ejecuta una sentencia SQL `UPDATE`.
- Para **eliminar** un estudiante, se utiliza el `id` y se ejecuta una sentencia SQL `DELETE`.
- Para **consultar** un estudiante por su `id`, se ejecuta una sentencia SQL `SELECT` con el parámetro correspondiente y se retorna el estudiante encontrado (o `null` si no existe).

### Ejemplo de uso en `Main`

```java
// Actualizar el modelo
controlador.actualizarId(42);
controlador.actualizarNombre("Carlos Gomez");
controlador.actualizarEdad(22);
controlador.actualizarEstudiante(modelo);

// Consultar estudiante por id
Estudiante estudianteBuscado = controlador.consultarEstudiantePorId(42);
if (estudianteBuscado != null) {
  System.out.println("Encontrado: " + estudianteBuscado.getNombre());
}

// Eliminar estudiante
controlador.eliminarEstudiante(modelo);
```

Estos métodos permiten modificar, eliminar y buscar estudiantes de forma eficiente y segura desde la base de datos, manteniendo la lógica separada en el modelo y el controlador.
