package com.uniajc.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import com.uniajc.modelo.Estudiante;
import com.uniajc.vista.swing.VistaEstudianteSwing;

/**
 * Controlador Swing que actúa como puente entre la vista Swing y el controlador de negocio.
 */
public class ControladorEstudianteSwing implements ActionListener {

    private final VistaEstudianteSwing vista;
    private final ControladorEstudiante controladorNegocio;

    public ControladorEstudianteSwing(VistaEstudianteSwing vista, ControladorEstudiante controladorNegocio){
        this.vista = vista;
        this.controladorNegocio = controladorNegocio;
        // registrar controlador en la vista
        this.vista.setControlador(this);
        // inicializar tabla con datos
        actualizarTabla();
    }

    private void actualizarTabla(){
        List<Estudiante> estudiantes = controladorNegocio.listaTodosLosEstudiantes();
        vista.setTablaData(estudiantes);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        try{
            switch(cmd){
                case "Agregar":
                    agregar();
                    break;
                case "Actualizar":
                    actualizar();
                    break;
                case "Eliminar":
                    eliminar();
                    break;
                case "Refrescar":
                    actualizarTabla();
                    break;
                case "Limpiar":
                    vista.limpiarCampos();
                    break;
                case "Buscar ID":
                    buscarPorId();
                    break;
                case "Buscar Nombre":
                    buscarPorNombre();
                    break;
                default:
                    // comando no reconocido
            }
        } catch(Exception ex){
            // mostrar excepción en consola; en producción usar JOptionPane
            ex.printStackTrace();
        }
    }

    private void agregar(){
        String nombre = vista.getNombre();
        String edadText = vista.getEdadText();
        int edad = 0;
        try{ edad = Integer.parseInt(edadText); } catch(NumberFormatException ex){ /* manejar validación en futuro */ }
        Estudiante e = new Estudiante();
        e.setNombre(nombre);
        e.setEdad(edad);
        controladorNegocio.crearEstudiante(e);
        actualizarTabla();
        vista.limpiarCampos();
    }

    private void actualizar(){
        int id = vista.getSelectedRowId();
        if(id == -1){
            vista.showError("Seleccione una fila en la tabla para actualizar (o proporcione un ID válido).");
            return;
        }
        String nombre = vista.getNombre();
        String edadText = vista.getEdadText();
        int edad = 0;
        try{ edad = Integer.parseInt(edadText); } catch(NumberFormatException ex){
            vista.showError("Edad inválida. Ingrese un número entero.");
            return;
        }
        Estudiante e = controladorNegocio.consultarEstudiantePorId(id);
        if(e == null){
            vista.showError("No se encontró estudiante con id: " + id);
            return;
        }
        e.setNombre(nombre);
        e.setEdad(edad);
        controladorNegocio.actualizarEstudiante(e);
        actualizarTabla();
        vista.showInfo("Estudiante actualizado correctamente.");
    }

    private void eliminar(){
        // Eliminación sencilla: usar ID de búsqueda si está presente
        String idText = vista.getBusquedaId();
        try{
            int id = Integer.parseInt(idText);
            Estudiante e = controladorNegocio.consultarEstudiantePorId(id);
            if(e != null){
                controladorNegocio.eliminarEstudiante(e);
                actualizarTabla();
            }
        }catch(NumberFormatException ex){
            // id no válido
        }
    }

    private void buscarPorId(){
        String idText = vista.getBusquedaId();
        try{
            int id = Integer.parseInt(idText);
            Estudiante e = controladorNegocio.consultarEstudiantePorId(id);
            if(e != null){
                vista.setTablaData(java.util.Arrays.asList(e));
            }
        }catch(NumberFormatException ex){
            // id no válido
        }
    }

    private void buscarPorNombre(){
        String nombre = vista.getBusquedaNombre();
        // En el modelo no existe aun método buscarPorNombre; como alternativa, filtramos la lista completa
        List<Estudiante> todos = controladorNegocio.listaTodosLosEstudiantes();
        List<Estudiante> filtrados = new java.util.ArrayList<>();
        for(Estudiante s : todos){
            if(s.getNombre() != null && s.getNombre().toLowerCase().contains(nombre.toLowerCase())){
                filtrados.add(s);
            }
        }
        vista.setTablaData(filtrados);
    }
}
