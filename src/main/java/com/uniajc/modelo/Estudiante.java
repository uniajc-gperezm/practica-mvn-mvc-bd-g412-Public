package com.uniajc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uniajc.db.ConexionDatabase;

/**
 * Clase que representa a un estudiante y contiene métodos para interactuar con
 * la base de datos.
 * Permite insertar, actualizar, eliminar, consultar y listar estudiantes.
 */
public class Estudiante {

  // Identificador único del estudiante (clave primaria en la base de datos)
  private int id;
  // Nombre del estudiante
  private String nombre;
  // Correo institucional del estudiante
  private String correo;

  // Constructor vacío
  public Estudiante() {
  }

  // Constructor para crear estudiante sin id (para inserción)
  public Estudiante(String nombre, String correo) {
    this.nombre = nombre;
    this.correo = correo;
  }

  // Constructor para crear estudiante con id (para consultas y actualizaciones)
  public Estudiante(int id, String nombre, String correo) {
    this.id = id;
    this.nombre = nombre;
    this.correo = correo;
  }

  // Métodos getter y setter
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

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  @Override
  public String toString() {
    if (this.nombre != null) {
      return this.nombre + " (id=" + this.id + ") - " + (this.correo != null ? this.correo : "");
    }
    return "Estudiante[id=" + id + "]";
  }

  /**
   * Inserta un nuevo estudiante en la base de datos.
   * 
   * @param estudiante El estudiante a insertar (sin id).
   */
  public static void insertarEstudiante(Estudiante estudiante) {
    String sql = "INSERT INTO estudiantes (nombre, correo_institucional) VALUES (?, ?)";
    try {
      try (Connection conexion = ConexionDatabase.getConnection();
          PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
        preparedStatement.setString(1, estudiante.getNombre());
        preparedStatement.setString(2, estudiante.getCorreo());
        preparedStatement.executeUpdate(); // Ejecuta la inserción
      }
    } catch (Exception e) {
      System.err.println("Error insertando estudiante: " + e.getMessage());
    }
  }

  /**
   * Actualiza los datos de un estudiante existente en la base de datos.
   * 
   * @param estudiante El estudiante con id y nuevos datos.
   */
  public static void updateEstudiante(Estudiante estudiante) {
    String sql = "UPDATE estudiantes SET nombre = ?, correo_institucional = ? WHERE estudiante_id = ?";
    try {
      try (Connection conexion = ConexionDatabase.getConnection();
          PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
        preparedStatement.setString(1, estudiante.getNombre());
        preparedStatement.setString(2, estudiante.getCorreo());
        preparedStatement.setInt(3, estudiante.getId());
        preparedStatement.executeUpdate(); // Ejecuta la actualización
      }
    } catch (Exception e) {
      System.err.println("Error actualizando estudiante: " + e.getMessage());
    }
  }

  /**
   * Elimina un estudiante de la base de datos por su id.
   * 
   * @param estudiante El estudiante a eliminar (debe tener id).
   */
  public static void deleteEstudiante(Estudiante estudiante) {
    String sql = "DELETE FROM estudiantes WHERE estudiante_id = ?";
    try {
      try (Connection conexion = ConexionDatabase.getConnection();
          PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
        preparedStatement.setInt(1, estudiante.getId());
        preparedStatement.executeUpdate(); // Ejecuta la eliminación
      }
    } catch (Exception e) {
      System.err.println("Error eliminando estudiante: " + e.getMessage());
    }
  }

  /**
   * Obtiene una lista de todos los estudiantes registrados en la base de datos.
   * 
   * @return Lista de estudiantes.
   */
  public static List<Estudiante> obtenerTodosLosEstudiantes() {
    List<Estudiante> estudiantes = new ArrayList<>();
    String sql = "SELECT estudiante_id, nombre, correo_institucional FROM estudiantes";
    try {
      try (Connection conexion = ConexionDatabase.getConnection();
          Statement statement = conexion.createStatement();
          ResultSet resultSet = statement.executeQuery(sql)) {
        while (resultSet.next()) {
          int id = resultSet.getInt("estudiante_id");
          String nombre = resultSet.getString("nombre");
          String correo = resultSet.getString("correo_institucional");
          Estudiante estudiante = new Estudiante(id, nombre, correo);
          estudiantes.add(estudiante);
        }
      }
      return estudiantes;
    } catch (Exception e) {
      System.err.println("Error obteniendo lista de estudiantes: " + e.getMessage());
    }
    return estudiantes;
  }

  /**
   * Consulta un estudiante por su id.
   * 
   * @param id El id del estudiante a buscar.
   * @return El estudiante encontrado o null si no existe.
   */
  public static Estudiante consultarEstudiantePorId(int id) {
    Estudiante estudiante = null;
    String sql = "SELECT estudiante_id, nombre, correo_institucional FROM estudiantes WHERE estudiante_id = ?";
    try {
      try (Connection conexion = ConexionDatabase.getConnection();
          PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
        preparedStatement.setInt(1, id);
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
          if (resultSet.next()) {
            int idEstudiante = resultSet.getInt("estudiante_id");
            String nombre = resultSet.getString("nombre");
            String correo = resultSet.getString("correo_institucional");
            Estudiante estudianteEncontrado = new Estudiante(idEstudiante, nombre, correo);
            estudiante = estudianteEncontrado;
          }
        }
      }
    } catch (Exception e) {
      System.err.println("Error consultando estudiante por id: " + e.getMessage());
    }
    return estudiante;
  }
}