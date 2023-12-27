/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import java.net.DatagramSocket;
import javafx.scene.text.Text;

public class GenaraThread extends Thread {

    private DatagramSocket socket;
    private byte[] incoming = new byte[256];

    private TextArea textArea;

    public GenaraThread(DatagramSocket socket, TextArea textArea) {
        this.socket = socket;
        this.textArea = textArea;
    }

    @Override
    public void run() {
        System.out.println("starting thread");
        while (true) {
            DatagramPacket packet = new DatagramPacket(incoming, incoming.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String message = new String(packet.getData(), 0, packet.getLength()) + "\n";
            String current = textArea.getText();
            textArea.setText(current + message);
        }
    }
}

