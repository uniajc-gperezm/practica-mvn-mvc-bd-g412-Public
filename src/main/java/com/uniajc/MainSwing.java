package com.uniajc;

import com.uniajc.vista.swing.VistaEstudianteSwing;
import javax.swing.SwingUtilities;



public class MainSwing {
    public static void main(String[] args) {

    // Ejecutar interfaz en el Event Dispatch Thread de Swing
    SwingUtilities.invokeLater(() -> {
    
        // Crear vista Swing
      VistaEstudianteSwing vista = new VistaEstudianteSwing();
 
         // Asignar controlador a la vista
      //vista.setControlador(controlador);
 
        // Mostrar ventana
      vista.setVisible(true);
    });
    }
}
