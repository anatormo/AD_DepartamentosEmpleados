package code;

import classes.Departamento;
import classes.Empleado;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import libs.MenuPrincipal;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class asignarDepartamentoEjercicio3 {
    public static void asignar() {
        // Crear y cargar la lista de departamentos
        Path p = Path.of("src/main/java/archivos/departamentos.xml");
        Departamento departamentos = new Departamento();
        // Se debe utilizar un ArrayList para almacenar los departamentos
        ArrayList<Departamento> listaDep = new ArrayList<>();
        JAXBContext contexto = null;

        try {
            contexto = JAXBContext.newInstance(Departamento.class);
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            departamentos = (Departamento) unmarshaller.unmarshal(p.toFile());

            // Obtén la lista de departamentos
            listaDep = departamentos.getDepartamentoList();

        } catch (JAXBException e) {
            System.out.println("Error al leer el archivo XML: ");
        }

        // Solicitar al usuario que asigne empleados a departamentos
        Scanner sc = new Scanner(System.in);
        ArrayList<Empleado> empleados = new ArrayList<>();
        String opcion = "";

        do {
            Empleado nuevosDatosEmpleado = new Empleado();
            datosEmpleados(nuevosDatosEmpleado);
            // Mostrar la lista de departamentos para que el usuario elija
            System.out.println("Elige un departamento para asignar empleados:");

            for (Departamento recorre : listaDep) {
                 System.out.println(recorre.getId() + " " + recorre.getNombre() + " " +
                        recorre.getLocalidad());
            }

            //como la lista empieza con cero le restamos 1 para que al elegir saque la opción que queremos
            int eleccion = sc.nextInt() - 1;
            if (eleccion >= 0 && eleccion <= listaDep.size()) {
                Departamento departamentoElegido = listaDep.get(eleccion);
                // Asignar el departamento al empleado
                nuevosDatosEmpleado.setDepartamentos(departamentoElegido.getDepartamentoList());
                // Imprimir la información del empleado y su departamento
                System.out.println(nuevosDatosEmpleado.getNombre() + " ha sido asignado/a al departamento de: " +
                        departamentoElegido.getNombre());
            } else {
               System.out.println("Opción no válida.");
            }
                System.out.println("¿Desea introducir otro empleado? (si, no)");
                opcion = sc.next();

                if (opcion.equals("no")) {
                    MenuPrincipal.llamarMenuPrincipal();
                }
        } while (opcion.equals("si"));
    }

    // Método para ingresar los datos de un empleado
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

