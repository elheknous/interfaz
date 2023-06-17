package Modelo;

import java.util.ArrayList;

public class Universidad {
    private ArrayList<Carrera> carreras;

    public Universidad() {
        this.carreras = new ArrayList<>();

    }
    public void agregarCarrera(String nombre,String codigo,String semestres){
        Carrera c = new Carrera(nombre,codigo,semestres);
        this.carreras.add(c);
    }

    public Universidad(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }



    @Override
    public String toString() {
        return "Universidad{" +
                "carreras=" + carreras +
                '}';
    }

    public ArrayList<Estudiante> buscarEstudiantes(Carrera selectedItem) {
        ArrayList<Estudiante> aux =new ArrayList<>();
        for (int i = 0; i < this.carreras.size(); i++) {
            for (int j = 0; j < this.carreras.get(i).getEstudiantes().size(); j++) {
                if (this.carreras.get(i).getEstudiantes().get(j).getCarrera().equals(selectedItem.getNombre())){
                    aux.add(this.carreras.get(i).getEstudiantes().get(j));
                }
            }

        }

        return aux;
    }

    public ArrayList<Estudiante> buscarNombre(String text){
    ArrayList<Estudiante> aux =new ArrayList<>();
        for (int i = 0; i < this.carreras.size(); i++) {
        for (int j = 0; j < this.carreras.get(i).getEstudiantes().size(); j++) {
            if (this.carreras.get(i).getEstudiantes().get(j).getNombre().equals(text)){
                aux.add(this.carreras.get(i).getEstudiantes().get(j));
            }
        }

    }

        return aux;
    }

}
