package classes;

import java.util.ArrayList;

public class Empleado {
    private String nombre;
    private double sueldo;
    private String nacimiento;
    private String año;
    private ArrayList<Departamento> departamentos;

    public Empleado() {
    }

    public Empleado(String nombre, double sueldo, String nacimiento, String antiguedad) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.nacimiento = nacimiento;
        this.año = antiguedad;

    }

    public Empleado(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(ArrayList<Departamento> departamentos) {
        this.departamentos = departamentos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
}