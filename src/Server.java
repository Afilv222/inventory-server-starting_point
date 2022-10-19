import java.net.ServerSocket; 
import java.io.IOException; 
import java.net.Socket; 

public class Server{

    BufferedReader socketIn;
    PrintWriter socketOut; 

    Server(){
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            Socket socket = serverSocket.accept(); 

            // read and write socket data 
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream()); 
            this.socketIn = new BufferedReader(streamReader); 
    
            this.socketOut = new PrintWriter(socket.getOutputStream(),true); 

            String line = "";
            while(true){
                this.line = socketIn.readLine(); 
                if(line.equalsIgnoreCase("DATE")){
                    // Do something 
                    socketOut.write(""); 
                } 
                if(line.equalsIgnoreCase("BREAK")){
                    break; 
                }
            }

                socketIn.close();
                socketOut.close(); 
                socket.close(); 
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
        
    }



}