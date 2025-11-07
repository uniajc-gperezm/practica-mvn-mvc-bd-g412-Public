package com.uniajc;
import javax.swing.SwingUtilities;


public class MainSwing {

    public static void main(String[] args) {
        
    
    // Ejecutar interfaz en el Event Dispatch Thread de Swing
    SwingUtilities.invokeLater(() -> {
      // Crear vista Swing
      com.uniajc.vista.swing.VistaEstudianteSwing vista = new com.uniajc.vista.swing.VistaEstudianteSwing();

      // Crear modelo; evitar la referencia directa a ControladorEstudiante hasta corregir su paquete
      com.uniajc.modelo.Estudiante modelo = new com.uniajc.modelo.Estudiante();
      // Nota: el archivo ControladorEstudiante.java parece declarar un paquete distinto al esperado
      // (por eso falla la compilación); corrija la declaración `package` en ese archivo o
      // mueva el archivo al directorio src/main/java/com/uniajc/controlador/.
      // Por ahora no asignamos controlador para permitir la compilación.
      vista.setControlador(null);

      // Mostrar ventana
      vista.setVisible(true);
    });
}
}
