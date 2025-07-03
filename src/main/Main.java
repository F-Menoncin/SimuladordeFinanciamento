package main;

import util.InterfaceUsuario;
import modelo.Financiamento;
import modelo.Casa;
import modelo.Apartamento;
import modelo.Terreno;
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
                    financiamentos.add(new Casa(valorImovel, prazoFinan, taxaJur));
                    break;
                case 2:
                    financiamentos.add(new Apartamento(valorImovel, prazoFinan, taxaJur));
                    break;
                case 3:
                    financiamentos.add(new Terreno(valorImovel, prazoFinan, taxaJur));
                    break;
            }
        }

        System.out.printf("\n ======Relatório Final: %d financiamento(s) cadastrado(s)======\n", financiamentos.size());
        double somaImoveis = 0;
        double somaFinanciamentos = 0;
        int contador = 1;

        for (Financiamento f : financiamentos){
            System.out.printf("\n------ Detalhes do %dº financiamento, tipo %s ------\n", contador, f.getClass().getSimpleName());
            f.mostrarDadosGerados();

            somaImoveis += f.getValorImovel();
            somaFinanciamentos += f.totalPagamento();

            contador++;
        }
        System.out.println("\n============================================");
        System.out.printf("Soma total dos %d imóveis: R$ %.2f\n", numDeFinanciamentos, somaImoveis);
        System.out.printf("Soma total dos %d financiamentos: R$ %.2f\n", numDeFinanciamentos, somaFinanciamentos);
        System.out.println("============================================");
    }
}
