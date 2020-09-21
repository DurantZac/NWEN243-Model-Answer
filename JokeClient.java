import java.io.*;
import java.net.*;

public class JokeClient{
    
    public static void main(String[] args) throws IOException{
	
	// first, create the client socket, this creates a TCP socket
	// with the IP/Name in args[0] and port number from args[1]

	// Note we put the message in args[2]

	Socket socket = new Socket(args[0], Integer.parseInt(args[1]));

	// because we are dealing with byte streams (like files), we now
	// need to wrap some java reader and writer classes around the socket
	// actually very very similar to files.  Actually we only need
	// a reader...

	BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	String message;

	// OK, now we are ready to do stuff.

	while((message = in.readLine()) != null){
	    System.out.println(message);
	}
	socket.close();
    }

}
