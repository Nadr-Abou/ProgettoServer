package org.example;

public class Command {
    String command;
    int xOther;
    int yOther;

    public Command(String command, int xOther, int yOther) { //per le coordinate del player // o per il proiettile
        this.command = command;
        this.xOther = xOther;
        this.yOther = yOther;
    }

    public Command(String command) { // per l'exit
        this.command = command;
    }
}
