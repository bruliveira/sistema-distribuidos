import java.rmi.Naming;

public class ConversorClient {
    private static Conversor conversorService = null;

    public static void main(String[] args) {
        try {
            conversorService = (Conversor) Naming.lookup("rmi://127.0.0.1:11099/ConversorMoeda");

            double valorReal = 2;
            double valorDolar = 50.0;

            double valorEuro = conversorService.realParaEuro(valorReal);
            System.out.println("--> R$ " + valorReal + " equivalente a € " + valorEuro);

            valorReal = conversorService.euroParaReal(valorEuro);
            System.out.println("--> € " + valorEuro + " equivalente a R$ " + valorReal);

            

            valorReal = conversorService.dolarParaReal(valorDolar);
            System.out.println("--> $ " + valorDolar + " equivalente a R$ " + valorReal);

            valorDolar = conversorService.realParaDolar(valorReal);
            System.out.println("--> R$ " + valorReal + " equivalente a $ " + valorDolar);

        } catch (Exception e) {
            System.out.println("Problema com o cliente teste: " + e);
        }
    }
}