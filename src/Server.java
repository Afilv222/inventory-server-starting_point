import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;

public class Server {

    BufferedReader socketIn;
    PrintWriter socketOut;

    Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(9000);
            System.out.println("Server is now running!!");
            Socket socket = serverSocket.accept();

            // read and write socket data
            InputStreamReader socketInputReader = new InputStreamReader(socket.getInputStream());
            socketIn = new BufferedReader(socketInputReader);

            socketOut = new PrintWriter(socket.getOutputStream(), true);

            String line = "";
            while (true) {
                try {
                    line = socketIn.readLine();
                    Database dp = new Database();
                    if (line.equalsIgnoreCase("SEARCH")) {
                        // Do something
                        socketOut.println("Enter ID of Item to be searched");
                        line = socketIn.readLine();

                        Item item = dp.search(Integer.parseInt(line));
                        ObjectOutputStream objectOutPutStream = new ObjectOutputStream(socket.getOutputStream());
                        objectOutPutStream.writeObject(item);
                        System.out.println(item.toString());

                        // socketOut.write(socket.getPort());
                        // socketOut.write(item.toString());
                    }
                    if (line.equalsIgnoreCase("EXIT")) {
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    // TODO: handle exception
                }
            }

            socketIn.close();
            socketOut.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
    }

    public static void main(String[] args) {
        Server server = new Server();

    }

}