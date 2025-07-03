package util;

import java.util.Scanner;

public class InterfaceUsuario {

    private Scanner scanner;

    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public int tipoDeFinanciamento(){
        int tipo = 0;
        do {
            System.out.println("Qual o tipo de financiamento?");
            System.out.println("1 - Casa");
            System.out.println("2 - Apartamento");
            System.out.println("3 - Terreno");
            System.out.print("Digite a opção: ");
            tipo = Integer.parseInt(scanner.nextLine());
            if (tipo < 1 || tipo > 3) {
                System.out.println("Opção inválida!");
            }
        } while (tipo < 1 || tipo > 3);
        return tipo;
    }

    public int numDeFinanciamentos(){
        int numero;
        do {
        System.out.print("Quantas simulações deseja realizar? ");
        numero = Integer.parseInt(scanner.nextLine());
        if (numero <= 0){
            System.out.println("O valor do imóvel não pode ser negativo!");
            System.out.println("\nDigite um valor válido!");
            }
        }while (numero <= 0);
        return numero;
    }

    public double receberValorImovel(){
        double valor;
        do {
            System.out.print("Digite o valor do imóvel: R$ ");
            valor = Double.parseDouble(scanner.nextLine());
            if (valor <= 0){
                System.out.println("O valor do imóvel não pode ser negativo!");
                System.out.println("\nDigite um valor válido!");
            }
        } while (valor <= 0);
        return  valor;
    }

    public int receberPrazo(){
        int prazo;
        do {
            System.out.print("Digite o prazo do financiamento em anos: ");
            prazo = Integer.parseInt(scanner.nextLine());
            if (prazo <= 0){
                System.out.println("O prazo não pode ser negativo!");
                System.out.println("\nDigite um valor válido!");
            }
        } while (prazo <= 0);
        return  prazo;
    }

    public double receberTaxaJuros(){
        double taxa;
        do {
            System.out.print("Digite a taxa de juros em %: ");
            taxa = Double.parseDouble(scanner.nextLine());
            if (taxa <= 0 || taxa > 100){
                System.out.println("O valor da taxa inválido!");
                System.out.println("\nDigite um valor válido!");
            }
        } while (taxa <= 0 || taxa > 100);
        return taxa;
    }
}
