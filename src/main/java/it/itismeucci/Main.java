package it.itismeucci;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Il client è partito!");
        Socket s = new Socket("127.0.0.1", 3000);
        System.out.println("Il client si è collegato!");
    }
}