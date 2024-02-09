import java.rmi.*;
import java.util.List;

public interface Mensagem extends Remote {
    void armazenarMensagem(String mensagem) throws RemoteException;
    List<String> listarMensagens() throws RemoteException;
    String getIpServidor() throws RemoteException;
    String getDataHoraServidor() throws RemoteException;
}