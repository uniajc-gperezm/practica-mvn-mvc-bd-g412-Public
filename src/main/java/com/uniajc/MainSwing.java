package com.uniajc;
import javax.swing.SwingUtilities;


public class MainSwing {

    public static void main(String[] args) {
        
    
    // Ejecutar interfaz en el Event Dispatch Thread de Swing
    SwingUtilities.invokeLater(() -> {
      // Ventana Estudiantes
      com.uniajc.vista.swing.VistaEstudianteSwing vistaEst = new com.uniajc.vista.swing.VistaEstudianteSwing();
      com.uniajc.modelo.Estudiante modeloEst = new com.uniajc.modelo.Estudiante();
      com.uniajc.Controlador.ControladorEstudiante controladorEst = new com.uniajc.Controlador.ControladorEstudiante(modeloEst, vistaEst);
      vistaEst.setControlador(controladorEst);
      vistaEst.setVisible(true);

      // Ventana Docentes
      com.uniajc.vista.swing.VistaDocenteSwing vistaDoc = new com.uniajc.vista.swing.VistaDocenteSwing();
      com.uniajc.modelo.Docente modeloDoc = new com.uniajc.modelo.Docente();
      com.uniajc.Controlador.ControladorDocente controladorDoc = new com.uniajc.Controlador.ControladorDocente(modeloDoc, vistaDoc);
      vistaDoc.setControlador(controladorDoc);
      vistaDoc.setVisible(true);
    });
}
}
