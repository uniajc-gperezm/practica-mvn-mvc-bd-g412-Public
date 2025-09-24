package com.uniajc.modelo;

// 1. Importar las clases necesarias de JDBC
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConexionDatabase {
  private static Connection connection = null;

  public static Connection getConnection() {
    if (connection == null) {
      try {
        // 2. Definir los parámetros de conexión
        String url = ""; // Replace with your DB URL
        String user = ""; // Replace with your DB username
        String password = ""; // Replace with your DB password

        // 3. Establecer la conexión
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Conexion exitosa.");
      } catch (SQLException error) {
        // error.printStackTrace();
        System.out.println("Failed to establish connection. " + error.getMessage());
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
