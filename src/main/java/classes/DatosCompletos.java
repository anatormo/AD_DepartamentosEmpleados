package classes;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "datosCompletos")
@XmlType(propOrder = {"nombre", "sueldo", "año", "idDep", "nombreDep", "localidadDep"})
    public class DatosCompletos {
        private String nombre;
        private double sueldo;
        private String año;
        private int idDep;
        private String nombreDep;
        private String localidadDep;

        public DatosCompletos() {
        }

        public DatosCompletos(String nombre, double sueldo, String año, int idDep, String nombreDep, String localidadDep) {
            this.nombre = nombre;
            this.sueldo = sueldo;
            this.año = año;
            this.idDep = idDep;
            this.nombreDep = nombreDep;
            this.localidadDep = localidadDep;
        }

        @XmlElement
        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        @XmlElement
        public double getSueldo() {
            return sueldo;
        }

        public void setSueldo(double sueldo) {
            this.sueldo = sueldo;
        }

        @XmlElement
        public String getAño() {
            return año;
        }

        public void setAño(String año) {
            this.año = año;
        }

        @XmlElement
        public int getIdDep() {
            return idDep;
        }

        public void setIdDep(int idDep) {
            this.idDep = idDep;
        }

        @XmlElement
        public String getNombreDep() {
            return nombreDep;
        }

        public void setNombreDep(String nombreDep) {
            this.nombreDep = nombreDep;
        }

        @XmlElement
        public String getLocalidadDep() {
            return localidadDep;
        }

        public void setLocalidadDep(String localidadDep) {
            this.localidadDep = localidadDep;
        }
    }