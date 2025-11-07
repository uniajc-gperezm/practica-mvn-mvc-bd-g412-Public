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

import com.uniajc.modelo.Docente;
import com.uniajc.vista.IVistaDocente;

/**
 * Vista Swing para Docente, similar a VistaEstudianteSwing.
 */
public class VistaDocenteSwing extends JFrame implements IVistaDocente {

  private DefaultListModel<Docente> listModel = new DefaultListModel<>();
  private JList<Docente> list = new JList<>(listModel);
  private JTextField nombreField = new JTextField(20);
  private JTextField correoField = new JTextField(20);
  private JTextField titulosField = new JTextField(20);
  private Object controlador;

  public VistaDocenteSwing() {
    super("Vista Docente - Swing");
    initUI();
  }

  private void initUI() {
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setSize(700, 460);
    setLocationRelativeTo(null);

    JPanel main = new JPanel(new BorderLayout());

    JScrollPane scroll = new JScrollPane(list);
    main.add(scroll, BorderLayout.CENTER);

    JPanel form = new JPanel(new FlowLayout(FlowLayout.LEFT));
    form.add(new JLabel("Nombre:"));
    form.add(nombreField);
    form.add(new JLabel("Correo:"));
    form.add(correoField);
    form.add(new JLabel("Títulos:"));
    form.add(titulosField);

    JButton addBtn = new JButton("Crear");
    JButton updateBtn = new JButton("Actualizar");
    JButton delBtn = new JButton("Eliminar");

    form.add(addBtn);
    form.add(updateBtn);
    form.add(delBtn);

    main.add(form, BorderLayout.SOUTH);

    list.addListSelectionListener(e -> {
      if (!e.getValueIsAdjusting()) {
        Docente d = list.getSelectedValue();
        if (d != null) {
          nombreField.setText(d.getNombre());
          correoField.setText(d.getCorreo());
          titulosField.setText(d.getTitulos());
        }
      }
    });

    addBtn.addActionListener(e -> {
      String nombre = nombreField.getText().trim();
      String correo = correoField.getText().trim();
      String titulos = titulosField.getText().trim();
      if (nombre.isEmpty()) { mostrarMensaje("El nombre no puede estar vacío"); return; }
      if (correo.isEmpty()) { mostrarMensaje("El correo no puede estar vacío"); return; }
      Docente d = new Docente();
      d.setNombre(nombre);
      d.setCorreo(correo);
      d.setTitulos(titulos);
      if (controlador != null) {
        try {
          invokeMethod(controlador, "crearDocente", new Class<?>[] { Docente.class }, new Object[] { d });
          invokeMethod(controlador, "mostrarVista", new Class<?>[0], new Object[0]);
        } catch (Exception ex) {
          mostrarMensaje("Error al invocar al controlador: " + ex.getMessage());
        }
      }
    });

    updateBtn.addActionListener(ae -> {
      Docente sel = list.getSelectedValue();
      if (sel == null) { mostrarMensaje("Seleccione un docente para actualizar"); return; }
      String nombre = nombreField.getText().trim();
      String correo = correoField.getText().trim();
      String titulos = titulosField.getText().trim();
      if (nombre.isEmpty()) { mostrarMensaje("El nombre no puede estar vacío"); return; }
      sel.setNombre(nombre);
      sel.setCorreo(correo);
      sel.setTitulos(titulos);
      if (controlador != null) {
        try {
          invokeMethod(controlador, "actualizarDocente", new Class<?>[] { Docente.class }, new Object[] { sel });
          invokeMethod(controlador, "mostrarVista", new Class<?>[0], new Object[0]);
        } catch (Exception ex) {
          mostrarMensaje("Error al invocar al controlador: " + ex.getMessage());
        }
      }
    });

    delBtn.addActionListener(ae -> {
      Docente sel = list.getSelectedValue();
      if (sel == null) { mostrarMensaje("Seleccione un docente para eliminar"); return; }
      int resp = JOptionPane.showConfirmDialog(this, "¿Eliminar al docente '" + sel.getNombre() + "'?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
      if (resp != JOptionPane.YES_OPTION) return;
      if (controlador != null) {
        try {
          invokeMethod(controlador, "eliminarDocente", new Class<?>[] { Docente.class }, new Object[] { sel });
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

  private void invokeMethod(Object target, String name, Class<?>[] paramTypes, Object[] args) throws Exception {
    if (target == null) return;
    Class<?> cls = target.getClass();
    java.lang.reflect.Method m = cls.getMethod(name, paramTypes);
    m.invoke(target, args);
  }

  @Override
  public void mostrarDetallesDocente(List<Docente> docentes) {
    listModel.clear();
    for (Docente d : docentes) listModel.addElement(d);
  }

  @Override
  public void mostrarMensaje(String mensaje) {
    JOptionPane.showMessageDialog(this, mensaje);
  }

}
