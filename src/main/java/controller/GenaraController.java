/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import Model.Genara;
import Model.GenaraThread;
import Model.TypeUser;
import Utilities.GenaraDAO;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import main.App;

/**
 * FXML Controller class
 *
 * @author lenovo
 */
public class GenaraController implements Initializable {
    
    private static final DatagramSocket socket;

    static {
        try {
            socket = new DatagramSocket(); // init to any available port
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    private static final InetAddress address;
    private static GenaraDAO dao = new GenaraDAO();


    static {
        try {
            address = InetAddress.getByName("localhost");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    private static String identifier;

    private static final int SERVER_PORT = 8000;

    @FXML
    private TextField inputChat;
    @FXML
    private TextArea hasilChat;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hasilChat.setText("");
        for (Genara chat: dao.getAll()) {
            hasilChat.setText(hasilChat.getText() + chat.getPengirim() + " : " + chat.getPesan() + "\n");
        }
        if (App.member != null) {
            identifier = App.member.getNama();
        }
        if (App.admin != null){
            identifier = App.admin.getNama();
        }
        var clientThread = new GenaraThread(socket, hasilChat);
        clientThread.start();

        // send initialization message to the server
        byte[] uuid = ("init;" + identifier).getBytes();
        DatagramPacket initialize = new DatagramPacket(uuid, uuid.length, address, SERVER_PORT);
        try {
            socket.send(initialize);
            // TODO
        } catch (IOException ex) {
            Logger.getLogger(GenaraController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void education(MouseEvent event) throws IOException {
        App.setRoot("educationPages");
    }

    @FXML
    private void genara(MouseEvent event) throws IOException {
        App.setRoot("genara");
    }

    @FXML
    private void lapor(MouseEvent event) throws IOException {
        if (App.typeUser == TypeUser.Admin){
            App.setRoot("laporanAdmin");
        }else {
            App.setRoot("laporanPages");
        }
    }

    @FXML
    private void home(MouseEvent event) throws IOException {
        App.setRoot("home");
    }

    @FXML
    private void send(MouseEvent event) throws IOException {
        String temp = identifier + " : " + inputChat.getText(); // message to send
        hasilChat.setText(hasilChat.getText() + inputChat.getText() + "\n"); // update messages on screen
        byte[] msg = temp.getBytes(); // convert to bytes

        // create a packet & send
        DatagramPacket send = new DatagramPacket(msg, msg.length, address, SERVER_PORT);
        socket.send(send);
        if (App.typeUser == TypeUser.Member){
            dao.addChat(App.member.getUsername(), inputChat.getText());
        } else if (App.typeUser == TypeUser.Admin){
            dao.addChat(App.admin.getUsername(), inputChat.getText());
        }
        inputChat.setText(""); // remove text from input box

    }
    
}
