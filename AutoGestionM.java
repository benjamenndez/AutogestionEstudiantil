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
    public static void main(String[] args) {
        int opcion;

        do {

            System.out.println("\n--- SISTEMA ---");
            System.out.println("1. Crear materia");
            System.out.println("2. Mostrar materias");
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
    


