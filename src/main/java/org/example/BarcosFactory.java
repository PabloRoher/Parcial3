package org.example;

import java.awt.*;

public interface BarcosFactory {
    Barco crearBarco(Point start, Point end, CardinalPoints cardinalPoints);
}
