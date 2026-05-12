/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autogestionestudiantil;

/**
 *
 * @author baldo
 */
import java.util.ArrayList;
public class InscripcionMateria implements Evaluable {
    private Materia materia;
    private int totalClases;
    private int clasesAsistidas;
    private ArrayList<Double> notas;

    public InscripcionMateria(Materia materia) {
        this.materia = materia;
        this.totalClases = 0;
        this.clasesAsistidas = 0;
        this.notas = new ArrayList<>(); 
    }
    
    public void registrarAsistencia(boolean presente) {
        this.totalClases++;         // se registra y sube el total de clases
        if (presente) {
            this.clasesAsistidas++;
        }
        
        double porcentaje = getPorcentajeAsistencia();
        System.out.println("Asistencia actualizada: " + porcentaje + "%");    // porcentaje de asistencia actualizado tras cada registro

        if (porcentaje < 80) {
            System.out.println(" Asistencia en zona de riesgo (menor al 80%.");         // alerta porcentaje menor a 80 
        } else if (porcentaje < 75) {
            System.out.println("Alerta! El alumno perdió la regularidad.");             // alerta perdida de regularidad
        }
}
 
    public void agregarNota(double nota) {
        if (nota >= 0 && nota <= 10) {          //  rango 0-10
            if (notas.size() < 5) {            // máximo 5 notas
                notas.add(nota);
            } else {
                System.out.println("Error: No se pueden cargar más de 5 notas.");
            }
        } else {
            System.out.println("Error: La nota debe estar entre 0 y 10.");
        }
    }
    
    public double getPorcentajeAsistencia() {    // calcula y retorna el porcentaje de asistencia
        if (totalClases == 0) 
            return 0;
        return (double) clasesAsistidas / totalClases * 100;
    }

    @Override
    public double getPromedio() {                    // implementa interfaz evaluable 
        if (notas.isEmpty()) 
            return 0;
        double suma = 0;
        for (double n : notas) {
            suma += n;
        }
        return suma / notas.size();
    }

    @Override
    public String getCondicion() {                  // condicion - regular si asistencia >= 75%, sino Libre 
        if (getPorcentajeAsistencia() >= 75) {
            return "Regular";
        } else {
            return "Libre";
        }
    }

    @Override
    public boolean estaAprobada() {                 // aprobada si promedio >= 6 y condición regular
        return getPromedio() >= 6 && getCondicion().equals("Regular");
    }
    
    public Materia getMateria() {
        return materia;
    }   
}
