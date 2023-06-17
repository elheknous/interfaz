package Gui;

import Modelo.Carrera;
import Modelo.Universidad;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaMenuBienvenida extends Ventana {

    private JLabel textoMenu;
    private JButton botonRegistrarCarrera;
    private JButton botonSalida;
    private JButton botonRegistrarEstudiante;
    private JButton botonBuscarEstudiante;

    private Universidad universidad;


    public VentanaMenuBienvenida(Universidad universidad) {
        super("Intranet 2.0", 500, 520);
        this.universidad = universidad;
        generarElementosVentana();
    }

    private void generarElementosVentana() {
        generarMensajeMenu();
        generarBotonRegistrarCarrera();
        generarBotonRegistrarEstudiante();
        generarBotonBuscarEstudiante();
        // generarBotonVenderVehiculo();
        generarBotonSalir();
    }

    private void generarMensajeMenu() {
        String textoBienvenida = "Intranet 2.0";
        super.generarJLabelEncabezado(this.textoMenu, textoBienvenida, 20, 30, 500, 30);
    }

    private void generarBotonRegistrarCarrera() {
        String textoBoton = "Registrar Carrera";
        this.botonRegistrarCarrera = super.generarBoton(textoBoton, 175, 100, 150, 40);
        this.add(this.botonRegistrarCarrera);
        this.botonRegistrarCarrera.addActionListener(this);
    }
    private void generarBotonSalir() {
        String textoBoton = "Salir";
        this.botonSalida = super.generarBoton(textoBoton, 175, 420, 150, 40);
        this.add(this.botonSalida);
        this.botonSalida.addActionListener(this);
    }
    private void generarBotonRegistrarEstudiante() {
        String textoBoton = "Registrar Estudiante";
        this.botonRegistrarEstudiante = super.generarBoton(textoBoton, 175, 180, 150, 40);
        this.add(this.botonRegistrarEstudiante);
        this.botonRegistrarEstudiante.addActionListener(this);
    }
    private void generarBotonBuscarEstudiante(){
        String textoBoton = "Buscar Estudiante";
        this.botonBuscarEstudiante=super.generarBoton(textoBoton, 175, 260, 150, 40);
        this.add(this.botonBuscarEstudiante);
        this.botonBuscarEstudiante.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrarCarrera) {
            VentanaRegistrarCarrera ventanaRegistrarCliente= new VentanaRegistrarCarrera(universidad);
            //Cierra la ventana actual
            this.dispose();
        }
        if(e.getSource() == this.botonRegistrarEstudiante){
            VentanaRegistroEstudiante ventanaRegistroVehiculo= new VentanaRegistroEstudiante(universidad);
            this.dispose();
        }
        if(e.getSource() == this.botonBuscarEstudiante){
            VentanaBusquedaEstudiante ventanaBusquedaVehiculo= new VentanaBusquedaEstudiante(universidad);
            this.dispose();
        }



    }


}