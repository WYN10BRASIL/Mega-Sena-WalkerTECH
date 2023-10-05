import java.util.Scanner;

public class MegaSenaApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MegaSena megaSena = new MegaSena("src/resultados.csv");
        MegaSena megaSena2 = new MegaSena("src/sorteios.csv");

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Verificar dezenas sorteadas");
            System.out.println("2 - Realizar sorteio aleatório");
            System.out.println("3 - Sair");

            System.out.println(megaSena2);

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    verificarDezenasSorteadas(scanner, megaSena);
                    break;
                case 2:
                    realizarSorteioAleatorio(megaSena);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void verificarDezenasSorteadas(Scanner scanner, MegaSena megaSena) {
        System.out.println("Digite as 6 dezenas separadas por espaços:");
        int[] dezenas = new int[6];
        for (int i = 0; i < 6; i++) {
            dezenas[i] = scanner.nextInt();
        }

        Resultado resultado = megaSena.verificarDezenasSorteadas(dezenas);

        if (resultado != null) {
            System.out.println("Dezenas sorteadas no concurso " + resultado.getConcurso() +
                    " em " + resultado.getData());
        } else {
            System.out.println("As dezenas não foram sorteadas em nenhum concurso.");
        }
    }

    private static void realizarSorteioAleatorio(MegaSena megaSena) {
        int[] dezenasSorteadas = megaSena.sortearDezenasAleatorias();

        System.out.print("Dezenas sorteadas aleatoriamente: ");
        for (int dezena : dezenasSorteadas) {
            System.out.print(dezena + " ");
        }
        System.out.println();
    }
}

