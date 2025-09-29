package com.uniajc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConexionPostgres {
  private static Connection connection = null;

  public static Connection getConnection() {
    Properties properties = new Properties();
    if (connection == null) {
      try {
        // Cargar las propiedades desde el archivo config-postgres.properties
        properties.load(new FileInputStream(new File("config-postgres.properties")));

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
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
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
        e.printStackTrace();
        System.out.println("Failed to close PostgreSQL connection. " + e.getMessage());
      }
    }
  }
}