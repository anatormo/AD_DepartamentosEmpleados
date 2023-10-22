package code;

import classes.Departamento;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.nio.file.Path;
import java.util.ArrayList;

public class leerXMLejercicio2 {

    public static void leerConJAXB() {
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

            for (Departamento recorre : listaDep) {
                System.out.println("Número: " + recorre.getId());
                System.out.println("Nombre: " + recorre.getNombre());
                System.out.println("Localidad: " + recorre.getLocalidad() + "\n");
            }
        } catch (JAXBException e) {
            System.out.println("Error al leer el archivo XML: ");
        }
    }

}

