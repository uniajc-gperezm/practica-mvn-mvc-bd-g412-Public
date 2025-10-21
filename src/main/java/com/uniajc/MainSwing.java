package com.uniajc;

import javax.swing.SwingUtilities;

import com.uniajc.controlador.ControladorEstudiante;
import com.uniajc.modelo.Estudiante;
// Make sure this import matches the actual package and class name
import com.uniajc.vista.swing.*;

public class MainSwing {

    public static void main(String[] args) {
        // Ejecutar interfaz en el Event Dispatch Thread de Swing
        SwingUtilities.invokeLater(() -> {
            // Crear vista Swing
            VistaEstudianteSwing vista = new VistaEstudianteSwing();

            // Asignar controlador a la vista
            vista.setControlador( new ControladorEstudiante() );

            // Mostrar ventana
            vista.setVisible(true);
        });
    }

}
