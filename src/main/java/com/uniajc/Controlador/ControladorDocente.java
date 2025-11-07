package com.uniajc.Controlador;

import java.util.List;

import com.uniajc.modelo.Docente;
import com.uniajc.vista.IVistaDocente;

/**
 * Controlador para Docente (CRUD + actualización de la vista).
 */
public class ControladorDocente {
    private Docente docente;
    private IVistaDocente vista;

    public ControladorDocente(Docente modelo, IVistaDocente vista) {
        this.docente = modelo;
        this.vista = vista;
    }

    public void actualizarId(int id) {
        docente.setId(id);
    }

    public int obtenerId() {
        return docente.getId();
    }

    public void actualizarNombre(String nombre) {
        docente.setNombre(nombre);
    }

    public void actualizarCorreo(String correo) {
        docente.setCorreo(correo);
    }

    public void actualizarTitulos(String titulos) {
        docente.setTitulos(titulos);
    }

    public String obtenerNombre() {
        return docente.getNombre();
    }

    public String obtenerCorreo() {
        return docente.getCorreo();
    }

    public String obtenerTitulos() {
        return docente.getTitulos();
    }

    public void crearDocente(Docente d) {
        Docente.insertarDocente(d);
        String msg = "Docente creado: " + d.getNombre() + " (" + d.getCorreo() + ")";
        if (vista != null) vista.mostrarMensaje(msg);
        else System.out.println(msg);
    }

    public void actualizarDocente(Docente d) {
        Docente.updateDocente(d);
        String msg = "Docente actualizado: " + d.getNombre();
        if (vista != null) vista.mostrarMensaje(msg);
        else System.out.println(msg);
    }

    public void eliminarDocente(Docente d) {
        Docente.deleteDocente(d);
        String msg = "Docente eliminado: " + d.getNombre();
        if (vista != null) vista.mostrarMensaje(msg);
        else System.out.println(msg);
    }

    public Docente consultarDocentePorId(int id) {
        return Docente.consultarDocentePorId(id);
    }

    public List<Docente> listaTodosLosDocentes() {
        return Docente.obtenerTodosLosDocentes();
    }

    public void mostrarVista() {
        List<Docente> docentes = listaTodosLosDocentes();
        if (vista != null) vista.mostrarDetallesDocente(docentes);
    }
}

