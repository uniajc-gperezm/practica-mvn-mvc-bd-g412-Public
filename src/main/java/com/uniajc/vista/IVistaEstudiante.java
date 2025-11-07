package com.uniajc.vista;

import java.util.List;

import com.uniajc.modelo.Estudiante;

/**
 * Interfaz común para vistas de Estudiante (consola o Swing).
 */
public interface IVistaEstudiante {
  void mostrarDetallesEstudiante(List<Estudiante> estudiantes);
  void mostrarMensaje(String mensaje);
}
