package modelo;

import exceptions.AumentoMaiorQueJurosException;
import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {
    private  String tipoDeZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoDeZona){
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoDeZona = tipoDeZona;
    }
    @Override
    public double pagamentoMensal() throws AumentoMaiorQueJurosException {
        return super.pagamentoMensal() * 1.02;
    }

    @Override
    public void mostrarDadosAdicionais() {
        System.out.printf("Tipo de zona: %s%n", this.tipoDeZona);
    }

    @Override
    public String paraFormatoTexto(){
        return String.format("%.2f;%d;%.2f;%s", getValorImovel(), getPrazoFinanciamento(), getTaxaJurosAnual(), this.tipoDeZona);
    }
}

