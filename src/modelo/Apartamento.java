package modelo;

public class Apartamento extends Financiamento {
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }
    @Override
    public double pagamentoMensal(){
        double taxaMensal = (getTaxaJurosAnual()/100) / 12;
        int meses = getPrazoFinanciamento() * 12;
        //professor, alterei a fórmula original pois o valor estava sendo fora da realidade, com um financiamento de R$100 mil retornando R$39 milhões de reais
        return getValorImovel() * ((taxaMensal * Math.pow(1 + taxaMensal,meses)) / (Math.pow(1 + taxaMensal, meses) - 1) );
    }
}
