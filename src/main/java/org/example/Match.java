package org.example;

import java.net.Socket;

public class Match {
    //Il server distribuirà i giocatori sempre nello stesso modo in base all'ordine d'ingresso.
    //Il primo sarà sempre quello di sinistra mentre l'altro quello di destra.
    private ClientHandler player1; //left player
    private ClientHandler player2; //right player

    public Match(Socket clientHandler1, Socket clientHandler2) {
        int y = 686/2;
        this.player1 = new ClientHandler(clientHandler1, 0, y, 1220 - 100, y);
        this.player2 = new ClientHandler(clientHandler2, 1220 - 100, 500, 0, y);
        player1.start();
        player2.start();
    }

    public void bridgePlayers(Player p) {}

}
