package org.example;

public class Player {
    private int nHeart = 3;
    private double x;
    private double y;

    public Player(int nHeart, double x, double y) {
        this.nHeart = nHeart;
        this.x = x;
        this.y = y;
    }

    public int getnHeart() {
        return nHeart;
    }

    public void setnHeart(int nHeart) {
        this.nHeart = nHeart;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
