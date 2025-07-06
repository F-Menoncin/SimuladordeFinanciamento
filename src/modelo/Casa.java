package modelo;

import exceptions.AumentoMaiorQueJurosException;

public class Casa extends Financiamento {
    private static final double taxaExtra = 80.00;
    private double areaTerrenoConstruida;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaTerrenoConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }
    @Override
    public double pagamentoMensal() throws AumentoMaiorQueJurosException {
        double parcelaBase = super.pagamentoMensal();
        double amortizacao = getValorImovel()/(getPrazoFinanciamento() * 12);
        double jurosMensal = parcelaBase - amortizacao;

        if (taxaExtra > (jurosMensal/2)){
            throw new AumentoMaiorQueJurosException("A taxa extra do seguro é maior que a metade dos juros da parcela.");
        }

        return parcelaBase + taxaExtra;
    }

    @Override
    public void mostrarDadosAdicionais(){
        System.out.printf("Área construída: %.2f m²%n", this.areaTerrenoConstruida);
        System.out.printf("Tamanho do terreno: %.2f m²%n", this.tamanhoTerreno);
    }
}
