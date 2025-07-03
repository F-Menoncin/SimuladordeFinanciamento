package modelo;

public class Casa extends Financiamento {
    private static double taxaExtra = 80.00;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }
    @Override
    public double pagamentoMensal(){
        return super.pagamentoMensal() + taxaExtra;
    }
}
