import java.util.Scanner;
import java.util.Locale;

public class Main{
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        double totalPrice = 0.00;
        double unitPrice = 0.00;
        double fixedPrice = 0.00;
        double afterDiscount = 0.00;
        String product;
        String mostExpensiveProduct = "";
        int totalProducts = 0; 
        char continueChoice = ' ';

        System.out.println("------------------------------");
        System.out.println("SISTEMA DE CAIXA DE MERCADO");
        System.out.println("------------------------------");

        do {

            System.out.println("\nInforme o nome do produto: ");
            product = sc.next();
            totalProducts += 1;
            System.out.println("Informe o preço do produto: ");
            unitPrice = sc.nextDouble();

            if (unitPrice < 0){
                System.out.println("ERRO: VALORES NEGATIVOS NÃO SÃO PERMIDOS.");
                System.out.println("Por favor, insira um valor válido: ");
                unitPrice = sc.nextDouble();
            }

            if (unitPrice > fixedPrice){
                mostExpensiveProduct = product;
            }

            fixedPrice = unitPrice;
            totalPrice += unitPrice;
            System.out.println("Deseja continuar? (s/n)");
            continueChoice = sc.next().charAt(0);

        } while(continueChoice != 'n');

        if (totalPrice > 100.00){
            afterDiscount = totalPrice - (totalPrice * 10) / 100;
            System.out.println("\nParabéns! Você ganhou 10% de desconto!");
            System.out.printf("Total da compra: R$ %.2f\n", afterDiscount);
            System.out.printf("Quantidade de produtos: %d\n", totalProducts);
            System.out.println("Produto mais caro: " + mostExpensiveProduct);
            sc.close();
            return;
        }

        System.out.printf("\nTotal da compra: R$ %.2f\n", totalPrice);
        System.out.printf("Quantidade de produtos: %d\n", totalProducts);
        System.out.println("Produto mais caro: " + mostExpensiveProduct);

        sc.close();
    }
}