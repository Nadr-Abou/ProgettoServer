package org.example;

public class Player {
    private int nHeart = 3;
    private int x;
    private int y;

    public Player(int nHeart, double x, double y) {
        this.nHeart = nHeart;
        this.x = (int) x;
        this.y = (int) y;
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
        this.x = (int) x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = (int) y;
    }
}