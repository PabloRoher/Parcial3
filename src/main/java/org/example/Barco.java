package org.example;

import java.awt.*;

public interface Barco {
    public boolean getShot(Point shotPoint);
    public boolean isSunk();
    public void addHit();
}
