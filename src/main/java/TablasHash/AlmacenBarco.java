package TablasHash;

public class AlmacenBarco {
    TablaHash tablaTipos;
    TablaHash tablaNumeros;
    TablaHash tablaNombres;

    AlmacenBarco() {
        tablaTipos = new TablaHash(10);
        tablaNumeros = new TablaHash(15);
        tablaNombres = new TablaHash(15);
    }
    void agregarBarco(Barco barco) {
        tablaTipos.insertarPorTipo(barco);
        tablaNumeros.insertarPorNumero(barco);
        tablaNombres.insertarPorNombre(barco);
    }
}
