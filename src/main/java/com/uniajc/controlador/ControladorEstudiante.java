package com.uniajc.controlador;

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

  public void mostrarVista() {
    vista.mostrarDetallesEstudiante(estudiante.getNombre(), estudiante.getEdad());
  }
}