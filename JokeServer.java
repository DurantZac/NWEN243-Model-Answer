import java.net.*;
import java.io.*;
import java.util.*;
 
public class JokeServer extends Thread {
    private Socket ws;
    private String[] jokes = {
        "I invented a new word: Plagiarism!",
        "Did you hear about the mathematician who’s afraid of negative numbers? He’ll stop at nothing to avoid them.",
        "What’s the best thing about Switzerland? I don’t know, but the flag is a big plus.",
        "Why do we tell actors to break a leg? Because every play has a cast.",
        "Where are average things manufactured? The satisfactory.",
    };
        
    public JokeServer(Socket workerSocket, int counter){
        ws = workerSocket;
    }
    
    public void run() {
        Random r = new Random(System.currentTimeMillis()); //initialise it.
        try{
            PrintWriter out = new PrintWriter(ws.getOutputStream(), true);          
            out.println("Joke: " + jokes[r.nextInt(4)]);
	    ws.close();
        }catch (IOException e) {
        }
    }
    
    public static void main(String args[]) {
        int i = 0;
        
        try{
            ServerSocket serverSocket = new ServerSocket(5000);
            for(;;){                            
                (new JokeServer(serverSocket.accept(),i++)).start();
            }
        } catch (IOException e){
        }
    }
}
