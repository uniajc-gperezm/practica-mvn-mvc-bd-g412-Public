package com.uniajc.vista;

import java.util.List;

import com.uniajc.modelo.Estudiante;

public class VistaEstudiante {

  public void mostrarDetallesEstudiante(List<Estudiante> estudiantes) {
    System.out.println("=== Detalles de los Estudiantes ===");

    for (Estudiante estudiante : estudiantes) {
      System.out.println("Nombre: " + estudiante.getNombre());
      System.out.println("Edad: " + estudiante.getEdad());
      System.out.println("---------------------------");
    }

  }

}