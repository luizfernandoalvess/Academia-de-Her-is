package model;

public class Arqueiro extends Heroi {
    private double precisao;
    private int agilidade;
    private int concentracao;

    public Arqueiro(String nome, int nivel, int vida, int mana, double precisao, int agilidade, int concentracao) {
      super(nome, nivel, vida, mana, "Arqueiro");
        this.precisao = precisao;
        this.agilidade = agilidade;
        this.concentracao = concentracao;
    }

    @Override
    public String getClasse() {
        return "Arqueiro";
    }

    public void setPrecisao(double precisao) {
        this.precisao = precisao;
    }

    public double getPrecisao() {
        return precisao;
    }

    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public void setConcentracao(int concentracao) {
        this.concentracao = concentracao;
    }

    public int getConcentracao() {
        return concentracao;
    }
}