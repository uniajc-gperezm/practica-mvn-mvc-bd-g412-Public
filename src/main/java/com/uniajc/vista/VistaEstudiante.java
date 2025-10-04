package com.uniajc.vista;

import java.util.List;
import com.uniajc.modelo.Estudiante;

/**
 * Vista para mostrar los detalles de los estudiantes en consola.
 */
public class VistaEstudiante {

  /**
   * Muestra en consola los detalles de una lista de estudiantes.
   * 
   * @param estudiantes Lista de estudiantes a mostrar.
   */
  public void mostrarDetallesEstudiante(List<Estudiante> estudiantes) {
    System.out.println("=== Detalles de los Estudiantes ===");

    for (Estudiante estudiante : estudiantes) {
      System.out.println("Nombre: " + estudiante.getNombre());
      System.out.println("Edad: " + estudiante.getEdad());
      System.out.println("---------------------------");
    }

  }

}