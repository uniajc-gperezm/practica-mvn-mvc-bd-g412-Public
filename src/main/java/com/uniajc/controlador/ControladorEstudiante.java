package com.uniajc.controlador;

import java.util.List;

import com.uniajc.modelo.Estudiante;
import com.uniajc.vista.consola.VistaEstudiante;

/**
 * Controlador para gestionar la lógica entre el modelo Estudiante y la vista
 * VistaEstudiante (consola).
 */
public class ControladorEstudiante {
  private Estudiante estudiante;
  private VistaEstudiante vista;

  public ControladorEstudiante(Estudiante estudiante, VistaEstudiante vista) {
    this.estudiante = estudiante;
    this.vista = vista;
  }

  public void actualizarId(int id) {
    estudiante.setId(id);
  }

  public int obtenerId() {
    return estudiante.getId();
  }

  public void actualizarNombre(String nombre) {
    estudiante.setNombre(nombre);
  }

  public void actualizarEdad(int edad) {
    estudiante.setEdad(edad);
  }

  public String obtenerNombre() {
    return estudiante.getNombre();
  }

  public int obtenerEdad() {
    return estudiante.getEdad();
  }

  public void crearEstudiante(Estudiante estudiante) {
    Estudiante.insertarEstudiante(estudiante);
    System.out.println("Estudiante creado: " + estudiante.getNombre() + ", Edad: " + estudiante.getEdad());
  }

  public void actualizarEstudiante(Estudiante estudiante) {
    Estudiante.updateEstudiante(estudiante);
    System.out.println("Estudiante actualizado: " + estudiante.getNombre() + ", Edad: " + estudiante.getEdad());
  }

  public void eliminarEstudiante(Estudiante estudiante) {
    Estudiante.deleteEstudiante(estudiante);
    System.out.println("Estudiante eliminado: " + estudiante.getNombre());
  }

  public Estudiante consultarEstudiantePorId(int id) {
    return Estudiante.consultarEstudiantePorId(id);
  }

  public List<Estudiante> listaTodosLosEstudiantes() {
    return Estudiante.obtenerTodosLosEstudiantes();
  }

  public void mostrarVista() {
    List<Estudiante> estudiantes = listaTodosLosEstudiantes();
    vista.mostrarDetallesEstudiante(estudiantes);
  }
}
// Duplicate file placeholder removed. The real `ControladorEstudiante` implementation
// lives in `com/uniajc/controlador/ControladorEstudiante.java` (lowercase folder).
// This file was left to avoid case-only path conflicts on Windows; keep it empty.
