import java.rmi.*;

public interface Calculadora extends Remote {
    public float somar(int a, int b) throws RemoteException;
    public float subtrair(int a, int b) throws RemoteException;
    public float multiplicar(int a, int b) throws RemoteException;
    public float dividir(int a, int b) throws RemoteException;
}