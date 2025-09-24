package com.uniajc;

import com.uniajc.controlador.ControladorEstudiante;
import com.uniajc.db.ConexionDatabase;
import com.uniajc.modelo.Estudiante;
import com.uniajc.vista.VistaEstudiante;

import java.sql.Connection;

public class Main {
  public static void main(String[] args) {
    // System.out.println("Bienvenido Estudiante!");

    // // Crear el modelo, la vista y el controlador
    // Estudiante modelo = new Estudiante("Juan Perez", 20);
    // VistaEstudiante vista = new VistaEstudiante();
    // ControladorEstudiante controlador = new ControladorEstudiante(modelo, vista);

    // // Actualizar la vista con los detalles del estudiante
    // controlador.mostrarVista();

    Connection conexion = ConexionDatabase.getConnection();

    // ConexionDatabase.closeConnection();

  }
}