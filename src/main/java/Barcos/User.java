package Barcos;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private List<BarcoAbstracto> barcos = new ArrayList<>();
    private boolean alive;

    public User(List<BarcoAbstracto> ships) {
        try {
            if (ships == null) {
                throw new IllegalArgumentException("Lista de barcos no valida");
            } else if (ships.size() > 3) {
                throw new IllegalArgumentException("No puedes crear mas de 3 barcos");
            }
            this.barcos = ships;
            this.alive = true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean died() {
        return alive = false;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public List<BarcoAbstracto> getBarcos() {
        return barcos;
    }

    public void setBarcos(List<BarcoAbstracto> barcos) {
        this.barcos = barcos;
    }

    public void setBarco(BarcoAbstracto barco) {
        this.barcos.add(barco);
    }

    public boolean attack(Point shotPoint, User user) {
        for (BarcoAbstracto barco : user.getBarcos()) {
            if (!barco.isSunk() && barco.getShot(shotPoint)) {
                barco.addHit();
                if (barco.isSunk()) {
                    System.out.println("Tocado y hundido");
                } else {
                    System.out.println("Tocado");
                }
                return true;
            }
        }
        return false;
    }

    public boolean getShot(Point shotPoint) {
        for (BarcoAbstracto barco : barcos) {
            if (barco.getShot(shotPoint)) {
                if (barcos.stream().allMatch(BarcoAbstracto::isSunk)) {
                    died();
                }
                return true;
            }
        }
        System.out.println("Agua");
        return false;
    }

    @Override
    public String toString() {
        return "User{" +
                "ships=" + barcos +
                '}';
    }
}
