package com.uniajc.vista.consola;

import java.util.List;

import com.uniajc.modelo.Estudiante;
import com.uniajc.vista.IVistaEstudiante;

/**
 * Vista para mostrar los detalles de los estudiantes en consola.
 */
public class VistaEstudiante implements IVistaEstudiante {

  @Override
  public void mostrarDetallesEstudiante(List<Estudiante> estudiantes) {
    System.out.println("=== Detalles de los Estudiantes ===");

    for (Estudiante estudiante : estudiantes) {
      System.out.println("Nombre: " + estudiante.getNombre());
  System.out.println("Correo: " + estudiante.getCorreo());
      System.out.println("---------------------------");
    }
  }

  @Override
  public void mostrarMensaje(String mensaje) {
    System.out.println(mensaje);
  }

}