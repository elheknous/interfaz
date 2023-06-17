package Principal;

import Gui.VentanaTabla;

public class tabla {
    public static void main(String[] args) {
        String[] columnas = {"nombre","apellido","edad"};
        String[][] datos = {
                {"jose","matus","15"},
                {"Juna","sex0","45"},
                {"saco","wea","900"}

        };
        VentanaTabla v = new VentanaTabla(datos,columnas);
    }
}
