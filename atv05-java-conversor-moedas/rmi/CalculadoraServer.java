import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraServer extends UnicastRemoteObject implements Calculadora{
    public CalculadoraServer() throws RemoteException {
        super();
    }

    @Override
    public float somar(int a, int b) throws RemoteException {
        return(a+b);
    }

    @Override
    public float subtrair(int a, int b) throws RemoteException {
        return(a-b);
    }

    @Override
    public float multiplicar(int a, int b) throws RemoteException {
        return(a*b);
    }

    @Override
    public float dividir(int a, int b) throws RemoteException {
        return (a/b);
    }

    public static void main(String[] args) {
        try {
            CalculadoraServer server = new CalculadoraServer();
            System.out.println("CalculadoraServer is running...");
            Naming.rebind("rmi://127.0.0.1:11099/RMIInterface", new CalculadoraServer());
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }

}
