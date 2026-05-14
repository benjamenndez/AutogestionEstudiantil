/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autogestionm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class AutoGestionM {
    static Scanner sc = new Scanner(System.in);
    static List<Materia> materias = new ArrayList<>();
    public static Materia buscarMateria(int codigo) {

    for(Materia m : materias) {

        if(m.getCodigo() == codigo) {
            return m;
        }
    }

    return null;
}
    public static void inscribirEstudiante() {

    System.out.print("Codigo de la materia: ");
    int codigo = sc.nextInt();
    sc.nextLine();

    Materia m = buscarMateria(codigo);

    if(m != null) {

        System.out.print("Nombre del estudiante: ");
        String nombre = sc.nextLine();

        m.inscribirEstudiante(nombre);

        System.out.println("Estudiante inscripto.");

    } else {

        System.out.println("Materia no encontrada.");
    }
}
    public static void mostrarEstudiantesMateria() {

    System.out.print("Codigo de la materia: ");
    int codigo = sc.nextInt();

    Materia m = buscarMateria(codigo);

    if(m != null) {

        System.out.println("Materia: " + m.getNombre());

        m.mostrarEstudiantes();

    } else {

        System.out.println("Materia no encontrada.");
    }
}
    public static void main(String[] args) {
        int opcion;

        do {

            System.out.println("\n--- SISTEMA ---");
            System.out.println("1. Crear materia");
            System.out.println("2. Mostrar materias");
            System.out.println("3. Inscribir estudiante");
            System.out.println("4. Mostrar estudiantes");
            System.out.println("0. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {

                case 1:
                    crearMateria();
                    break;

                case 2:
                    mostrarMaterias();
                    break;
                    case 3:
                    inscribirEstudiante();
                    break;

                    case 4:
                    mostrarEstudiantesMateria();
                     break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while(opcion != 0);
    }

    public static void crearMateria() {

        System.out.print("Nombre de la materia: ");
        String nombre = sc.nextLine();

        System.out.print("Codigo: ");
        int codigo = sc.nextInt();

        Materia m = new Materia(nombre, codigo);

        materias.add(m);

        System.out.println("Materia creada.");
    }

    public static void mostrarMaterias() {

        for(Materia m : materias) {

            System.out.println("----------------");
            System.out.println("Nombre: " + m.getNombre());
            System.out.println("Codigo: " + m.getCodigo());
        }
    }
}
    


