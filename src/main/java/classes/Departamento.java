package classes;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;


@XmlRootElement(name = "departamentos")
public class Departamento {
    private int idDep;
    private int id;
    private String nombre;
    private String localidad;
    private ArrayList<Departamento> departamentoList;

    public Departamento(){}


    public Departamento(int idDep, String nombre, String localidad) {
        this.idDep = idDep;
        this.nombre = nombre;
        this.localidad = localidad;
    }



    @XmlElement(name = "departamento")
    public ArrayList<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(ArrayList<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    @XmlAttribute
    public int getIdDep() {
        return idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    @XmlAttribute
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}



