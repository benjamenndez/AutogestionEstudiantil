/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autogestionm;

import java.util.ArrayList;
import java.util.List;

public class Materia {

    private String nombre;
    private int codigo;
    private List<String> estudiantes;

    public Materia(String nombre, int codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.estudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void inscribirEstudiante(String nombreEstudiante) {
        estudiantes.add(nombreEstudiante);
    }

    public void eliminarEstudiante(String nombreEstudiante) {
        estudiantes.remove(nombreEstudiante);
    }

    public void mostrarEstudiantes() {

        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes.");
        } else {

            for (String e : estudiantes) {
                System.out.println(e);
            }
        }
    }

    public int getCantidadEstudiantes() {
        return estudiantes.size();
    }
}

