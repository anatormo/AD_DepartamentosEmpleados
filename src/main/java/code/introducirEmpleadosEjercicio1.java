package code;

import classes.Empleado;
import libs.CheckArchivos;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;


public class introducirEmpleadosEjercicio1 {
    public static void introducirGuardar() {

        Scanner sc = new Scanner(System.in);
        Empleado empleado =new Empleado();
        ArrayList<Empleado> listaEmpleado = new ArrayList<>();
        String opcion;


        do {
            datosEmpleados(empleado);
            listaEmpleado.add(empleado);
            System.out.println("¿Desea introducir otro empleado? (si, no)");
            opcion = sc.nextLine();
            if (opcion.equals("no")) {
                guardarDatosEmpleados(listaEmpleado);
                System.out.println("Los datos de los empleados se han guardado correctamente");
                libs.MenuPrincipal.llamarMenuPrincipal();

            }
        } while (opcion.equals("si"));

    }

    private static void guardarDatosEmpleados(ArrayList<Empleado> listaEmpleado) {
        try {
            //comprobamos que es un fichero que se puede escribir y existe, si no lo creará
            CheckArchivos.ficheroEscribible(Path.of("src/main/java/archivos/datosEmpleados.csv"));
            FileWriter fichero = new FileWriter("src/main/java/archivos/datosEmpleados.csv");

            for (Empleado empleado : listaEmpleado) {
                fichero.write(empleado.getNombre() + ", " + empleado.getSueldo() + ", " +
                        empleado.getNacimiento() + ", " + empleado.getAño() + "\n");
            }
            fichero.close();
        } catch (IOException e) {
            System.out.println("No se han podido guardar los datos");
        }
    }

    private static void datosEmpleados(Empleado empleado) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre: ");
        String nombre = sc.next();
        System.out.println("Introduce el sueldo: ");
        double sueldo = sc.nextDouble();
        System.out.println("Introduce el año de nacimiento: ");
        String nacimiento = sc.next();
        System.out.println("Introduce la antigüedad: ");
        String antiguedad = sc.next();

        empleado.setNombre(nombre);
        empleado.setSueldo(sueldo);
        empleado.setNacimiento(nacimiento);
        empleado.setAño(antiguedad);

    }

}

