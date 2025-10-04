package com.uniajc.modelo;

import java.sql.Connection;

// Otras importaciones necesarias para manejar SQL tipo INSERT, UPDATE o DELETE
import java.sql.PreparedStatement;

import com.uniajc.db.ConexionDatabase;

// Otras importaciones necesarias para manejar SQL tipo SELECT
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class Estudiante {

  private int id;
  private String nombre;
  private int edad;

  public Estudiante() {
  }

  public Estudiante(String nombre, int edad) {
    this.nombre = nombre;
    this.edad = edad;
  }

  public Estudiante(int id, String nombre, int edad) {
    this.id = id;
    this.nombre = nombre;
    this.edad = edad;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void updateEstudiante(Estudiante estudiante) {
    String sql = "UPDATE estudiante SET nombre = ?, edad = ? WHERE id = ?";

    try {
      Connection conexion = ConexionDatabase.getConnection();
      PreparedStatement preparedStatement = conexion.prepareStatement(sql);
      preparedStatement.setString(1, estudiante.getNombre());
      preparedStatement.setInt(2, estudiante.getEdad());
      preparedStatement.setInt(3, estudiante.getId());

      // Ejecutar la sentencias SQL INSERT, UPDATE o DELETE
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void deleteEstudiante(Estudiante estudiante) {
    String sql = "DELETE FROM estudiante WHERE id = ?";

    try {
      Connection conexion = ConexionDatabase.getConnection();
      PreparedStatement preparedStatement = conexion.prepareStatement(sql);
      preparedStatement.setInt(1, estudiante.getId());

      // Ejecutar la sentencias SQL INSERT, UPDATE o DELETE
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static List<Estudiante> obtenerTodosLosEstudiantes() {

    List<Estudiante> estudiantes = new ArrayList<>();

    String sql = "SELECT id, nombre, edad FROM estudiante";

    try {
      Connection conexion = ConexionDatabase.getConnection();
      Statement statement = conexion.createStatement();

      // Ejecutar la consulta SQL tipo SELECT
      ResultSet resultSet = statement.executeQuery(sql); // Devuelve un conjunto de resultados

      while (resultSet.next()) {

        int id = resultSet.getInt("id");
        String nombre = resultSet.getString("nombre");
        int edad = resultSet.getInt("edad");

        Estudiante estudiante = new Estudiante(id, nombre, edad);

        estudiantes.add(estudiante); // Agregar el estudiante a la lista
      }

      return estudiantes; // Devolver la lista de estudiantes

    } catch (Exception e) {
      e.printStackTrace();
    }

    return estudiantes;
  }

  public static Estudiante consultarEstudiantePorId(int id) {

    Estudiante estudiante = null;

    String sql = "SELECT id, nombre, edad FROM estudiante WHERE id = ?";

    try {
      Connection conexion = ConexionDatabase.getConnection();
      PreparedStatement preparedStatement = conexion.prepareStatement(sql);

      preparedStatement.setInt(1, id);

      // Ejecutar la consulta SQL tipo SELECT
      ResultSet resultSet = preparedStatement.executeQuery(sql); // Devuelve un conjunto de resultados

      while (resultSet.next()) {

        int idEstudiante = resultSet.getInt("id");
        String nombre = resultSet.getString("nombre");
        int edad = resultSet.getInt("edad");

        Estudiante estudianteEncontrado = new Estudiante(idEstudiante, nombre, edad);
        estudiante = estudianteEncontrado;

      }

    } catch (Exception e) {
      e.printStackTrace();
    }

    return estudiante;
  }

}