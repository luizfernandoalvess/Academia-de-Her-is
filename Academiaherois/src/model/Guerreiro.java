package model;

public class Guerreiro extends Heroi {
    private int forca;
    private int resistencia;
    private int energia;

    public Guerreiro(String nome, int nivel, int vida, int mana, int forca, int resistencia, int energia) {
        super(nome, nivel, vida, mana, "Guerreiro");
        this.forca = forca;
        this.resistencia = resistencia;
        this.energia = energia;
    }

    @Override
    public String getClasse() {
        return "Guerreiro";
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getForca() {
        return forca;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public int getEnergia() {
        return energia;
    }
}