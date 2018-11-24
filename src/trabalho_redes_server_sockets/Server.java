
package trabalho_redes_server_sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * @author claytonandrade
 */
public class Server {
    private ServerSocket server;
    private Socket client;
    private BufferedReader in;
    private String line;
    
    public Server(){
        line = "";
        listenSocket();
    }

    public void listenSocket() {
        // Colocar o porto em escuta (Porto = 4500)
        try {
            server = new ServerSocket(4500);
        } catch (IOException e) {
            System.out.println("Could not listen on port 4500");
            System.exit(-1);
        }
        //writeInfo("Listen on Port 4500");
        System.out.println("Ouvindo Porta 4500");
        
        //Aceitar cliente
        try {
            client = server.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 4500");
            System.exit(-1);
        }
        
        //writeInfo("Client Accepted");
        System.out.println("Cliente Aceito");

        //Preparar Buffers
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            System.out.println("Read failed");
            System.exit(-1);
        }
        
        //writeInfo("Buffereds Accepted");
        System.out.println("Buffereds Aceitos");

        //Colocar o socket à escuta, à espera de mensagens do cliente
        while (true) {
            try {
                //Read message from client
                line = in.readLine();
                //Print message from client
                System.out.println("Message from client: " + line);
            } catch (IOException e) {
                System.out.println("Read failed: " + e.toString());
                System.exit(-1);
            }
        }
    }
}
