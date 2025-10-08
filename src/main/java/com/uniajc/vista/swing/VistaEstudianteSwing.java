package com.uniajc.vista.swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import com.uniajc.controlador.ControladorEstudiante;


public class VistaEstudianteSwing extends JFrame {

// Componentes de la interfaz    
private JTable tablaEstudiantes;
private DefaultTableModel modeloTabla;
private JTextField txtNombre;
private JTextField txtEdad;
private JTextField txtNombreOriginal;
private JTextField txtBusquedaId;
private JTextField txtBusquedaNombre;

// Botones
private JButton btnAgregar;
private JButton btnActualizar;
private JButton btnEliminar;
private JButton btnBuscarId;
private JButton btnBuscarNombre;
private JButton btnRefrescar;
private JButton btnLimpiar;

public VistaEstudianteSwing() {
 inicializarComponentes();
}

// public void setControlador(ControladorEstudiante controlador) {

    private void inicializarComponentes() {
        setTitle("Sistema de Gestión de Estudiantes - Swing");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // panel 
        



    }
// }

}
