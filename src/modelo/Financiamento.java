package modelo;

public class Financiamento {

    // Atributos
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;


    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        if (valorImovel <= 0 || prazoFinanciamento <= 0 || taxaJurosAnual <= 0) {
            throw new IllegalArgumentException("Valores de financiamento não podem ser negativos ou zero.");
        }
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getValorImovel(){
        return this.valorImovel;
    }

    public int getPrazoFinanciamento(){
        return this.prazoFinanciamento;
    }

    public double getTaxaJurosAnual(){
        return this.taxaJurosAnual;
    }

    public double pagamentoMensal() {
        double taxaMensal = (this.taxaJurosAnual / 100) / 12;
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + taxaMensal);
    }


    public double totalPagamento() {
        return this.pagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public void mostrarDadosGerados(){
        System.out.printf("\nValor do imóvel: R$ %.2f", this.getValorImovel());
        System.out.printf("\nPrazo em anos: %d", this.getPrazoFinanciamento());
        System.out.printf("\nTaxa de juros anual: %.2f%%", this.getTaxaJurosAnual());
        System.out.printf("\n\nPagamento Mensal: R$ %.2f", this.pagamentoMensal());
        System.out.printf("\nTotal a ser pago: R$ %.2f\n", this.totalPagamento());
    }
}
