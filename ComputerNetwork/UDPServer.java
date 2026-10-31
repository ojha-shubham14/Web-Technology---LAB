import java.io.*;
import java.net.*;
class UDPServer{
    public static void main(String args[]) throws Exception{
        DatagramSocket ServerSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        
        while(true){
            System.out.println("waiting for client request");
            DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
            ServerSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            System.out.println("Received sentece : "+ sentence);
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String CapitalizedSentenece = sentence.toUpperCase();
            sendData = CapitalizedSentenece.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
            ServerSocket.send(sendPacket);
        }
    }
}