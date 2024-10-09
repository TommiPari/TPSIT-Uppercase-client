package it.itismeucci;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Il client è partito!");
        Socket s = new Socket("127.0.0.1", 3000);
        System.out.println("Il client si è collegato!");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String stringaInviata;
        String stringaRicevuta;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Inserire una stringa (0 per terminare la connessione):");
            stringaInviata = scanner.nextLine();
            out.writeBytes(stringaInviata + "\n");
            if (stringaInviata.equals("0")) {
                System.out.println("Comunicazione terminata!");
            } else {
                stringaRicevuta = in.readLine();
                System.out.println("Stringa ricevuta: " + stringaRicevuta + "\n");
            }
        } while (!stringaInviata.equals("0"));

        s.close();
    }
}