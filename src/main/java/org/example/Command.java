package org.example;

public class Command {
    String command;
    int nHeart;
    int xOther;
    int yOther;

    public Command(String command, int xOther, int yOther) { //per le coordinate del player // o per il proiettile
        this.command = command;
        this.nHeart = nHeart;
        this.xOther = xOther;
        this.yOther = yOther;
    }

    public Command(String command) { // per l'exit
        this.command = command;
    }

    public Command(String command, int nHeart) { // per i cuori
        this.command = command;
        this.nHeart = nHeart;
    }
}
