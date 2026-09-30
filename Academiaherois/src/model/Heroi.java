package model;

public abstract class Heroi {
    private String nome;
    private int nivel;
    private int vida;
    private int mana;
    private String classePersonagem;
    private double ouro;

    public Heroi(String nome, int nivel, int vida, int mana, String classePersonagem) {
        this.nome = nome;
        this.nivel = nivel;
        this.vida = vida;
        this.mana = mana;
        this.classePersonagem = classePersonagem;
        this.ouro = 0.0;
    }

    public void adicionarOuro(double quantidade) {
        this.ouro += quantidade;
    }

    public void subirNivel() {
        this.nivel++;
    }

  
    public abstract String getClasse();

    public void exibirInfo() {
        System.out.println("[" + getClasse() + "] " + nome + " | Nível: " + nivel +
                " | Vida: " + vida + " | Mana: " + mana + " | Ouro: " + ouro);
    }


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }

    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }

    public int getMana() { return mana; }
    public void setMana(int mana) { this.mana = mana; }

    public String getClassePersonagem() { return classePersonagem; }
    public void setClassePersonagem(String classePersonagem) { this.classePersonagem = classePersonagem; }
}