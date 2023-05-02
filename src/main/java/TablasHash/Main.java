package TablasHash;

public class Main {
    public static void main(String[] args) {
        AlmacenBarco almacenamiento = new AlmacenBarco();

        Barco barco1 = new Barco(1, "Titanic", TipoBarco.BATTLESHIP, 5);
        Barco barco2 = new Barco(2, "Poseidon", TipoBarco.FRAGATA, 4);
        Barco barco3 = new Barco(3, "Queen Mary", TipoBarco.CANOA, 5);

        almacenamiento.agregarBarco(barco1);
        almacenamiento.agregarBarco(barco2);
        almacenamiento.agregarBarco(barco3);
    }
}
