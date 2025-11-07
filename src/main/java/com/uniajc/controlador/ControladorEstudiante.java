package com.uniajc.Controlador;

import java.util.List;

import com.uniajc.modelo.Estudiante;
import com.uniajc.vista.IVistaEstudiante;

/**
 * Controlador para gestionar la lógica entre el modelo Estudiante y la vista.
 */
public class ControladorEstudiante {
    private Estudiante estudiante;
    private IVistaEstudiante vista;

    public ControladorEstudiante(Estudiante modelo, IVistaEstudiante vista) {
        this.estudiante = modelo;
        this.vista = vista;
    }

    public void actualizarId(int id) {
        estudiante.setId(id);
    }

    public int obtenerId() {
        return estudiante.getId();
    }

    public void actualizarNombre(String nombre) {
        estudiante.setNombre(nombre);
    }

    public void actualizarCorreo(String correo) {
        estudiante.setCorreo(correo);
    }

    public String obtenerNombre() {
        return estudiante.getNombre();
    }

    public String obtenerCorreo() {
        return estudiante.getCorreo();
    }

    public void crearEstudiante(Estudiante estudiante) {
        Estudiante.insertarEstudiante(estudiante);
        String msg = "Estudiante creado: " + estudiante.getNombre() + ", Correo: " + estudiante.getCorreo();
        if (vista != null) vista.mostrarMensaje(msg);
        else System.out.println(msg);
    }

    public void actualizarEstudiante(Estudiante estudiante) {
        Estudiante.updateEstudiante(estudiante);
        String msg = "Estudiante actualizado: " + estudiante.getNombre() + ", Correo: " + estudiante.getCorreo();
        if (vista != null) vista.mostrarMensaje(msg);
        else System.out.println(msg);
    }

    public void eliminarEstudiante(Estudiante estudiante) {
        Estudiante.deleteEstudiante(estudiante);
        String msg = "Estudiante eliminado: " + estudiante.getNombre();
        if (vista != null) vista.mostrarMensaje(msg);
        else System.out.println(msg);
    }

    public Estudiante consultarEstudiantePorId(int id) {
        return Estudiante.consultarEstudiantePorId(id);
    }

    public List<Estudiante> listaTodosLosEstudiantes() {
        return Estudiante.obtenerTodosLosEstudiantes();
    }

    public void mostrarVista() {
        List<Estudiante> estudiantes = listaTodosLosEstudiantes();
        if (vista != null) vista.mostrarDetallesEstudiante(estudiantes);
    }
}
