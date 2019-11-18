import java.io.*;  
import java.net.*;
import java.security.*;

public class server {
    public static void main(String[] args) throws IOException {
  
        //Create the server socket and choose a port to listen on
		ServerSocket ss = new ServerSocket(6666); 
	    int BUFSIZE = 32;
        

        
		


        //Create the socket once a connection is established
        while (true){
            Socket clientSock = ss.accept();
         //Create the IO objects for reading and writing streams
         DataInputStream in  = new DataInputStream(clientSock.getInputStream());
         DataOutputStream out = new DataOutputStream(clientSock.getOutputStream());
            SocketAddress clientAddress = clientSock.getRemoteSocketAddress();
            System.out.println("Handling client at" + clientAddress);


        //Read the client value into the following String
        String clientString = in.readUTF();
        
        //Create a SHA-256 hash of the received String
        //DO NOT change this section of code
        //throw new NoSuchAlgorithmException();
        try{

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(clientString.getBytes());
        byte[] finalized = md.digest();
        String toSend = "";
        for(byte b:finalized)
            toSend += String.format("%02x", b);
        System.out.println("message= "+ clientString);
        

        //Send the resulting String toSend back to the client
       
        //out.write(toSend, 0, clientHash);
        out.writeUTF(toSend);
        //Close the server socket
		ss.close();  
          }
        catch (NoSuchAlgorithmException e){
            System.err.println("some error");
        }
    }
}
}
