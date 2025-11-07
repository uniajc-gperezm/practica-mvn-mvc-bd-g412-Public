package com.uniajc.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionPostgres {
  private static Connection connection = null;

  public static Connection getConnection() {
    Properties properties = new Properties();
    if (connection == null) {
      try {
        // Intentar cargar desde classpath primero
        try (java.io.InputStream is = ConexionPostgres.class.getClassLoader().getResourceAsStream("config-postgres.properties")) {
          if (is != null) {
            properties.load(is);
          } else {
            properties.load(new FileInputStream(new File("config-postgres.properties")));
          }
        }

        // Definir los parámetros de conexión
        String url = properties.getProperty("URL");
        String user = properties.getProperty("USERNAME");
        String password = properties.getProperty("PASSWORD");

        // Establecer la conexión
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Conexión a PostgreSQL exitosa.");
      } catch (SQLException error) {
        System.out.println("Failed to establish PostgreSQL connection. " + error.getMessage());
      } catch (FileNotFoundException e) {
        System.err.println("Archivo config-postgres.properties no encontrado: " + e.getMessage());
      } catch (IOException e) {
        System.err.println("Error leyendo config-postgres.properties: " + e.getMessage());
      }
    }
    return connection;
  }

  public static void closeConnection() {
    if (connection != null) {
      try {
        connection.close();
        System.out.println("PostgreSQL connection closed successfully.");
      } catch (SQLException e) {
        System.err.println("Error cerrando conexión PostgreSQL: " + e.getMessage());
        System.err.println(e.getMessage());
      }
    }
  }
}
