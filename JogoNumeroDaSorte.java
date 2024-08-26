import java.util.Random;
import java.util.Scanner;

public class JogoNumeroDaSorte {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random randomizacao = new Random();
        int numeroDaSorte = randomizacao.nextInt(100); // Gera um número entre 0 e 99
        
        // Solicita o nome do usuário
        System.out.print("Digite seu nome completo: ");
        String nomeCompleto = scanner.nextLine();
        
        // Inicialização do jogo
        int tentativas = 0;
        boolean acertou = false;

        while (!acertou) {
            // Valida e lê o palpite do usuário
            System.out.print("Qual é o seu número da sorte? ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida! Por favor, digite um número inteiro.");
                scanner.next(); // Limpa a entrada inválida
            }
            int palpite = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha restante após nextInt()
            tentativas++;

            if (palpite == numeroDaSorte) {
                acertou = true;
                System.out.println("Parabéns, " + nomeCompleto + "! Você acertou o número da sorte!");
                System.out.println("Você precisou de " + tentativas + " tentativa(s).");
            } else if (palpite < numeroDaSorte) {
                System.out.println("Dica: O número da sorte é maior que " + palpite + ". Tente novamente.");
            } else {
                System.out.println("Dica: O número da sorte é menor que " + palpite + ". Tente novamente.");
            }

            if (!acertou) {
                System.out.print("Você deseja continuar tentando? (s/n): ");
                String continuar = scanner.nextLine();
                if (continuar.equalsIgnoreCase("n")) {
                    System.out.println("Obrigado por jogar, " + nomeCompleto + "! O número da sorte era " + numeroDaSorte + ".");
                    break;
                }
            }
        }

        scanner.close();
    }
}
