package Barcos;

import java.awt.*;

public class CanoeFactory implements BarcosFactory{
    @Override
    public Barco crearBarco(Point start, Point end, CardinalPoints cardinalPoints) {
        return new Canoe(start, end, cardinalPoints);
    }
}
