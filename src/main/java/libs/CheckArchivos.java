package libs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CheckArchivos {

    //método que nos dice si existe, si NO es un directorio y si se puede leer, si NO lo creará
    public static boolean ficheroLegible(Path p) {
        boolean fichValido = false;
        if (Files.exists(p) && (!Files.isDirectory(p))) {
            if (Files.isReadable(p)) {
                fichValido = true;
            }
        } else {
            try {
                Files.createFile(p);
                fichValido = true;
            } catch (IOException e) {
                System.out.println("Error al intentar crear el fichero.");
            }
        }
        return fichValido;
    }

    //método que comprueba si existe y NO es un directorio y si se puede escribir y si no lo creará
    public static boolean ficheroEscribible(Path p) {
        boolean fichValido = false;
        if (Files.exists(p) && (!Files.isDirectory(p))) {
            if (Files.isWritable(p)){
                fichValido = true;
            }
        }
        else {
            try {
                Files.createFile(p);
                fichValido = true;
            } catch (IOException e) {
                System.out.println("Error al intentar crear el fichero.");
            }
        }
        return fichValido;
    }

    //método que nos dice si existe, si es un directorio y si se puede escribir, si NO lo creará
    public static boolean directorioEscribible(Path p) {
        boolean dirValido = false;
        if (Files.exists(p) && Files.isDirectory(p)) {
            if (Files.isWritable(p)) {
                dirValido = true;
            }
        } else {
            try {
                Files.createDirectory(p);
                dirValido = true;
            } catch (IOException e) {
                System.out.println("Error al intentar crear el directorio.");
            }
        }
        return dirValido;
    }

    //método que no dice si existe, si es un directorio y si se puede leer, si NO lo creará
    public static boolean directorioLegible(Path p) {
        boolean dirValido = false;
        if (Files.exists(p) && Files.isDirectory(p)) {
            if (Files.isReadable(p)) {
                dirValido = true;
            }
        } else {
            try {
                Files.createDirectory(p);
                dirValido = true;
            } catch (IOException e) {
                System.out.println("Error al intentar crear el directorio.");
            }
        }
        return dirValido;
    }
}


