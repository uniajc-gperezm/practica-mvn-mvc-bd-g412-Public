package com.uniajc.controlador;

import java.util.List;

import com.uniajc.modelo.Estudiante;
import com.uniajc.vista.VistaEstudiante;

public class ControladorEstudiante {
  private Estudiante estudiante;
  private VistaEstudiante vista;

  public ControladorEstudiante(Estudiante estudiante, VistaEstudiante vista) {
    this.estudiante = estudiante;
    this.vista = vista;
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

  public List<Estudiante> listaTodosLosEstudiantes() {
    return Estudiante.obtenerTodosLosEstudiantes();
  }

  public void mostrarVista() {
    List<Estudiante> estudiantes = listaTodosLosEstudiantes();
    vista.mostrarDetallesEstudiante(estudiantes);
  }
}