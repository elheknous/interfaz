package Gui;

import Modelo.Carrera;
import Modelo.Universidad;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaRegistroEstudiante extends Ventana{
    private JLabel titulo, nombre, rut, matricula,carrerasss;
    private JTextField campoNombre, campoRut, campoMatricula;
    private JButton registrar, cancelar;

    private JComboBox carreras;

    private Universidad universidad;

    public VentanaRegistroEstudiante(Universidad universidad) {
        super("Registro estudiante", 500, 520);
        this.universidad = universidad;
        generarElementosVentana();

    }

    private void generarElementosVentana() {
        generarTitulo();
        generarMensajeNombre();
        generarRut();
        generaMatricula();
        generarBotonRegistrar();
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

    private void generarBotonCancelar() {
        String textoBotonCancelar = "Cancelar";
        this.cancelar = super.generarBoton(textoBotonCancelar, 275, 300, 150, 100);
        this.add(this.cancelar);
        this.cancelar.addActionListener(this);
    }

    private void generarBotonRegistrar() {
        String textoBoton= "Registrar";
        this.registrar = super.generarBoton(textoBoton, 75, 300, 150, 100);
        this.add(this.registrar);
        this.registrar.addActionListener(this);
    }

    private void generaMatricula() {
        String textoBienvenida = "Matricula: ";
        super.generarJLabel(this.matricula, textoBienvenida, 20, 150, 300, 100);
        this.campoMatricula= super.generarJTextField(200,190,150,20);
        this.add(this.campoMatricula);
    }

    private void generarRut() {
        String textoBienvenida = "Rut: ";
        super.generarJLabel(this.rut, textoBienvenida, 20, 100, 100, 100);
        this.campoRut= super.generarJTextField(200,140,150,20);
        this.add(this.campoRut);
    }

    private void generarMensajeNombre() {
        String textoBienvenida = "Nombre: ";
        super.generarJLabel(this.nombre, textoBienvenida, 20, 50, 100, 100);
        this.campoNombre= super.generarJTextField(200,90,150,20);
        this.add(this.campoNombre);
    }

    private void generarTitulo() {
        String textoBienvenida = "Registro Estudiante";
        super.generarJLabelEncabezado(this.titulo, textoBienvenida, 20, 30, 500, 30);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.registrar) {
            JOptionPane.showMessageDialog(this,"Estudiante registrado correctamente");
            int indeceCarrera = encontrarCarrera();
            universidad.getCarreras().get(indeceCarrera).agregarEstudiante(this.campoNombre.getText(),this.carreras.getSelectedItem().toString(),campoRut.getText(),this.campoMatricula.getText());
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(universidad);
            this.dispose();



        }
        if (e.getSource() == this.cancelar){
            VentanaMenuBienvenida ventanaMenuBienvenida = new VentanaMenuBienvenida(universidad);
            this.dispose();
        }

    }

    private int encontrarCarrera() {
        String carreraSeleccionada = this.carreras.getSelectedItem().toString();
        System.out.println(carreraSeleccionada);
        for (int i = 0; i < universidad.getCarreras().size(); i++) {
            if (universidad.getCarreras().get(i).getNombre().equals(carreraSeleccionada)){
                return i;
            }

        }
        return -1;
    }
}




