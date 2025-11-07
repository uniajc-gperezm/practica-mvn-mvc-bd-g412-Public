package com.uniajc.db;

// 1. Importar las clases necesarias de JDBC
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Clase para gestionar la conexión a la base de datos usando JDBC y un archivo
 * de propiedades.
 * Permite obtener y cerrar la conexión de forma centralizada.
 */
public class ConexionDatabase {
  // Conexión única (singleton)
  private static Connection connection = null;

  /**
   * Obtiene la conexión a la base de datos. Si no existe, la crea usando
   * config.properties.
   * 
   * @return Objeto Connection listo para usar.
   */
  public static Connection getConnection() {

    Properties properties = new Properties();

    if (connection == null) {
      try {
        // Primero intentar cargar desde el classpath (src/main/resources)
        try (java.io.InputStream is = ConexionDatabase.class.getClassLoader().getResourceAsStream("config.properties")) {
          if (is != null) {
            properties.load(is);
          } else {
            // Si no está en classpath, intentar archivo en el working directory
            properties.load(new FileInputStream(new File("config.properties")));
          }
        }

        // Leer los parámetros de conexión
        String url = properties.getProperty("URL");
        String user = properties.getProperty("USERNAME");
        String password = properties.getProperty("PASSWORD");

        // Establecer la conexión
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Conexion exitosa.");
      } catch (SQLException error) {
        System.out.println("Failed to establish connection. " + error.getMessage());
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return connection;
  }

  /**
   * Cierra la conexión a la base de datos si está abierta.
   */
  public static void closeConnection() {
    if (connection != null) {
      try {
        connection.close();
        System.out.println("Connection closed successfully.");
      } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Failed to close connection. " + e.getMessage());
      }
    }
  }

}
