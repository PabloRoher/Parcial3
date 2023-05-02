package TablasHash;

import java.util.ArrayList;

public class TablaHash {
    int tamano;
    ArrayList<ArrayList<Barco>> tabla;

    TablaHash(int tamano) {
        this.tamano = tamano;
        tabla = new ArrayList<>(tamano);
        for (int i = 0; i < tamano; i++) {
            tabla.add(new ArrayList<>());
        }
    }

    int funcionHash(String clave) {
        return Math.abs(clave.hashCode()) % tamano;
    }

    int funcionHash(int clave) {
        return Math.abs(clave) % tamano;
    }

    int funcionHash(TipoBarco tipo) {
        return tipo.ordinal() % tamano;
    }

    void insertarPorTipo(Barco barco) {
        int indice = funcionHash(barco.tipo);
        tabla.get(indice).add(barco);
    }

    void insertarPorNumero(Barco barco) {
        int indice = funcionHash(barco.numero);
        tabla.get(indice).add(barco);
    }

    void insertarPorNombre(Barco barco) {
        int indice = funcionHash(barco.nombre);
        tabla.get(indice).add(barco);
    }


}
