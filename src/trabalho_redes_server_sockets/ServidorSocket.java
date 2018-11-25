
package trabalho_redes_server_sockets;  
  
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;  
import java.net.Socket;  
  
public class ServidorSocket {  
    
    private static final int PORTA_SOCKET = 8080;  
  
    public static void main(String[] args) {  
        try {  
            info("Server iniciado na porta: " + PORTA_SOCKET);  
  
            try (ServerSocket serverSocket = new ServerSocket(PORTA_SOCKET)) {  
                
                while (true) {  
                    Socket socket = serverSocket.accept();
                    System.out.println("Conectando Cliente");
                    try {  
                        DataOutputStream canalSaida =  new DataOutputStream(socket.getOutputStream());
                        DataInputStream canalEntrada = new DataInputStream(socket.getInputStream());
                        System.out.println("Ouvindo");
                        
                        String dosagem = canalEntrada.readUTF();
                        dosagem = Server.comparaMsg(dosagem);
                        System.out.println(dosagem);
                        
                        canalSaida.writeBytes(dosagem);
                        System.out.println(canalSaida.toString());
                        canalSaida.flush();
                        
                        System.out.println("Mensagem enviada para Cliente");
                        canalSaida.close();
                        socket.close();
                        System.out.println("Fechando Conexão");
                        
                    } catch(IOException e) {  
                        socket.close();  
                        error("Servidor.while: " + e.toString());  
                    }  
                 }  
              }  
        } catch (IOException e) {  
            error("Servidor.run(): " + e.toString());  
            System.out.println("Surdo");
        }  
    }  
  
    private static void error(String log) {  
        System.out.println("error: " + log);  
    }  
  
    private static void info(String log) {  
        System.out.println("info: " + log);  
    }  
  
}  
