package com.uniajc;

import com.uniajc.controlador.ControladorEstudiante;
import com.uniajc.db.ConexionDatabase;
import com.uniajc.modelo.Estudiante;
import com.uniajc.vista.VistaEstudiante;

import java.sql.Connection;

public class Main {
  public static void main(String[] args) {
    // System.out.println("Bienvenido Estudiante!");

    Connection conexion = ConexionDatabase.getConnection();
    // Crear el modelo, la vista y el controlador
    Estudiante modelo = new Estudiante();
    modelo.setNombre("Juan Perez");
    modelo.setEdad(20);

    VistaEstudiante vista = new VistaEstudiante();

    ControladorEstudiante controlador = new ControladorEstudiante(modelo, vista);

    controlador.crearEstudiante(modelo);

    // Actualizar la vista con los detalles del estudiante
    controlador.mostrarVista();

    // ConexionDatabase.closeConnection();

  }
}