package com.uniajc.vista.swing;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
//import com.uniajc.controlador.ControladorEstudiante;
 
import javax.swing.*;
 
public class VistaEstudianteSwing extends JFrame {

//componentes interfaz
private JTable tablaEstudiantes;
private DefaultTableModel modeloTabla;
private JTextField txtNombre;
private JTextField txtEdad;
private JTextField txtNombreOriginal;
private JTextField txtBusquedadId;
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

//public void setControlador(ControladorEstudianteSwing controlador){
    //btnAgregar.addActionListener(controlador);
    //btnActualizar.addActionListener(controlador);
    //btnEliminar.addActionListener(controlador);
    //btnBuscarId.addActionListener(controlador);
    //btnBuscarNombre.addActionListener(controlador);
    //btnRefrescar.addActionListener(controlador);
    //btnLimpiar.addActionListener(controlador);


private void inicializarComponentes(){
    setTitle("Gestión de Estudiantes");
    setSize(800,600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout(10, 10));
}
}



