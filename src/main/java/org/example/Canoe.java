package org.example;

import java.awt.*;

public class Canoe extends BarcoAbstracto{
    int size;

    CardinalPoints cardinalPoints;
    public Canoe(Point start, Point end, CardinalPoints cardinalPoints) {
        super(start, end, cardinalPoints);
        this.size = 1;
        boolean distance = calcularDistancia(start, end,size);
        if (!distance) {
            throw new IllegalArgumentException("La distancia entre los puntos debe coincidir con el tamaño de la canoa");
        }
    }

    @Override
    public boolean isSunk() {
        return this.hits >= this.size;
    }

    @Override
    public void addHit() {
        hits++;
    }
}
