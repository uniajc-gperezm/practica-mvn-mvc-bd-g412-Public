package com.uniajc.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.uniajc.db.ConexionDatabase;

/**
 * Modelo para docentes. Campos: id, nombre, correo y titulos.
 * Contiene operaciones CRUD básicas que usan la tabla `docentes`.
 */
public class Docente {

  private int id;
  private String nombre;
  private String correo;
  private String titulos;

  public Docente() {
  }

  public Docente(String nombre, String correo, String titulos) {
    this.nombre = nombre;
    this.correo = correo;
    this.titulos = titulos;
  }

  public Docente(int id, String nombre, String correo, String titulos) {
    this.id = id;
    this.nombre = nombre;
    this.correo = correo;
    this.titulos = titulos;
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

  public String getCorreo() {
    return correo;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }

  public String getTitulos() {
    return titulos;
  }

  public void setTitulos(String titulos) {
    this.titulos = titulos;
  }

  @Override
  public String toString() {
    if (this.nombre != null) return this.nombre + " (id=" + id + ")";
    return "Docente[id=" + id + "]";
  }

  // CRUD
  public static void insertarDocente(Docente docente) {
    String sql = "INSERT INTO docentes (nombre_docente, correo, titulo_estudios) VALUES (?, ?, ?)";
    try (Connection conexion = ConexionDatabase.getConnection();
        PreparedStatement ps = conexion.prepareStatement(sql)) {
      ps.setString(1, docente.getNombre());
      ps.setString(2, docente.getCorreo());
      ps.setString(3, docente.getTitulos());
      ps.executeUpdate();
    } catch (Exception e) {
      System.err.println("Error insertando docente: " + e.getMessage());
    }
  }

  public static void updateDocente(Docente docente) {
    String sql = "UPDATE docentes SET nombre_docente = ?, correo = ?, titulo_estudios = ? WHERE docente_id = ?";
    try (Connection conexion = ConexionDatabase.getConnection();
        PreparedStatement ps = conexion.prepareStatement(sql)) {
      ps.setString(1, docente.getNombre());
      ps.setString(2, docente.getCorreo());
      ps.setString(3, docente.getTitulos());
      ps.setInt(4, docente.getId());
      ps.executeUpdate();
    } catch (Exception e) {
      System.err.println("Error actualizando docente: " + e.getMessage());
    }
  }

  public static void deleteDocente(Docente docente) {
    String sql = "DELETE FROM docentes WHERE docente_id = ?";
    try (Connection conexion = ConexionDatabase.getConnection();
        PreparedStatement ps = conexion.prepareStatement(sql)) {
      ps.setInt(1, docente.getId());
      ps.executeUpdate();
    } catch (Exception e) {
      System.err.println("Error eliminando docente: " + e.getMessage());
    }
  }

  public static List<Docente> obtenerTodosLosDocentes() {
    List<Docente> lista = new ArrayList<>();
    String sql = "SELECT docente_id, nombre_docente, correo, titulo_estudios FROM docentes";
    try (Connection conexion = ConexionDatabase.getConnection();
        Statement st = conexion.createStatement();
        ResultSet rs = st.executeQuery(sql)) {
      while (rs.next()) {
        int id = rs.getInt("docente_id");
        String nombre = rs.getString("nombre_docente");
        String correo = rs.getString("correo");
        String titulos = rs.getString("titulo_estudios");
        lista.add(new Docente(id, nombre, correo, titulos));
      }
    } catch (Exception e) {
      System.err.println("Error obteniendo docentes: " + e.getMessage());
    }
    return lista;
  }

  public static Docente consultarDocentePorId(int id) {
    Docente docente = null;
    String sql = "SELECT docente_id, nombre_docente, correo, titulo_estudios FROM docentes WHERE docente_id = ?";
    try (Connection conexion = ConexionDatabase.getConnection();
        PreparedStatement ps = conexion.prepareStatement(sql)) {
      ps.setInt(1, id);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          int idDoc = rs.getInt("docente_id");
          String nombre = rs.getString("nombre_docente");
          String correo = rs.getString("correo");
          String titulos = rs.getString("titulo_estudios");
          docente = new Docente(idDoc, nombre, correo, titulos);
        }
      }
    } catch (Exception e) {
      System.err.println("Error consultando docente por id: " + e.getMessage());
    }
    return docente;
  }

}
