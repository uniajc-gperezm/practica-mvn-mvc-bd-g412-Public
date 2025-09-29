package com.uniajc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.uniajc.db.ConexionDatabase;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class Estudiante {

  private String nombre;
  private int edad;

  public Estudiante() {
  }

  public Estudiante(String nombre, int edad) {
    this.nombre = nombre;
    this.edad = edad;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  public static void insertarEstudiante(Estudiante estudiante) {

    String sql = "INSERT INTO estudiante (nombre, edad) VALUES (?, ?)";

    try {
      Connection conexion = ConexionDatabase.getConnection();
      PreparedStatement preparedStatement = conexion.prepareStatement(sql);
      preparedStatement.setString(1, estudiante.getNombre());
      preparedStatement.setInt(2, estudiante.getEdad());

      // Ejecutar la sentencias SQL INSERT, UPDATE o DELETE
      preparedStatement.executeUpdate();
      // int filasInsertadas =
      // if (filasInsertadas > 0) {
      // System.out.println("Estudiante insertado exitosamente.");
      // }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public static List<Estudiante> obtenerTodosLosEstudiantes() {

    List<Estudiante> estudiantes = new ArrayList<>();

    String sql = "SELECT nombre, edad FROM estudiante";

    try {
      Connection conexion = ConexionDatabase.getConnection();
      Statement statement = conexion.createStatement();

      // Ejecutar la consulta SQL tipo SELECT
      ResultSet resultSet = statement.executeQuery(sql);

      while (resultSet.next()) {
        String nombre = resultSet.getString("nombre");
        int edad = resultSet.getInt("edad");
        Estudiante estudiante = new Estudiante(nombre, edad);
        estudiantes.add(estudiante);
      }
      return estudiantes;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return estudiantes;
  }

}
