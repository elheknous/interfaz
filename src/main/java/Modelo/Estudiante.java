package Modelo;

public class Estudiante {
    private String nombre;
    private String rut;

    public String getCarrera() {
        return carrera;
    }

    private String numMatricula;
    private String carrera;

    public Estudiante(String nombre, String carrera, String rut, String numMatricula) {
        this.carrera = carrera;
        this.nombre = nombre;
        this.rut = rut;
        this.numMatricula = numMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCarrera(String carrera){
        this.carrera = carrera;
    }



    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(String numMatricula) {
        this.numMatricula = numMatricula;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", rut='" + rut + '\'' +
                ", numMatricula='" + numMatricula + '\'' +
                '}';
    }
}
