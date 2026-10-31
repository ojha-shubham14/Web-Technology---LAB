import java.io.*;
import java.net.*;

class UDPClient {  //was not able to execute
    public static void main(String args[]) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        String sentence = "hello world";
        byte[] sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(
            sendData,
            sendData.length,
            IPAddress,
            9876
        );
        clientSocket.send(sendPacket);
        byte[] receiveData = new byte[1024];

        DatagramPacket receivePacket =
            new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(
            receivePacket.getData(),
            0,
            receivePacket.getLength()
        );

        System.out.println("FROM SERVER: " + modifiedSentence);
        clientSocket.close();
    }
}