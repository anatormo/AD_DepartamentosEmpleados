package libs;

//Autor: Ana Tormo

public class MenuPrincipal {
    public static void llamarMenuPrincipal() {
        boolean salir = false;
        int opcion;
        do {
            System.out.println("Escoge la opción que necesitas:");
            System.out.println("0.Salir");
            System.out.println("1.Introducir datos de empleados: ");
            System.out.println("2.Lee el fichero XML: ");
            System.out.println("3.Escoger el departamento: ");
            System.out.println("4.Cargar datos del archivo Json: ");
            System.out.println("5.Generar archivos Xml y Json: ");

            opcion = libs.Validaciones.enteros();
            switch (opcion) {
                case 0 -> {salir = true;}
                case 1 -> {code.introducirEmpleadosEjercicio1.introducirGuardar();}
                case 2 -> {code.leerXMLejercicio2.leerConJAXB();}
                case 3 -> {code.asignarDepartamentoEjercicio3.asignar();}
                case 4 -> {code.cargarEmpleadosDeunJsonEjercicio4.leer();}
                case 5 -> {code.generarXMLyJSONejercicio5.generar();}
            }
        } while (!salir);
    }
}

