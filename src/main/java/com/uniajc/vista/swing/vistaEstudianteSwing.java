package com.uniajc.vista.swing;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

/**
 * Implementación mínima de la vista Swing para evitar errores de compilación.
 */
public class VistaEstudianteSwing extends JFrame {

  public VistaEstudianteSwing() {
    super("Vista Estudiante - Swing");
    initUI();
  }

  private void initUI() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(480, 320);
    setLocationRelativeTo(null);

    JPanel panel = new JPanel(new BorderLayout());
    panel.add(new JLabel("Interfaz básica de Estudiantes (Swing)"), BorderLayout.CENTER);
    setContentPane(panel);
  }

  /**
   * Placeholder para permitir que el controlador sea inyectado desde MainSwing.
   */
  public void setControlador(Object controlador) {
    // Opcional: almacenar referencia si se necesita interacción con el controlador
  }
}
