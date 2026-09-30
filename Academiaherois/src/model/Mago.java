package model;

public class Mago extends Heroi {
    private int poderMagico;
    private int inteligencia;

    public Mago(String nome, int nivel, int vida, int mana, int poderMagico, int inteligencia) {
        super(nome, nivel, vida, mana, "Mago");
        this.poderMagico = poderMagico;
        this.inteligencia = inteligencia;
    }

    @Override
    public String getClasse() {
        return "Mago";
    }

    public void setPoderMagico(int poderMagico) {
        this.poderMagico = poderMagico;
    }

    public int getPoderMagico() {
        return poderMagico;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getInteligencia() {
        return inteligencia;
    }
}