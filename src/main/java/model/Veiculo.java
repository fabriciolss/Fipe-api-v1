package model;

public class Veiculo {
    private String valor;
    private String marca;
    private String modelo;
    private String combustivel;
    private int ano;

    public Veiculo(VeiculoRecord dadosVeiculo) {
        this.valor = dadosVeiculo.valorVeiculo();
        this.marca = dadosVeiculo.marcaVeiculo();
        this.combustivel = dadosVeiculo.combustivelVeiculo();
        this.modelo = dadosVeiculo.modeloVeiculo();
        this.ano = dadosVeiculo.lancamentoVeiculo();
    }

    public String getValor() {
        return valor;
    }

    public String getMarca() {
        return marca;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Veiculo[valor=" + this.getValor() +
                ", marca=" + this.getMarca() +
                ", modelo=" + this.getModelo() +
                ", ano=" + this.getAno() +
                ", combustivel=" + this.getCombustivel() + "]";

    }
}
