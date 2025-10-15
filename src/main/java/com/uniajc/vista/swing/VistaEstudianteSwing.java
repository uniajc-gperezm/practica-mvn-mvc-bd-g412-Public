package com.uniajc.vista.swing;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
//import java.awt.event.*;
//import com.uniajc.controlador.ControladorEstudiante;
 
import javax.swing.*;
import java.util.List;
import com.uniajc.modelo.Estudiante;
 
public class VistaEstudianteSwing extends JFrame {

//componentes interfaz
private JTable tablaEstudiantes;
private DefaultTableModel modeloTabla;
private JTextField txtNombre;
private JTextField txtEdad;
private JTextField txtNombreOriginal;
private JTextField txtBusquedaId;
private JTextField txtBusquedaNombre;

//Botones

private JButton btnAgregar;
private JButton btnActualizar;
private JButton btnEliminar;
private JButton btnBuscarId;
private JButton btnBuscarNombre;
private JButton btnRefrescar;
private JButton btnLimpiar;

public VistaEstudianteSwing(){
    inicializarComponentes();
}

/**
 * Permite registrar un ActionListener (controlador) para los botones de la vista.
 */
public void setControlador(java.awt.event.ActionListener controlador){
    btnAgregar.addActionListener(controlador);
    btnActualizar.addActionListener(controlador);
    btnEliminar.addActionListener(controlador);
    btnBuscarId.addActionListener(controlador);
    btnBuscarNombre.addActionListener(controlador);
    btnRefrescar.addActionListener(controlador);
    btnLimpiar.addActionListener(controlador);
}

// Getters para que el controlador pueda leer los campos
public String getNombre(){
    return txtNombre.getText();
}

public String getNombreOriginal(){
    return txtNombreOriginal.getText();
}

public String getEdadText(){
    return txtEdad.getText();
}

public String getBusquedaId(){
    return txtBusquedaId.getText();
}

public String getBusquedaNombre(){
    return txtBusquedaNombre.getText();
}

/** Limpia los campos de entrada */
public void limpiarCampos(){
    txtNombre.setText("");
    txtNombreOriginal.setText("");
    txtEdad.setText("");
    txtBusquedaId.setText("");
    txtBusquedaNombre.setText("");
}

/** Devuelve el id del estudiante en la fila seleccionada de la tabla, o -1 si no hay selección */
public int getSelectedRowId(){
    int row = tablaEstudiantes.getSelectedRow();
    if(row == -1) return -1;
    Object val = modeloTabla.getValueAt(row, 0);
    if(val == null) return -1;
    try{ return Integer.parseInt(val.toString()); }catch(NumberFormatException ex){ return -1; }
}

public void showInfo(String msg){
    JOptionPane.showMessageDialog(this, msg, "Información", JOptionPane.INFORMATION_MESSAGE);
}

public void showError(String msg){
    JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
}

/** Rellena la tabla con la lista de estudiantes proporcionada */
public void setTablaData(List<Estudiante> estudiantes){
    // limpiar modelo
    modeloTabla.setRowCount(0);
    if(estudiantes == null) return;
    for(Estudiante e : estudiantes){
        modeloTabla.addRow(new Object[]{e.getId(), e.getNombre(), e.getEdad()});
    }
}


private void inicializarComponentes(){
    setTitle("Gestión de Estudiantes");
    setSize(800,600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout(10, 10));

    // Panel superior para entradas de datos
    JPanel panelSuperior = new JPanel(new GridLayout(1, 2, 7, 7));

    panelSuperior.add(new JLabel("Nombre:"));
    txtNombre = new JTextField();
    panelSuperior.add(txtNombre);

    panelSuperior.add(new JLabel("Nombre original:"));
    txtNombreOriginal = new JTextField();
    panelSuperior.add(txtNombreOriginal);

    panelSuperior.add(new JLabel("Edad:"));
    txtEdad = new JTextField();
    panelSuperior.add(txtEdad);

    add(panelSuperior, BorderLayout.NORTH);
    
    // Panel central para la tabla
    modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Edad"}, 0);
    tablaEstudiantes = new JTable(modeloTabla);
    JScrollPane scrollPane = new JScrollPane(tablaEstudiantes);
    add(scrollPane, BorderLayout.CENTER);
    
    // Panel inferior para botones
    JPanel panelInferior = new JPanel(new GridLayout(1, 7, 10, 10));
    
    btnAgregar = new JButton("Agregar");
    panelInferior.add(btnAgregar);
    
    btnActualizar = new JButton("Actualizar");
    panelInferior.add(btnActualizar);
    
    btnEliminar = new JButton("Eliminar");
    panelInferior.add(btnEliminar);
    
    btnRefrescar = new JButton("Refrescar");
    panelInferior.add(btnRefrescar);
    
    btnLimpiar = new JButton("Limpiar");
    panelInferior.add(btnLimpiar);
    
    add(panelInferior, BorderLayout.SOUTH);

    // Panel lateral derecho para botones de búsqueda
    JPanel panelDerecho = new JPanel(new GridLayout(7, 7, 10, 10));
    
    panelDerecho.add(new JLabel("Buscar ID:"));
    txtBusquedaId = new JTextField();
    panelDerecho.add(txtBusquedaId);
    btnBuscarId = new JButton("Buscar ID");
    panelDerecho.add(btnBuscarId);

    txtBusquedaId = new JTextField();

    panelDerecho.add(new JLabel("Buscar nombre:"));
    txtBusquedaNombre = new JTextField();
    panelDerecho.add(txtBusquedaNombre);
    btnBuscarNombre = new JButton("Buscar Nombre");
    panelDerecho.add(btnBuscarNombre);

    add(panelDerecho, BorderLayout.EAST);
}
}



