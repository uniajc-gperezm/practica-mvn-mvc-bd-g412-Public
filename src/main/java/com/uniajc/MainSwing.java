package com.uniajc;
import javax.swing.SwingUtilities;


public class MainSwing {

    public static void main(String[] args) {
        
    
    // Ejecutar interfaz en el Event Dispatch Thread de Swing
    SwingUtilities.invokeLater(() -> {
      // Crear vista Swing
  com.uniajc.vista.swing.VistaEstudianteSwing vista = new com.uniajc.vista.swing.VistaEstudianteSwing();

      // Asignar controlador a la vista
      //vista.setControlador(controlador);

      // Mostrar ventana
      vista.setVisible(true);
    });
}
}
