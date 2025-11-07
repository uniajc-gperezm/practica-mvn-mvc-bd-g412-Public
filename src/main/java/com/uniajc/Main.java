package com.uniajc;

import java.sql.Connection;

import com.uniajc.Controlador.ControladorDocente;
import com.uniajc.Controlador.ControladorEstudiante;
import com.uniajc.db.ConexionDatabase;
import com.uniajc.modelo.Docente;
import com.uniajc.modelo.Estudiante;
import com.uniajc.vista.consola.VistaDocente;
import com.uniajc.vista.consola.VistaEstudiante;

/**
 * Clase principal del programa. Demuestra el uso del patrón MVC para gestionar
 * estudiantes.
 */
public class Main {
  public static void main(String[] args) {
    // Establecer la conexión a la base de datos (usando config.properties)
    Connection conexion = ConexionDatabase.getConnection();

    try {
      // Verificar que la conexión se haya establecido
      if (conexion == null) {
        System.err.println("No se pudo establecer la conexión a la base de datos. Abortando operaciones de BD.");
        return;
      }

      // Crear el modelo (estudiante), la vista y el controlador
      Estudiante modelo = new Estudiante();
      modelo.setNombre("Juan Perez Pepito"); // Asignar nombre
      modelo.setCorreo("juan.perez@example.com"); // Asignar correo institucional
      VistaEstudiante vista = new VistaEstudiante();
      ControladorEstudiante controlador = new ControladorEstudiante(modelo, vista);

      // Insertar el estudiante en la base de datos
      controlador.crearEstudiante(modelo);

      // Actualizar los datos del estudiante (ejemplo de actualización)
  controlador.actualizarId(42); // Asignar id (debe existir en la base de datos)
  controlador.actualizarNombre("Carlos Gomez");
  // actualizarCorreo no existía antes; usar set en el modelo y luego actualizarEstudiante
  modelo.setCorreo("carlos.gomez@example.com");
      controlador.actualizarEstudiante(modelo);

      // Mostrar todos los estudiantes registrados en la base de datos
      controlador.mostrarVista();

  // --- Operaciones de Docente (demostración similar a Estudiante)
  Docente docente = new Docente();
  docente.setNombre("Ana López");
  docente.setCorreo("ana.lopez@example.com");
  docente.setTitulos("Magíster en Matemáticas");

  VistaDocente vistaDoc = new VistaDocente();
  ControladorDocente ctrlDoc = new ControladorDocente(docente, vistaDoc);

  // Insertar docente
  ctrlDoc.crearDocente(docente);

  // Actualizar docente (ejemplo)
  docente.setNombre("Ana L. Gómez");
  docente.setTitulos("PhD en Matemáticas");
  // debe haberse asignado un id válido si queremos actualizar; este es solo ejemplo
  ctrlDoc.actualizarDocente(docente);

  // Mostrar lista de docentes
  ctrlDoc.mostrarVista();

    } finally {
      // Asegurar cierre de la conexión obtenida
      ConexionDatabase.closeConnection();
    }
  }
}