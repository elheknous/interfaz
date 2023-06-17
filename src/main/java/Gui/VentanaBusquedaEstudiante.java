package Gui;

import Modelo.Carrera;
import Modelo.Estudiante;
import Modelo.Universidad;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VentanaBusquedaEstudiante extends Ventana {

    private Universidad universidad;
    private JLabel estudiante, carrera,matricula;
    private JTextField campoNombre;
    private JComboBox carreras;
    private JButton botonBuscar, botonRegresar;

    public VentanaBusquedaEstudiante(Universidad universidad) {
        super("Busqueda estudiante", 500, 520);
        this.universidad = universidad;
        generarElementosVentana();

    }
    private void generarElementosVentana() {
        generarMensajeNombre();
        generarBotonBuscarEstudiante();
        generarBotonCancelar();
        generarLista();
    }

    private void generarLista() {
        String textoLista = "Carrera";
        super.generarJLabel(this.matricula, textoLista, 20, 200, 300, 100);
        this.carreras = super.generarListaDesplegable(universidad.getCarreras().toArray(new Carrera[0]), 200,240,150,20);
        this.add(this.carreras);
        this.carreras.addActionListener(this);
    }

    private void generarMensajeNombre() {
            String textoBienvenida = "Nombre: ";
            super.generarJLabel(this.estudiante, textoBienvenida, 20, 50, 100, 100);
            this.campoNombre= super.generarJTextField(200,90,150,20);
            this.add(this.campoNombre);

    }
    private void generarBotonBuscarEstudiante() {
        String textoBoton= "Buscar Estudiante";
        this.botonBuscar = super.generarBoton(textoBoton, 75, 400, 150, 20);
        this.add(this.botonBuscar);
        this.botonBuscar.addActionListener(this);
    }
    private void generarBotonCancelar() {
        String textoBotonRegresar = "Regresar";
        this.botonRegresar = super.generarBoton(textoBotonRegresar, 275, 400, 150, 20);
        this.add(this.botonRegresar);
        this.botonRegresar.addActionListener(this);
    }
    private String[][] registrarVehiculo(){
        ArrayList<Estudiante> estudiantes= new ArrayList<>();
        String[][] datosVehiculos;
        if(this.campoNombre.getText().length()==0){
            System.out.println(this.carreras.getSelectedItem());
            Carrera carre = (Carrera) this.carreras.getSelectedItem();
            estudiantes=  universidad.buscarEstudiantes(carre);
        }else{
            estudiantes= universidad.buscarNombre(this.campoNombre.getText());
        }

        System.out.println(estudiantes.size());
        datosVehiculos= new String[estudiantes.size()][3];
        for(int i=0; i<estudiantes.size(); i++){
            datosVehiculos[i][0]=estudiantes.get(i).getNombre();
            datosVehiculos[i][1]=estudiantes.get(i).getNumMatricula();
            datosVehiculos[i][2]=estudiantes.get(i).getCarrera();

        }
        return datosVehiculos;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.botonBuscar){
            String[] nombreColumnas={"Nombre","Matricula","Carrera"};
            VentanaTabla ventanaTabla= new VentanaTabla(registrarVehiculo(),nombreColumnas);
        }
        if (e.getSource() == this.botonRegresar){
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(universidad);
            this.dispose();
        }

    }



}
