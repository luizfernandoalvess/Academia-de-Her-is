package main;
import java.util.Scanner;
import model.*;

public class Main {
    private static Heroi[] herois = new Heroi[20];
    private static int totalHerois = 0;
    private static int totalMissoesConcluidas = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== ACADEMIA DE HEROIS ===");
            System.out.println("1. Cadastrar heroi");
            System.out.println("2. Listar herois");
            System.out.println("3. Buscar heroi pelo nome");
            System.out.println("4. Executar missao");
            System.out.println("5. Exibir relatorio final");
            System.out.println("6. Sair");
            System.out.println("Escolha uma opcao: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    cadastrarHeroi(scanner);
                    break;
                case 2:
                    listarHerois();
                    break;
                case 3:
                    buscarHeroiPorNome(scanner);
                    break;
                case 4:
                    executarMissao(scanner);
                    break;
                case 5:
                    exibirRelatorioFinal();
                    break;
                case 6:
                    System.out.println("A encerrar o programa...");
                    break;
                default:
                    System.out.println("Opcao invalida!");
            }
        } while (opcao != 6);

        scanner.close();
    }

    private static void cadastrarHeroi(Scanner scanner) {
        if (totalHerois >= 20) {
            System.out.println("Capacidade maxima de herois atingida.");
            return;
        }

        System.out.println("Insira o nome do heroi: ");
        String nome = scanner.nextLine();

        System.out.println("Insira o nivel: ");
        int nivel = scanner.nextInt();

        System.out.println("Insira a vida: ");
        int vida = scanner.nextInt();

        System.out.println("Insira a mana: ");
        int mana = scanner.nextInt();

        System.out.println("Escolha a classe: 1- Guerreiro | 2- Arqueiro | 3- Mago");
        int tipo = scanner.nextInt();

        Heroi novoHeroi = null;

        if (tipo == 1) {
            System.out.println("Forca: ");
            int forca = scanner.nextInt();
            System.out.println("Resistencia: ");
            int resistencia = scanner.nextInt();
            System.out.println("Energia: ");
            int energia = scanner.nextInt();

            novoHeroi = new Guerreiro(nome, nivel, vida, mana, forca, resistencia, energia);

        } else if (tipo == 2) {
            System.out.println("Precisao: ");
            int precisao = scanner.nextInt();
            System.out.println("Agilidade: ");
            int agilidade = scanner.nextInt();
            System.out.println("Concentracao: ");
            int concentracao = scanner.nextInt();
            novoHeroi = new Arqueiro(nome, nivel, vida, mana, precisao, agilidade, concentracao);

        } else if (tipo == 3) {
            System.out.println("Poder magico: ");
            int poderMagico = scanner.nextInt();
            System.out.println("Inteligencia: ");
            int inteligencia = scanner.nextInt();

            novoHeroi = new Mago(nome, nivel, vida, mana, poderMagico, inteligencia);
        } else {
            System.out.println("Tipo invalido. Cadastro cancelado.");
            return;
        }

        herois[totalHerois] = novoHeroi;
        totalHerois++;
        System.out.println("Heroi cadastrado com sucesso!");
    }

    public static void listarHerois() {
        System.out.println("\n=== LISTA DE HEROIS ===");
        if (totalHerois == 0) {
            System.out.println("Nenhum heroi cadastrado.");
            return;
        }
        for (int i = 0; i < totalHerois; i++) {
            herois[i].exibirInfo();
        }
    }

    public static void buscarHeroiPorNome(Scanner scanner) {
        System.out.println("Insira o nome do heroi a ser buscado: ");
        String nomeBusca = scanner.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < totalHerois; i++) {
            if (herois[i].getNome().equalsIgnoreCase(nomeBusca)) {
                System.out.println("Heroi encontrado:");
                herois[i].exibirInfo();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Heroi nao encontrado.");
        }
    }

    private static void executarMissao(Scanner scanner) {
        if (totalHerois == 0) {
            System.out.println("Cadastre ao menos um heroi para realizar missoes.");
            return;
        }

        System.out.println("Escolha um heroi pelo indice (0 a " + (totalHerois - 1) + "):");
        listarHerois();
        int idx = scanner.nextInt();
        scanner.nextLine();

        if (idx >= 0 && idx < totalHerois) {
            Heroi h = herois[idx];
            Missao missao = new Missao("Derrotar o Dragao", 5, 150.0);

            missao.iniciarMissao(h);
            missao.concluirMissao(h);

            if (missao.isConcluida()) {
                totalMissoesConcluidas++;
            }
        } else {
            System.out.println("Indice invalido.");
        }
    }

    private static void exibirRelatorioFinal() {
        int guerreiros = 0, magos = 0, arqueiros = 0;
        double somaNiveis = 0;
        Heroi heroiMaisForte = null;

        for (int i = 0; i < totalHerois; i++) {
            Heroi h = herois[i];
            somaNiveis += h.getNivel();

            if (h instanceof Guerreiro) guerreiros++;
            else if (h instanceof Mago) magos++;
            else if (h instanceof Arqueiro) arqueiros++;

            if (heroiMaisForte == null || h.getNivel() > heroiMaisForte.getNivel()) {
                heroiMaisForte = h;
            }
        }

        double mediaNivel = totalHerois > 0 ? somaNiveis / totalHerois : 0;
        String nomeMaisForte = heroiMaisForte != null ? heroiMaisForte.getNome() : "Nenhum";

        System.out.println("\n==== RELATORIO ====");
        System.out.println("Total de Herois: " + totalHerois);
        System.out.println("Quantidade de guerreiros: " + guerreiros);
        System.out.println("Quantidade de magos: " + magos);
        System.out.println("Quantidade de arqueiros: " + arqueiros);
        System.out.printf("Media de nivel: %.2f\n", mediaNivel);
        System.out.println("Heroi mais forte: " + nomeMaisForte);
        System.out.println("Missoes concluidas: " + totalMissoesConcluidas);
    }
}