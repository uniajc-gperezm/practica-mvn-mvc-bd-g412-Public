package com.uniajc.vista;

import java.util.List;

import com.uniajc.modelo.Docente;

/**
 * Interfaz para vistas de Docente.
 */
public interface IVistaDocente {
  void mostrarDetallesDocente(List<Docente> docentes);
  void mostrarMensaje(String mensaje);
}
