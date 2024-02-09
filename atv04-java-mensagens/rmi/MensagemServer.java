import java.net.InetAddress;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MensagemServer extends UnicastRemoteObject implements Mensagem {
    private List<String> listaMensagens = new ArrayList<>();

    protected MensagemServer() throws RemoteException {
        super();
    }
    @Override
    public void armazenarMensagem(String mensagem) throws RemoteException {
        listaMensagens.add(mensagem);
    }
    @Override
    public List<String> listarMensagens() throws RemoteException {
        return listaMensagens;
    }
    @Override
    public String getIpServidor() throws RemoteException {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            e.printStackTrace();
            return "Não foi possível obter o IP do servidor.";
        }
    }
    @Override
    public String getDataHoraServidor() throws RemoteException {
        Date dataHora = new Date();
        return String.format("%tF %tT", dataHora, dataHora);
    }
    public static void main(String[] args) {
        try {
            MensagemServer server = new MensagemServer();
            System.out.println("Iniciando servidor RMI ...");
            Naming.rebind("rmi://127.0.0.1:11099/RMIInterface", server);
        } catch (Exception e) {
            System.out.println("Problema ao iniciar o servidor: " + e);
        }
    }
}