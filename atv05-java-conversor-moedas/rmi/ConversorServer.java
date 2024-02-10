import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class ConversorServer extends UnicastRemoteObject implements Conversor {
    protected ConversorServer() throws RemoteException {
        super();
    }

    @Override
    public double euroParaReal(double valorEuro) throws RemoteException {
        return valorEuro * 5.34;
    }

    @Override
    public double realParaEuro(double valorReal) throws RemoteException {
        return valorReal * 0.19;
    }

    @Override
    public double dolarParaReal(double valorDolar) throws RemoteException {
        return valorDolar * 5.0;
    }

    @Override
    public double realParaDolar(double valorReal) throws RemoteException {
        return valorReal * 0.2;
    }

    public static void main(String[] args) {
        try {
            ConversorServer server = new ConversorServer();
            System.out.println("Servidor de conversão de moeda pronto...");
            Naming.rebind("rmi://127.0.0.1:11099/ConversorMoeda", server);
        } catch (Exception e) {
            System.out.println("Probleminha ao iniciar o servidor: " + e);
        }
    }
}
