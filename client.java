import java.io.*;  
import java.net.*;  
public class client {
    public static void main(String[] args) throws IOException {

        
        //Create the client socket
        int servPort = 6666;
        Socket socket = new Socket("matrix.csc.villanova.edu", servPort);
        System.out.println("connecting to server...sending string");

        //Create stream processing IO objects

		DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        //Send the command line arg to the server via the socket output stream
        out.writeUTF("David_ColeCSC8560");
        
        //Read the result from the socket input stream
        String answer = in.readUTF();
        
        //Print the result to System.out
        System.out.println(answer);
        
        //Close IO streams and socket
        socket.close();
	
    }  
} 