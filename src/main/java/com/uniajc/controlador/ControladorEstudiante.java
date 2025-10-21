package com.uniajc.controlador;

import java.util.List;
import com.uniajc.modelo.Estudiante;
import com.uniajc.vista.VistaEstudiante;

/**
 * Controlador para gestionar la lógica entre el modelo Estudiante y la vista
 * VistaEstudiante.
 * Permite crear, actualizar, eliminar, consultar y mostrar estudiantes.
 */
public class ControladorEstudiante {
  // Instancia del modelo
  private Estudiante estudiante;
  // Instancia de la vista
  private VistaEstudiante vista;

  /**
   * Constructor del controlador.
   * 
   * @param estudiante Modelo de estudiante a gestionar.
   * @param vista      Vista para mostrar los datos.
   */

   public ControladorEstudiante() {
    this.estudiante = null;
    this.vista = null;
   }

  public ControladorEstudiante(Estudiante estudiante, VistaEstudiante vista) {
    this.estudiante = estudiante;
    this.vista = vista;
  }

  // Métodos para actualizar y obtener los atributos del estudiante
  public void actualizarId(int id) {
    estudiante.setId(id);
  }

  public int obtenerId() {
    return estudiante.getId();
  }

  public void actualizarNombre(String nombre) {
    estudiante.setNombre(nombre);
  }

  public void actualizarEdad(int edad) {
    estudiante.setEdad(edad);
  }

  public String obtenerNombre() {
    return estudiante.getNombre();
  }

  public int obtenerEdad() {
    return estudiante.getEdad();
  }

  /**
   * Inserta un nuevo estudiante en la base de datos.
   * 
   * @param estudiante El estudiante a crear.
   */
  public void crearEstudiante(Estudiante estudiante) {
    Estudiante.insertarEstudiante(estudiante);
    System.out.println("Estudiante creado: " + estudiante.getNombre() + ", Edad: " + estudiante.getEdad());
  }

  /**
   * Actualiza los datos de un estudiante existente.
   * 
   * @param estudiante El estudiante con id y nuevos datos.
   */
  public void actualizarEstudiante(Estudiante estudiante) {
    Estudiante.updateEstudiante(estudiante);
    System.out.println("Estudiante actualizado: " + estudiante.getNombre() + ", Edad: " + estudiante.getEdad());
  }

  /**
   * Elimina un estudiante de la base de datos.
   * 
   * @param estudiante El estudiante a eliminar (debe tener id).
   */
  public void eliminarEstudiante(Estudiante estudiante) {
    Estudiante.deleteEstudiante(estudiante);
    System.out.println("Estudiante elimninado: " + estudiante.getNombre() + ", Edad: " + estudiante.getEdad());
  }

  /**
   * Consulta un estudiante por su id.
   * 
   * @param id El id del estudiante a buscar.
   * @return El estudiante encontrado o null si no existe.
   */
  public Estudiante consultarEstudiantePorId(int id) {
    return Estudiante.consultarEstudiantePorId(id);
  }

  /**
   * Obtiene la lista de todos los estudiantes registrados.
   * 
   * @return Lista de estudiantes.
   */
  public List<Estudiante> listaTodosLosEstudiantes() {
    return Estudiante.obtenerTodosLosEstudiantes();
  }

  /**
   * Muestra los detalles de todos los estudiantes usando la vista.
   */
  public void mostrarVista() {
    List<Estudiante> estudiantes = listaTodosLosEstudiantes();
    vista.mostrarDetallesEstudiante(estudiantes);
  }
}