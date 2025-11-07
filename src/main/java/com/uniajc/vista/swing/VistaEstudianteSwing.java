package com.uniajc.vista.swing;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Implementación mínima de la vista Swing (nombre coincide con el fichero:
 * vistaEstudianteSwing.java). Mantengo el nombre en minúscula para evitar
 * problemas de case-only renames en Windows; si quieres que lo pase a
 * PascalCase haré el rename seguro vía git (recomendado).
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

  public void setControlador(Object controlador) {
    // Implementar si se necesita interacción con el controlador
  }
}

