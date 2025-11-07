package com.uniajc.vista.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.uniajc.modelo.Estudiante;
import com.uniajc.vista.IVistaEstudiante;

/**
 * Implementación mínima de la vista Swing (nombre coincide con el fichero:
 * vistaEstudianteSwing.java). Mantengo el nombre en minúscula para evitar
 * problemas de case-only renames en Windows; si quieres que lo pase a
 * PascalCase haré el rename seguro vía git (recomendado).
 */
public class VistaEstudianteSwing extends JFrame implements IVistaEstudiante {

  private DefaultListModel<Estudiante> listModel = new DefaultListModel<>();
  private JList<Estudiante> list = new JList<>(listModel);
  private JTextField nombreField = new JTextField(20);
  private JTextField edadField = new JTextField(4);
  private Object controlador;

  public VistaEstudianteSwing() {
    super("Vista Estudiante - Swing");
    initUI();
  }

  private void initUI() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(640, 420);
    setLocationRelativeTo(null);

    JPanel main = new JPanel(new BorderLayout());

    // Lista
    JScrollPane scroll = new JScrollPane(list);
    main.add(scroll, BorderLayout.CENTER);

    // Form
    JPanel form = new JPanel(new FlowLayout(FlowLayout.LEFT));
    form.add(new JLabel("Nombre:"));
    form.add(nombreField);
    form.add(new JLabel("Edad:"));
    form.add(edadField);

    JButton addBtn = new JButton("Crear");
    JButton updateBtn = new JButton("Actualizar");
    JButton delBtn = new JButton("Eliminar");

    form.add(addBtn);
    form.add(updateBtn);
    form.add(delBtn);

    main.add(form, BorderLayout.SOUTH);

    // List selection listener to populate form
    list.addListSelectionListener(e -> {
      if (!e.getValueIsAdjusting()) {
        Estudiante s = list.getSelectedValue();
        if (s != null) {
          nombreField.setText(s.getNombre());
          edadField.setText(String.valueOf(s.getEdad()));
        }
      }
    });

    // Button actions -> delegate to controller
    addBtn.addActionListener(e -> {
      String nombre = nombreField.getText().trim();
      String edadText = edadField.getText().trim();
      if (nombre.isEmpty()) {
        mostrarMensaje("El nombre no puede estar vacío");
        return;
      }
      int edad;
      try {
        edad = Integer.parseInt(edadText);
        if (edad < 0) {
          mostrarMensaje("La edad debe ser un número positivo");
          return;
        }
      } catch (NumberFormatException ex) {
        mostrarMensaje("Edad inválida");
        return;
      }
      Estudiante s = new Estudiante();
      s.setNombre(nombre);
      s.setEdad(edad);
      if (controlador != null) {
        try {
          invokeMethod(controlador, "crearEstudiante", new Class<?>[] { Estudiante.class }, new Object[] { s });
          invokeMethod(controlador, "mostrarVista", new Class<?>[0], new Object[0]);
        } catch (Exception ex) {
          mostrarMensaje("Error al invocar al controlador: " + ex.getMessage());
        }
      }
    });

    updateBtn.addActionListener(ae -> {
      Estudiante sel = list.getSelectedValue();
      if (sel == null) {
        mostrarMensaje("Seleccione un estudiante para actualizar");
        return;
      }
      String nombre = nombreField.getText().trim();
      String edadText = edadField.getText().trim();
      if (nombre.isEmpty()) {
        mostrarMensaje("El nombre no puede estar vacío");
        return;
      }
      int edad;
      try {
        edad = Integer.parseInt(edadText);
        if (edad < 0) {
          mostrarMensaje("La edad debe ser un número positivo");
          return;
        }
      } catch (NumberFormatException ex) {
        mostrarMensaje("Edad inválida");
        return;
      }
      sel.setNombre(nombre);
      sel.setEdad(edad);
      if (controlador != null) {
        try {
          invokeMethod(controlador, "actualizarEstudiante", new Class<?>[] { Estudiante.class }, new Object[] { sel });
          invokeMethod(controlador, "mostrarVista", new Class<?>[0], new Object[0]);
        } catch (Exception ex) {
          mostrarMensaje("Error al invocar al controlador: " + ex.getMessage());
        }
      }
    });

    delBtn.addActionListener(ae -> {
      Estudiante sel = list.getSelectedValue();
      if (sel == null) {
        mostrarMensaje("Seleccione un estudiante para eliminar");
        return;
      }
      int resp = JOptionPane.showConfirmDialog(this, "¿Eliminar el estudiante '" + sel.getNombre() + "'?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
      if (resp != JOptionPane.YES_OPTION) return;
      if (controlador != null) {
        try {
          invokeMethod(controlador, "eliminarEstudiante", new Class<?>[] { Estudiante.class }, new Object[] { sel });
          invokeMethod(controlador, "mostrarVista", new Class<?>[0], new Object[0]);
        } catch (Exception ex) {
          mostrarMensaje("Error al invocar al controlador: " + ex.getMessage());
        }
      }
    });

    setContentPane(main);
  }

  public void setControlador(Object controlador) {
    this.controlador = controlador;
  }

  /**
   * Utility to invoke controller methods by name using reflection so this class
   * does not depend at compile time on a specific controller type.
   */
  private void invokeMethod(Object target, String name, Class<?>[] paramTypes, Object[] args) throws Exception {
    if (target == null) return;
    Class<?> cls = target.getClass();
    java.lang.reflect.Method m = cls.getMethod(name, paramTypes);
    m.invoke(target, args);
  }

  @Override
  public void mostrarDetallesEstudiante(List<Estudiante> estudiantes) {
    listModel.clear();
    for (Estudiante s : estudiantes) {
      listModel.addElement(s);
    }
  }

  @Override
  public void mostrarMensaje(String mensaje) {
    // Mostrar mensaje usando un diálogo de Swing
    JOptionPane.showMessageDialog(this, mensaje);
  }

}

