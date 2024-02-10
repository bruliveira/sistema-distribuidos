import java.rmi.*;

public interface Conversor extends Remote {
    double realParaEuro(double valorReal) throws RemoteException;
    double realParaDolar(double valorReal) throws RemoteException;
    double dolarParaReal(double valorDolar) throws RemoteException;
    double euroParaReal(double valorEuro) throws RemoteException;
}