package Modelo;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.SplittableRandom;

public class Carrera {
    private ArrayList<Estudiante> estudiantes;
    private String nombre;

    private String codigo;
    private String semestres;

    public Carrera(String nombre, String codigo, String semestres) {
        this.estudiantes = new ArrayList<>();
        this.nombre = nombre;
        this.codigo = codigo;
        this.semestres = semestres;
    }


    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSemestres() {
        return semestres;
    }

    public void setSemestres(String semestres) {
        this.semestres = semestres;
    }

    public void agregarEstudiante(String nombre, String carrera,String rut, String matricula){
        Estudiante e = new Estudiante(nombre,carrera,rut,matricula);
        this.estudiantes.add(e);

    }

    public ArrayList<Estudiante> buscarEstudiantesPorCarrera() {
        return this.estudiantes;
    }
    public void getData(){
        System.out.println("Nombre carrera: "+getNombre());
        System.out.println("Codigo carrera: "+getCodigo());
        System.out.println("Cantidad semestres: "+getSemestres());
        System.out.println("Estudiantes: ");
        for (int i = 0; i < this.estudiantes.size(); i++) {
            System.out.println(this.estudiantes.get(i).toString());

        }
    }
    @Override
    public String toString() {
        return nombre;
    }
}
