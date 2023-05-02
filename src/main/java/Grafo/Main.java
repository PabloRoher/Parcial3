package Grafo;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Puerto puertoMadero = new Puerto("Puerto Madero");
        Puerto puertoRodas = new Puerto("Puerto de Rodas");
        Puerto puertoSantos = new Puerto("Puerto Santos");
        Puerto puertoBuenosAires = new Puerto("Puerto Buenos Aires");
        Puerto puertoAgaete = new Puerto("Puerto de Agaete");

        grafo.agregarPuerto(puertoMadero);
        grafo.agregarPuerto(puertoRodas);
        grafo.agregarPuerto(puertoSantos);
        grafo.agregarPuerto(puertoBuenosAires);
        grafo.agregarPuerto(puertoAgaete);

        grafo.agregarArista(puertoMadero, puertoRodas, 10);
        grafo.agregarArista(puertoMadero, puertoSantos, 20);
        grafo.agregarArista(puertoRodas, puertoSantos, 30);
        grafo.agregarArista(puertoRodas, puertoBuenosAires, 40);
        grafo.agregarArista(puertoSantos, puertoBuenosAires, 50);
        grafo.agregarArista(puertoSantos, puertoAgaete, 60);

    }
}
