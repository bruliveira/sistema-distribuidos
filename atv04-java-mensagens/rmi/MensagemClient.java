import java.rmi.Naming;
import java.util.List;

public class MensagemClient {
    private static Mensagem mensagemService = null;

    public static void main(String[] args) {
        try {
            mensagemService = (Mensagem) Naming.lookup("rmi://127.0.0.1:11099/RMIInterface");
            
            mensagemService.armazenarMensagem("Mensagem dfi");
            mensagemService.armazenarMensagem("Mensagem 4ff");
            
            // As mensagens do servidor
            List<String> mensagens = mensagemService.listarMensagens();
            System.out.println("\n--> Mensagens no servidor");
            for (String mensagem : mensagens) {
                System.out.println(mensagem);
            }
            
            // IP 
            String ipServidor = mensagemService.getIpServidor();
            System.out.println("\n--> IP do servidor teste\n" + ipServidor);
            
            // Data e hora
            String dataHoraServidor = mensagemService.getDataHoraServidor();
            System.out.println("\n--> Data e hora do servidor\n" + dataHoraServidor);
            
        } catch (Exception e) {
            System.out.println("\nProblema com o client aqui" + e);
        }
    }
}
