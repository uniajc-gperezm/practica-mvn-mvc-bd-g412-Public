package com.uniajc.vista.consola;

import java.util.List;

import com.uniajc.modelo.Docente;
import com.uniajc.vista.IVistaDocente;

/**
 * Vista de consola para Docente (simple impresión por consola).
 */
public class VistaDocente implements IVistaDocente {

  @Override
  public void mostrarDetallesDocente(List<Docente> docentes) {
    System.out.println("Lista de docentes:");
    for (Docente d : docentes) {
      System.out.println(" - " + d.getId() + ": " + d.getNombre() + " <" + d.getCorreo() + "> - " + d.getTitulos());
    }
  }

  @Override
  public void mostrarMensaje(String mensaje) {
    System.out.println(mensaje);
  }

}
