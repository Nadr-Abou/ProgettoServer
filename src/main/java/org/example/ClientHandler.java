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


    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
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
            out.println("Ciao client");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        String s = "";
        Gson g = new Gson();

        while(true){
            try {
                if ((s = in.readLine()) == null) {
                    break;
                }
            }catch (IOException e){
                return false;
            }
            System.out.println(s);
        }
        return true;
    }

    @Override
    public void run() {
        manage();

        //ClientManager.getInstance().removeClient(this);
    }


}
