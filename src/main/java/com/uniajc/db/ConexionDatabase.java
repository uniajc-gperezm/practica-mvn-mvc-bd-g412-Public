package com.uniajc.db;

// 1. Importar las clases necesarias de JDBC
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

// Otras importaciones necesarias para gestionar archivos de propiedades
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConexionDatabase {
  private static Connection connection = null;

  public static Connection getConnection() {

    Properties properties = new Properties();

    if (connection == null) {
      try {

        // Cargar las propiedades desde el archivo config.properties
        properties.load(new FileInputStream(new File("config.properties")));

        // 2. Definir los parámetros de conexión
        String url = properties.get("URL").toString();
        String user = properties.get("USERNAME").toString();
        String password = properties.get("PASSWORD").toString();

        // 3. Establecer la conexión
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Conexion exitosa.");
      } catch (SQLException error) {
        // error.printStackTrace();
        System.out.println("Failed to establish connection. " + error.getMessage());
      } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return connection;
  }

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
