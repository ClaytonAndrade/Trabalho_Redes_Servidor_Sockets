
package trabalho_redes_server_sockets;

/**
 * @author claytonandrade
 */
public class Server {
    
    public Server() {
        
    }
    
    public static String comparaMsg(String msg){
        String dosagemRetorno = null;
        
        System.out.println(msg.trim());
        
        if(msg != null)switch (msg.trim()) {
            case "Crianças Dipirona":
                dosagemRetorno = "1 gota por quilo";
                break;
            case "Jovens Dipirona":
                dosagemRetorno = "2 gota por quilo";
                break;
            case "Adultos Dipirona":
                dosagemRetorno = "3 gota por quilo";
                break;
            case "Crianças Paracetamol": 
                dosagemRetorno = "1mg por quilo";
                break;
            case "Jovens Paracetamol": 
                dosagemRetorno = "2mg por quilo";
                break;
            case "Adultos Paracetamol": 
                dosagemRetorno = "3mg por quilo";
                break;
            case "Crianças Dramin": 
                dosagemRetorno = "10 gotas até 10 anos";
                break;
            case "Jovens Dramin": 
                dosagemRetorno = "até 2 comprimidos ao dia";
                break;
            case "Adultos Dramin": 
                dosagemRetorno = "até 3 comprimidos ao dia";
                break;
            default:
                dosagemRetorno = "Nào conseguimos manter uma conexão";
                break;
        }
        
        return dosagemRetorno;
    }
}
