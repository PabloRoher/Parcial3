package Grafo;

public class Arista {
    Puerto origen;
    Puerto destino;
    int distancia;

    public Arista(Puerto origen, Puerto destino, int distancia) {
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
    }

}
