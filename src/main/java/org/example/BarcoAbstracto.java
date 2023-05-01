package org.example;

import java.awt.*;

public abstract class BarcoAbstracto implements Barco{
    protected Point start;
    protected Point end;
    protected int hits;
    private CardinalPoints cardinalPoints;

    public BarcoAbstracto(Point start, Point end, CardinalPoints cardinalPoints) {
        this.start = start;
        this.end = end;
        this.hits = 0;
        this.cardinalPoints = cardinalPoints;
    }

    protected boolean calcularDistancia(Point start, Point end, int size) {
        if (start.x == end.x && start.y <= end.y) {
            if ((end.y - start.y) + 1 > size || (end.y - start.y) + 1 < size) {
                throw new IllegalArgumentException("El tamaño del barco no coincide con la distancia entre los puntos");
            }else {
                return true;
            }
        } else if (start.y == end.y && start.x <= end.x) {
            if ((end.x - start.x) + 1 > size || (end.x - start.x) + 1 < size) {
                throw new IllegalArgumentException("El tamaño del barco no coincide con la distancia entre los puntos");
            }else {
                return true;
            }
        }else {
                return false;
        }
    }

    @Override
    public boolean getShot(Point shotPoint) {
        int startX = start.x;
        int startY = start.y;
        int endX = end.x;
        int endY = end.y;

        if (shotPoint.x == startX && shotPoint.x == endX && shotPoint.y >= startY && shotPoint.y <= endY) {
            return true;
        } else if (shotPoint.y == startY && shotPoint.y == endY && shotPoint.x >= startX && shotPoint.x <= endX) {
            return true;
        }
        return false;
    }
    @Override
    public abstract boolean isSunk();
    @Override
    public abstract void addHit();


}
