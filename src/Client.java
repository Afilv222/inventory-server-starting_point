import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    BufferedReader socketIn;
    BufferedReader stdIn;
    PrintWriter socketOut;
    Socket socket;

    // Same steps as server , but the socket you need to enter the IP address
    public Client(String serverName, int portNumber) {
        try {
            // Create a Socket object, indicating the host name, and the port number
            socket = new Socket(serverName, portNumber);

            // Obtain socket’s input/output handle and open streams on the socket
            // read from the socket and write to the socket
            InputStreamReader socketInputReader = new InputStreamReader(socket.getInputStream());
            socketIn = new BufferedReader(socketInputReader);
            OutputStream socketOutStream = socket.getOutputStream();
            socketOut = new PrintWriter(socketOutStream, true);

            // Obtain standard input/out stream, if necessary to communicate with the user
            // for reading from keyboard and for writing messages to the user
            InputStreamReader inputReader = new InputStreamReader(System.in);
            stdIn = new BufferedReader(inputReader);

            communicate();

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
            // TODO: handle exception
        }
    }

    public void communicate() {
        String line = "";
        Item response = null;

        System.out.println("Please select an option(SEARCH/EXIT)");

        while (true) {
            try {
                line = stdIn.readLine();
                if (!line.equalsIgnoreCase("EXIT")) {

                    socketOut.println(line);
                    ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                    // response = socketIn.readLine();
                    response = (Item) objectInputStream.readObject();
                    System.out.println(response.getId());
                } else {
                    System.out.println("Closing this connection");
                    socket.close();
                    System.out.println("Connection closed");
                    break;
                }

            } catch (Exception e) {
                System.out.println("Sending error:" + e.getMessage());
                // TODO: handle exception
            }
        }

        try {
            stdIn.close();
            socketIn.close();
            socketOut.close();
            socket.close();
        } catch (Exception e) {
            System.out.print("Closing error:" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 9000);
    }
}