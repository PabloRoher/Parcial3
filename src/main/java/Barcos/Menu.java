package Barcos;

import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);
    public void jugar() {
        int x = getIntInputWithPrompt("Introduzca el tamaño del tablero en el eje x");
        int y = getIntInputWithPrompt("Introduzca el tamaño del tablero en el eje y");
        Tablero tablero = new Tablero(x, y);
        User user1 = createUser(1, tablero);
        User user2 = createUser(2, tablero);

        while (user1.isAlive() && user2.isAlive()) {
            playTurn(user1, user2);
            if (user1.isAlive() && user2.isAlive()) {
                playTurnCPU(user2, user1, tablero);
            }
        }

        if (user1.isAlive()) {
            System.out.println("El jugador 1 ha ganado");
        } else if (user2.isAlive()) {
            System.out.println("El jugador 2 ha ganado");
        } else {
            System.out.println("Los dos jugadores han perdido");
        }
    }

    private int getIntInput() {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Introduzca un número");
            }
        }
    }
    private int getIntInputWithPrompt(String prompt) {
        System.out.println(prompt);
        return getIntInput();
    }

    private User createUser(int playerNumber, Tablero tablero) {
        User user = new User(new ArrayList<>());
        System.out.println("Cree los barcos del jugador " + playerNumber);
        int numBarcos = getNumBarcos();

        for (int i = 0; i < numBarcos; i++) {
            BarcoAbstracto barco = createBarco(tablero);
            user.setBarco(barco);
        }
        return user;
    }

    private void playTurn(User attacker, User defender) {
        System.out.println("Turno del jugador 1");
        Point attackPoint = getPoint("Introduzca la coordenada del punto donde quiere atacar");
        attacker.attack(attackPoint, defender);
        defender.getShot(attackPoint);
    }

    private void playTurnCPU(User attacker, User defender, Tablero tablero) {
        Random random = new Random();
        System.out.println("Turno del jugador 2");
        Point shotPoint = new Point(random.nextInt(tablero.getFilas() + 1), random.nextInt(tablero.getColumnas() + 1));
        attacker.attack(shotPoint, defender);
        defender.getShot(shotPoint);
    }

    private BarcoAbstracto createBarco(Tablero tablero) {

        try {
            int tipo = getIntInputWithPrompt("Introduzca el tipo de barco de que desea crear\n1. Canoa\n2. Fragata\n3. Battleship");
            switch (tipo) {
                case 1:
                    ArrayList<Point> coordenadasBarco = getCoordenadasBarco(tablero);
                    CardinalPoints cardinalPoint = getCardinalPoint();
                    return new Canoe(coordenadasBarco.get(0),coordenadasBarco.get(1), cardinalPoint);
                case 2:
                    coordenadasBarco = getCoordenadasBarco(tablero);
                    cardinalPoint = getCardinalPoint();
                    return new Frigate(coordenadasBarco.get(0),coordenadasBarco.get(1), cardinalPoint);
                case 3:
                    coordenadasBarco = getCoordenadasBarco(tablero);
                    cardinalPoint = getCardinalPoint();
                    return new Battleship(coordenadasBarco.get(0),coordenadasBarco.get(1), cardinalPoint);
                default:
                    throw new IllegalStateException("tipo de barco no valido");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return createBarco(tablero);
        }
    }

    public ArrayList getCoordenadasBarco(Tablero tablero){
        ArrayList<Point> coordenadasBarco = new ArrayList<>();
        Point start = getPoint("Introduzca la coordenada del punto de inicio");
        Point end = getPoint("Introduzca la coordenada del punto de fin");
        if (tablero.estaDentroDelTablero(start.x, start.y) && tablero.estaDentroDelTablero(end.x, end.y)){
            coordenadasBarco.add(start);
            coordenadasBarco.add(end);
            return coordenadasBarco;
        }
        else{
            System.out.println("Coordenadas fuera del tablero, introduzca unas nuevas");
            return getCoordenadasBarco(tablero);
        }
    }

    private Point getPoint(String prompt) {
        System.out.println(prompt);
        int x = getIntInputWithPrompt("Introduzca la coordenada x");
        int y = getIntInputWithPrompt("Introduzca la coordenada y");
        return new Point(x, y);
    }

    private int getNumBarcos() {
        while (true) {
            int numBarcos = getIntInputWithPrompt("¿Cuántos barcos desea crear?");
            if (numBarcos > 0 && numBarcos <= 3) {
                return numBarcos;
            }
            System.out.println("El número de barcos no puede ser superior a 3 o inferior a 1");
        }
    }

    private CardinalPoints getCardinalPoint() {
        while (true) {
            int direction = getIntInputWithPrompt("Introduzca el número que representa la orientación del barco\n1. NORTH\n2. SOUTH\n3. EAST\n4. WEST");
            switch (direction) {
                case 1:
                    return CardinalPoints.NORTH;
                case 2:
                    return CardinalPoints.SOUTH;
                case 3:
                    return CardinalPoints.EAST;
                case 4:
                    return CardinalPoints.WEST;
                default:
                    System.out.println("Orientación no válida");
            }
        }
    }
}

