package it.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Il client è partito!");
        Socket s = new Socket("127.0.0.1", 3000);
        System.out.println("Il client si è collegato!");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        out.writeBytes("Ciao sono il client!\n");

        String stringaRicevuta = in.readLine();
        System.out.println("Stringa ricevuta: " + stringaRicevuta);

        s.close();
    }
}