package code;

import classes.Departamento;
import classes.Empleado;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;

public class cargarEmpleadosDeunJsonEjercicio4 {
    public static void leer() {
        Path p = Path.of("src/main/java/archivos/nuevosEmpleados.json");
        //variable para almacenar el contenido del fichero
        List<Empleado> empleadoJson;
        List<Departamento> departamentoJson;
        //leemos el contenido del Json, que es un texto
        String txtJson;
        String Json;
        //leermos el contenido del archivo de texto
        try {
            txtJson = Files.readString(p);
            Json = Files.readString(p);
            //creo el Gson que transforma de texto a objeto
            Gson gson = new Gson();
            empleadoJson = gson.fromJson(txtJson, new TypeToken<List<Empleado>>() {}.getType());
            departamentoJson = gson.fromJson(Json, new TypeToken<List<Departamento>>() {}.getType());
            //para que el dato de la antigüedad guarde la fecha actual
            Date fechaActual = new Date();
            for (Empleado recorre: empleadoJson){
                recorre.setAño((String.valueOf(fechaActual)));
            }
            //manera para que imprima la información de las dos listas
            for (int i = 0; i < empleadoJson.size(); i++) {
                Empleado empleado = empleadoJson.get(i);
                Departamento dep = departamentoJson.get(i);

                System.out.println("nombre: " + empleado.getNombre() + ",");
                System.out.println("sueldo: " + empleado.getSueldo() + ",");
                System.out.println("año: " + empleado.getAño() + ",");
                System.out.println("idDep: " + dep.getIdDep() + "\n");
            }
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }
    }
}


