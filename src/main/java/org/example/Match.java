package org.example;

import java.net.Socket;

public class Match {
    private ClientHandler player1;
    private ClientHandler player2;


    public Match(Socket clientHandler1, Socket clientHandler2) {
        this.player1 = new ClientHandler(clientHandler1);
        this.player2 = new ClientHandler(clientHandler2);
        player1.start();
        player2.start();
    }

}
