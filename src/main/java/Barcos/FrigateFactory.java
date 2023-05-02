package Barcos;

import java.awt.*;

public class FrigateFactory implements BarcosFactory{
    @Override
    public Barco crearBarco(Point start, Point end, CardinalPoints cardinalPoints) {
        return new Frigate(start, end, cardinalPoints);
    }
}
