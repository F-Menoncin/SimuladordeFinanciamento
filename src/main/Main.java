package main;

import exceptions.AumentoMaiorQueJurosException;
import util.InterfaceUsuario;
import modelo.*;
import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        InterfaceUsuario ui = new InterfaceUsuario();
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        System.out.println("---------SIMULADOR DE FINANCIAMENTOS---------");
        int numDeFinanciamentos = ui.numDeFinanciamentos();

        for (int i = 1; i <= numDeFinanciamentos; i++) {
            System.out.printf("\n====== Dados do %dº financiamento ======\n", i);
            double valorImovel = ui.receberValorImovel();
            int prazoFinan = ui.receberPrazo();
            double taxaJur = ui.receberTaxaJuros();

            int tipoFinanciamento = ui.tipoDeFinanciamento();

            switch (tipoFinanciamento){
                case 1:
                    double tamanhoTerreno = ui.pedirAreaTerreno();
                    double areaConstruida = ui.pedirAreaConstruida(tamanhoTerreno);
                    financiamentos.add(new Casa(valorImovel, prazoFinan, taxaJur, areaConstruida, tamanhoTerreno));
                    break;
                case 2:
                    int vagas = ui.pedirVagasGaragem();
                    int andar = ui.pedirNumeroAndar();
                    financiamentos.add(new Apartamento(valorImovel, prazoFinan, taxaJur, vagas, andar));
                    break;
                case 3:
                    String zona = ui.pedirTipoZona();
                    financiamentos.add(new Terreno(valorImovel, prazoFinan, taxaJur, zona));
                    break;
            }
        }

        System.out.printf("\n ======Relatório Final: %d financiamento(s) cadastrado(s)======\n", financiamentos.size());
        double somaImoveis = 0;
        double somaFinanciamentos = 0;
        int contador = 1;

        for (Financiamento f : financiamentos){
            try{
                System.out.printf("\n------ Detalhes do %dº financiamento, tipo %s ------\n", contador, f.getClass().getSimpleName());
            f.mostrarDadosGerados();
            somaImoveis += f.getValorImovel();
            somaFinanciamentos += f.totalPagamento();


            } catch (AumentoMaiorQueJurosException e){
                System.out.println("\nErro no financiamento: " + e.getMessage());
                somaImoveis += f.getValorImovel();
            } finally {
                contador++;
            }
        }
        System.out.println("\n============================================");
        System.out.printf("Soma total dos %d imóveis: R$ %.2f\n", numDeFinanciamentos, somaImoveis);
        System.out.printf("Soma total dos %d financiamentos: R$ %.2f\n", numDeFinanciamentos, somaFinanciamentos);
        System.out.println("============================================");
        System.out.println("\n--- Persistência de Dados ---");

        escreverFinanciamentos(financiamentos, "financiamentos.txt");
        lerFinanciamentos("financiamentos.txt");

        serializarFinanciamentos(financiamentos, "financiamentos.ser");
        desserializarFinanciamentos("financiamentos.ser");

    }

    public static void escreverFinanciamentos(ArrayList<Financiamento> financiamentos, String arquivoFinanciamentos){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoFinanciamentos))) {
            for (Financiamento f : financiamentos){
                writer.write(f.paraFormatoTexto());
                writer.newLine();
            }
            System.out.println("Dados salvos em " + arquivoFinanciamentos);
        } catch (IOException e){
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static void lerFinanciamentos(String arquivoFinanciamentos){
        System.out.println("\nLendo dados do arquivo para comprovação:");
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivoFinanciamentos))) {
            String linha;
            while ((linha = reader.readLine()) != null){
                System.out.println(linha);
            }
        }catch (IOException e){
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static void serializarFinanciamentos(ArrayList<Financiamento> financiamentos, String arquivoFinanciamentos){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivoFinanciamentos))){
            oos.writeObject(financiamentos);
            System.out.println("Dados serializados salvos em " + arquivoFinanciamentos);
        } catch (IOException e){
            System.err.println("\nErro ao serializar os dados: " + e.getMessage());
        }
    }

    public static void desserializarFinanciamentos(String arquivoFinanciamentos){
        System.out.println("\nLendo dados serializados para comprovação:");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivoFinanciamentos))){
            ArrayList<Financiamento> financiamentosLidos = (ArrayList<Financiamento>) ois.readObject();
            for (Financiamento f : financiamentosLidos){
                try{
                    System.out.println("-------------------");
                    f.mostrarDadosGerados();
                } catch (AumentoMaiorQueJurosException e){
                    System.err.println("Erro ao exibir financiamento: " + e.getMessage());
                }
            }
        } catch (IOException | ClassNotFoundException e){
            System.err.println("\nErro ao desserializar os dados: " + e.getMessage());
        }
    }
}
