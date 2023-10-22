package code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import classes.DatosCompletos;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class generarXMLyJSONejercicio5 {

        public static void generar() {
            //creamos los objetos a escribiren el XML
                ArrayList<DatosCompletos> listaEmpleado = new ArrayList<DatosCompletos>();
                DatosCompletos e1 = new DatosCompletos("Juan Álvarez", 25000, "2001",
                        1,"Ventas", "Jaca" );
                listaEmpleado.add(e1);
                DatosCompletos e2 = new DatosCompletos("Sara Gracia", 28000, "2000",
                        2, "Producción", "Jaca");
                listaEmpleado.add(e2);
                DatosCompletos e3 = new DatosCompletos("Juan Álvarez", 35000, "1980",
                        3, "Informática", "Sabiñánigo");
                listaEmpleado.add(e3);

                //Archivo donde queremos guardar la info
                Path p = Path.of("src/main/java/archivos/guardarDatosXml.xml");
                Path pJ = Path.of("src/main/java/archivos/guardarDatosJson.json");
                //creamos el contexto de JAXBinding
                try {
                    JAXBContext contexto = JAXBContext.newInstance(DatosCompletos.class);
                    //para pasar de código a XML -- marshall
                    Marshaller marshaller  = contexto.createMarshaller();
                    //configuramos el formato de salida
                    marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
                    //escribimos el archivo:
                    if (libs.CheckArchivos.ficheroEscribible(p)) {
                        marshaller.marshal(listaEmpleado, p.toFile());
                    }
                    //con la API Gson creo mi json:
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    //creamos el parseador con formato bonito
                    Gson gson = gsonBuilder.setPrettyPrinting().create();
                    //creo el texto del json
                    String jsonDatos = gson.toJson(listaEmpleado);
                    try {
                        Files.writeString(pJ,jsonDatos);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } catch (JAXBException e) {
                    throw new RuntimeException(e);
                }
            }
        }
