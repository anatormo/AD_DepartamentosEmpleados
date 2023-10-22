package libs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Validaciones {

    public static int enteros() {
        //este objeto se utiliza para leer la entrada del usuario
        BufferedReader datoIntroducido = (new BufferedReader(new InputStreamReader(System.in)));
        //variable que almacenará el dato que introduce el usuario
        int dato = 0;
        //variable para controlar el bucle while y asegurarse que el usuario introduce el dato correcto
        boolean error = true;
        //se va a jecutar mientras error sea true
        while (error) {
            try {
                System.out.println("Introduce el dato solicitado: ");
                //como leer la línea introducida por el usuario
                dato = Integer.parseInt(datoIntroducido.readLine());
                //si el dato es valido se almacena en la variable dato, la var error pasa a false y se detiene el bucle
                error = false;
            //excepcion para numeros enteros
            } catch (NumberFormatException e) {
                System.out.println("El dato no es correcto, " + "\n" + "se solicita un número entero del Menú");
                error = true;
            //esta excepción maneja errores de entrada/salida, es necesaria para utilizar el readLine
            } catch(IOException e){
                error = true;
            }
        }
        //cuando se detiene el bucle nos devuelve el valor almacenado en la var dato
        return dato;
    }

    public static String strings() {
        System.out.println("Introduzca la ruta del archivo a leer: ");
        //este objeto se utiliza para leer la entrada del usuario
        BufferedReader datoIntroducido = (new BufferedReader(new InputStreamReader(System.in)));
        //variable que almacenará el dato que introduce el usuario
        String dato = "";
        //variable para controlar el bucle while y asegurarse que el usuario introduce el dato correcto
        boolean error = true;

        //se va a jecutar mientras error sea true
        while (error) {
            try {
                //como leer la línea introducida por el usuario
                dato = datoIntroducido.readLine();
                //si el dato es valido se almacena en la variable dato, la var error pasa a false y se detiene el bucle
                error = false;
                //esta excepción maneja errores de entrada/salida, es necesaria para utilizar el readLine
            } catch(IOException e){
                System.out.println("El dato no es correcto, vuelve a introducirlo.");
                error = true;
            }
        }
        //cuando se detiene el bucle nos devuelve el valor almacenado en la var dato
        return dato;
    }
}
