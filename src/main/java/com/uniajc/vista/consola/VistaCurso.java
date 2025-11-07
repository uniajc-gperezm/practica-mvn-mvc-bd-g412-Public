package com.uniajc.vista.consola;

import java.util.List;
import com.uniajc.modelo.Curso;
import com.uniajc.vista.IVistaCurso;

public class VistaCurso implements IVistaCurso {

    @Override
    public void mostrarDetallesCurso(List<Curso> cursos) {
        System.out.println("\n📚 Lista de cursos:");
        for (Curso c : cursos) {
            System.out.println(" - ID: " + c.getId() + 
                               " | Nombre: " + c.getNombre() + 
                               " | Materia: " + c.getMateria());
        }
        System.out.println();
    }

    @Override
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
