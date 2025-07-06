package util;

import javax.imageio.stream.ImageInputStreamImpl;
import java.util.Scanner;

public class InterfaceUsuario {

    private Scanner scanner;

    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public int tipoDeFinanciamento() {
        int tipo = 0;
        do {
            System.out.println("Qual o tipo de financiamento?");
            System.out.println("1 - Casa");
            System.out.println("2 - Apartamento");
            System.out.println("3 - Terreno");
            System.out.print("Digite a opção: ");
            String entrada = scanner.nextLine();
            try {
                tipo = Integer.parseInt(entrada);
                if (tipo < 1 || tipo > 3) {
                    System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e){
                System.out.println("ERRO: Digite o número correspondente ao tipo de financiamento.");
                tipo = 0;
            }
        } while (tipo < 1 || tipo > 3);
        return tipo;
    }

    public int numDeFinanciamentos() {
        int numero;
        do {
            System.out.print("Digite o número de simulações: ");
            String entrada = scanner.nextLine();
            try {
                numero = Integer.parseInt(entrada);
                if (numero <= 0) {
                    System.out.println("O número de simulações deve ser positivo!");
                    System.out.println("\nDigite um valor válido!");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO: A quantidade de simulações deve ser um número.");
                numero = 0;
            }
        } while (numero <= 0) ;
        return numero;
    }

    public double receberValorImovel() {
        double valor;
        do {
            System.out.print("Digite o valor do imóvel: R$ ");
            String entrada = scanner.nextLine();
            try{
                valor = Double.parseDouble(entrada);
                if (valor <= 0) {
                System.out.println("O valor do imóvel deve ser positivo!");
                System.out.println("\nDigite um valor válido!");
                }
            } catch (NumberFormatException e){
                System.out.println("ERRO: O valor do imóvel deve ser um número.");
                valor = 0;
            }
        } while (valor <= 0);
        return valor;
    }

    public int receberPrazo() {
        int prazo;
        do {
            System.out.print("Digite o prazo do financiamento em anos: ");
            String entrada = scanner.nextLine();
            try {
                prazo = Integer.parseInt(entrada);
                if (prazo <= 0) {
                    System.out.println("O prazo não pode ser negativo!");
                    System.out.println("\nDigite um valor válido!");
                }
            } catch (NumberFormatException e){
                System.out.println("ERRO: O prazo do financiamento deve ser um número.");
                prazo = 0;
            }
        } while (prazo <= 0);
        return prazo;
    }

    public double receberTaxaJuros() {
        double taxa;
        do {
            System.out.print("Digite a taxa de juros em %: ");
            String entrada = scanner.nextLine();
            try{
                taxa = Double.parseDouble(entrada);
                if (taxa <= 0 || taxa > 100) {
                System.out.println("O valor da taxa inválido!");
                System.out.println("\nDigite um valor válido!");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO: A taxa de juros deve ser um número.");
                taxa = 0;
            }
        } while (taxa <= 0 || taxa > 100);
        return taxa;
    }

    public double pedirAreaTerreno() {
        double areaTerreno;
        do {
            System.out.print("Digite a área do terreno, em m²: ");
            String entrada = scanner.nextLine();
            try{
                areaTerreno = Double.parseDouble(entrada);
                if (areaTerreno <= 0) {
                    System.out.println("A área do terreno não pode ser nula ou negativa. Tente novamente!");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO: A área do terreno deve ser um número.");
                areaTerreno = 0;
            }
        } while (areaTerreno <= 0);
        return areaTerreno;
    }


    public double pedirAreaConstruida(double areaDoTerreno) {
        double areaConstruida;
        do {
            System.out.print("Digite a área construída, em m²: ");
            String entrada = scanner.nextLine();
            try {
                areaConstruida = Double.parseDouble(entrada);
                if (areaConstruida <= 0) {
                    System.out.println("A área construída não pode ser nula ou negativa. Tente novamente!");
                } else if (areaConstruida > areaDoTerreno) {
                    System.out.println("A área construída não pode ser maior que a área do terreno. Tente novamente!");
                }
            } catch (NumberFormatException e){
                System.out.println("ERRO: A área construída deve ser um número.");
                areaConstruida = 0;
            }
        }while (areaConstruida <= 0 || areaConstruida > areaDoTerreno);
        return areaConstruida;
    }

    public int pedirVagasGaragem(){
        int vagasGaragem;
        do {
            System.out.print("Digite a quantidade de vagas de estacionamento: ");
            String entrada = scanner.nextLine();
            try {
                vagasGaragem = Integer.parseInt(entrada);
                if (vagasGaragem < 0) {
                    System.out.println("O número de vagas não pode ser negativa. Tente novamente!");
                }
            } catch (NumberFormatException e){
                System.out.println("ERRO: A quantidade de vagas deve ser um número.");
                vagasGaragem = -1;
            }
        } while (vagasGaragem < 0);
        return vagasGaragem;
    }

    public int pedirNumeroAndar(){
        int numeroAndar;
        do {
            System.out.print("Digite o número do andar: ");
            String entrada = scanner.nextLine();
            try {
                numeroAndar = Integer.parseInt(entrada);
                if (numeroAndar <= 0) {
                    System.out.println("O andar não pode ser nulo ou negativo. Tente novamente!");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERRO: O andar deve ser um número.");
                numeroAndar = 0;
            }
        }while (numeroAndar <= 0);
        return numeroAndar;
    }

    public String pedirTipoZona(){
        String tipoZona;
        do {
            System.out.print("Digite o tipo de zona (residencial ou comercial): ");
            tipoZona = scanner.nextLine().trim();
            if(!tipoZona.equalsIgnoreCase("residencial") && !tipoZona.equalsIgnoreCase("comercial")){
                System.out.println("Opção inválida! Por favor, digite 'residencial' ou 'comercial'.");
            }
        } while (!tipoZona.equalsIgnoreCase("residencial") && !tipoZona.equalsIgnoreCase("comercial"));
        return tipoZona;
    }
}