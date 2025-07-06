package main;

import exceptions.AumentoMaiorQueJurosException;
import util.InterfaceUsuario;
import modelo.*;
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

            contador++;
            } catch (AumentoMaiorQueJurosException e){
                System.out.println("Erro no financiamento: " + e.getMessage());
                somaImoveis += f.getValorImovel();
            }
        }
        System.out.println("\n============================================");
        System.out.printf("Soma total dos %d imóveis: R$ %.2f\n", numDeFinanciamentos, somaImoveis);
        System.out.printf("Soma total dos %d financiamentos: R$ %.2f\n", numDeFinanciamentos, somaFinanciamentos);
        System.out.println("============================================");
    }
}
