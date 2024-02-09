import java.rmi.Naming;

public class CalculadoraClient {
    private static Calculadora calc = null;

    public static void main(String[] args) {
        try {
            calc = (Calculadora) Naming.lookup("rmi://127.0.0.1:11099/RMIInterface");
            System.out.println(String.valueOf(calc.somar(4, 3)));
        }
        catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }
}
