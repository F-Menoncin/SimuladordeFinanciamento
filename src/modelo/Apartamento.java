package modelo;

public class Apartamento extends Financiamento {
    private int vagasDaGaragem;
    private int numeroDoAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagasDaGaragem = vagasGaragem;
        this.numeroDoAndar = numeroAndar;
    }
    @Override
    public double pagamentoMensal(){
        double taxaMensal = (getTaxaJurosAnual()/100) / 12;
        int meses = getPrazoFinanciamento() * 12;
        //professor, alterei a fórmula original pois o valor estava sendo fora da realidade, com um financiamento de R$100 mil retornando R$39 milhões de reais
        return getValorImovel() * ((taxaMensal * Math.pow(1 + taxaMensal,meses)) / (Math.pow(1 + taxaMensal, meses) - 1) );
    }

    @Override
    public void mostrarDadosAdicionais(){
        System.out.printf("Vagas na garagem: %d%n", this.vagasDaGaragem);
        System.out.printf("Número do andar: %d%n", this.numeroDoAndar);
    }
}
