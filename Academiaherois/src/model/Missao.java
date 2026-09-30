package model;

public class Missao {
    private String nome;
    private int dificuldade;
    private double recompensaOuro; 
    private boolean emAndamento;
    private boolean concluida;

    public Missao(String nome, int dificuldade, double recompensaOuro) {
        this.nome = nome;
        this.dificuldade = dificuldade;
        this.recompensaOuro = recompensaOuro;
        this.emAndamento = false;
        this.concluida = false;
    }

    public void iniciarMissao(Heroi heroi) {
        if (concluida) {
            System.out.println("A missão '" + nome + "' já foi concluída anteriormente!");
            return;
        }
        if (emAndamento) {
            System.out.println("A missão '" + nome + "' já está em andamento!");
            return;
        }
        this.emAndamento = true;
        System.out.println("O herói " + heroi.getNome() + " iniciou a missão: " + nome + "!");
    }

    public void concluirMissao(Heroi heroi) {
        if (!emAndamento) {
            System.out.println("A missão '" + nome + "' precisa ser iniciada antes de ser concluída.");
            return;
        }
        if (concluida) {
            System.out.println("A missão '" + nome + "' já foi concluída!");
            return;
        }
        this.emAndamento = false;
        this.concluida = true;
        heroi.adicionarOuro(this.recompensaOuro);
        System.out.println("O herói " + heroi.getNome() + " concluiu a missão com sucesso e recebeu " + recompensaOuro + " de ouro!");
    }

   
    public void setNome(String nome) { this.nome = nome; }

    public int getDificuldade() { 
        return dificuldade; }
    public void setDificuldade(int dificuldade) { 
        this.dificuldade = dificuldade; 
    }

    public double getRecompensaOuro() { 
        return recompensaOuro; }
    public void setRecompensaOuro(double recompensaOuro) { 
        this.recompensaOuro = recompensaOuro; }

    public boolean isConcluida() { 
        return concluida; }
}