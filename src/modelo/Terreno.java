package modelo;

public class Terreno extends Financiamento {
    private static double acrescimoRisco = 1.02;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }
    @Override
    public double pagamentoMensal(){
        return super.pagamentoMensal() * acrescimoRisco;
    }
}
