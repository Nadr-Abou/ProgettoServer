package org.example;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class ClientHandler extends Thread{
    private Socket clientSocket;
    private Socket otherClientSocket;
    private PrintWriter out = null; // allocate to write answer to client.
    private PrintWriter outTOother = null; // allocate to write answer to client.
    private static Player thisPlayer = null;
    private static Player otherPlayer = null;
    Gson g = new Gson();
    public ClientHandler(Socket clientSocket, Socket otherClientSocket, double x, double y, double x2, double y2) {

        this.clientSocket = clientSocket;
        this.otherClientSocket = otherClientSocket;

        thisPlayer = new Player(3, x, y);
        otherPlayer = new Player(3, x2, y2);
        InetAddress inetAddress = this.clientSocket.getInetAddress();
        System.out.println("Connected from: " + inetAddress+", client socket: "+clientSocket.toString());
    }

    boolean manage(){
        BufferedReader in;
        try {
            in = new BufferedReader( new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            return false;
        }
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            outTOother = new PrintWriter(otherClientSocket.getOutputStream(), true);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        //Inizializzione della partita
        out.println(g.toJson(thisPlayer));
        out.println(g.toJson(otherPlayer));


        while (true) {
            String s;
            try {
                if ((s = in.readLine()) != null) {
                    if (s.equals("exit")) {
                        break;
                    }
                    System.out.println(s);
                    thisPlayer = g.fromJson(s, Player.class);
                    outTOother.println(g.toJson(thisPlayer));
                    System.out.println(thisPlayer);
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
        return true;
    }

    @Override
    public void run() {
        manage();
    }

}
