package Barcos;

import java.awt.*;

public class BattleshipFactory implements BarcosFactory{
    @Override
    public Barco crearBarco(Point start, Point end, CardinalPoints cardinalPoints) {
        return new Battleship(start, end, cardinalPoints);
    }

}
