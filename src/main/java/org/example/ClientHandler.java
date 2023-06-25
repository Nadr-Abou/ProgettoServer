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
    private PrintWriter out = null; // allocate to write answer to client.
    private Player thisPlayer = null;
    private Player otherPlayer = null;
    public ClientHandler(Socket clientSocket, double x, double y, double x2, double y2) {
        this.clientSocket = clientSocket;
        thisPlayer = new Player(3, x, y);
        otherPlayer = new Player(3, x2, y2);
        InetAddress inetAddress = this.clientSocket.getInetAddress();
        System.out.println("Connected from: " + inetAddress);
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
            //out.println("Ciao client");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        while (true) {
            //String s = "This: {x: " + thisPlayer.getX() + " y: " + thisPlayer.getY()+"} other: {"+"x: "+otherPlayer.getX()+" y: "+otherPlayer.getY()+"}"; //Eventuale stringa che verrà usata per allocare il JSON.
            Gson g = new Gson();
            //System.out.println(g.toJson(s));
            //out.println(g.toJson(s));
            //out.println("This player JSON: "+g.toJson(thisPlayer));
            //out.println("Other player JSON: "+g.toJson(otherPlayer));
            out.println(g.toJson(thisPlayer));
            out.println(g.toJson(otherPlayer));

            //Codice per la sperimentazione con telnet per far si che ciò non finisca in loop.
            String s;
            try {
                if ((s = in.readLine()) != null) {
                    if (s.equals("exit")) {
                        break;
                    }
                    out.println(s.toUpperCase());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public void run() {
        manage();
    }

}
