package Gui;

import Modelo.Carrera;
import Modelo.Universidad;

import javax.swing.*;
import javax.swing.text.InternationalFormatter;
import java.awt.event.ActionEvent;

public class VentanaRegistrarCarrera extends Ventana{

    private JLabel textoNombreCarrera, codigoCarrera, cantidadSemestre;
    private JTextField campoNombreCarrera, campoCodigoCarrera, campoCantidadSemestre;
    private JButton botonRegistrar, botonCancelar;
    private JLabel textoMenu;
    private Universidad universidad;

    public VentanaRegistrarCarrera(Universidad universidad) {
        super("Registro carrera", 500, 520);
        this.universidad = universidad;
        generarElementosVentana();

    }
    private void generarElementosVentana() {
        generarMensaje();
        generarMensajeCarrera();
        generarCodigoCarrera();
        generaSemestre();
        generarBotonRegistrar();
        generarBotonCancelar();
    }

    private void generarBotonCancelar() {
        String textoBotonCancelar = "Cancelar";
        this.botonCancelar = super.generarBoton(textoBotonCancelar, 275, 300, 150, 100);
        this.add(this.botonCancelar);
        this.botonCancelar.addActionListener(this);
    }

    private void generarBotonRegistrar() {
        String textoBoton= "Registrar";
        this.botonRegistrar = super.generarBoton(textoBoton, 75, 300, 150, 100);
        this.add(this.botonRegistrar);
        this.botonRegistrar.addActionListener(this);
    }


    private void generaSemestre() {
        String textoBienvenida = "Cantidad semestres: ";
        super.generarJLabel(this.textoNombreCarrera, textoBienvenida, 20, 150, 300, 100);
        this.campoCantidadSemestre= super.generarJTextField(200,190,150,20);
        this.add(this.campoCantidadSemestre);
    }

    private void generarCodigoCarrera() {
        String textoBienvenida = "Codigo carrera: ";
        super.generarJLabel(this.codigoCarrera, textoBienvenida, 20, 100, 100, 100);
        this.campoCodigoCarrera= super.generarJTextField(200,140,150,20);
        this.add(this.campoCodigoCarrera);
    }

    private void generarMensajeCarrera() {
        String textoBienvenida = "Nombre carrera: ";
        super.generarJLabel(this.textoNombreCarrera, textoBienvenida, 20, 50, 100, 100);
        this.campoNombreCarrera= super.generarJTextField(200,90,150,20);
        this.add(this.campoNombreCarrera);


    }

    private void generarMensaje() {
        String textoBienvenida = "Registro de Carrera universitaria";
        super.generarJLabelEncabezado(this.textoMenu, textoBienvenida, 20, 30, 500, 30);
    }



    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonRegistrar) {
            JOptionPane.showMessageDialog(this,"Carrera registrada correctamente");
            universidad.agregarCarrera(this.campoNombreCarrera.getText(),this.campoCodigoCarrera.getText(),this.campoCantidadSemestre.getText());
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(universidad);
            this.dispose();



        }
        if (e.getSource() == this.botonCancelar){
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(universidad);
            this.dispose();
        }

    }


}
