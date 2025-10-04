package com.uniajc;

import com.uniajc.controlador.ControladorEstudiante;
import com.uniajc.db.ConexionDatabase;
import com.uniajc.modelo.Estudiante;
import com.uniajc.vista.VistaEstudiante;

import java.sql.Connection;

/**
 * Clase principal del programa. Demuestra el uso del patrón MVC para gestionar
 * estudiantes.
 */
public class Main {
  public static void main(String[] args) {
    // Establecer la conexión a la base de datos (usando config.properties)
    Connection conexion = ConexionDatabase.getConnection();

    // Crear el modelo (estudiante), la vista y el controlador
    Estudiante modelo = new Estudiante();
    modelo.setNombre("Juan Perez Pepito"); // Asignar nombre
    modelo.setEdad(21); // Asignar edad

    VistaEstudiante vista = new VistaEstudiante();
    ControladorEstudiante controlador = new ControladorEstudiante(modelo, vista);

    // Insertar el estudiante en la base de datos
    controlador.crearEstudiante(modelo);

    // Actualizar los datos del estudiante (ejemplo de actualización)
    controlador.actualizarId(42); // Asignar id (debe existir en la base de datos)
    controlador.actualizarNombre("Carlos Gomez");
    controlador.actualizarEdad(22);
    controlador.actualizarEstudiante(modelo);

    // Mostrar todos los estudiantes registrados en la base de datos
    controlador.mostrarVista();

    // Cerrar la conexión si es necesario (opcional)
    // ConexionDatabase.closeConnection();
  }
}