import java.util.*;

public class JogoDasPalavras {

    // Um array de palavras válidas para o jogo
    private static String[] palavras = {"amor", "bola", "casa", "dado", "elefante", "faca", "gato", "hora", "ilha", "jogo", "kilo", "lago", "mala", "nada", "ovo", "pato", "queijo", "rato", "sala", "taco", "uva", "vaca", "xale", "zona"};

    // Um gerador de números aleatórios
    private static Random random = new Random();

    // Um scanner para ler a entrada do usuário
    private static Scanner scanner = new Scanner(System.in);

    // Um tempo limite para o jogo em milissegundos
    private static long tempoLimite = 60000; // 1 minuto

    public static void main(String[] args) {
        // Sortear uma palavra aleatória
        String palavra = palavras[random.nextInt(palavras.length)];

        // Criar um conjunto para armazenar as letras digitadas pelo usuário
        Set<Character> letrasDigitadas = new HashSet<>();

        // Criar uma variável para contar o número de letras acertadas
        int contador = 0;

        // Mostrar as instruções do jogo
        System.out.println("Bem-vindo ao jogo das quantas palavras diferentes eu conheço!");
        System.out.println("O jogo consiste em digitar todas as letras que compõem uma determinada palavra.");
        System.out.println("Apenas são permitidas letras válidas e diferentes.");
        System.out.println("Caso você digite uma letra repetida, o jogo irá avisar.");
        System.out.println("O jogo termina após um determinado tempo ou se você digitar a palavra 'fim'.");
        System.out.println("A palavra sorteada tem " + palavra.length() + " letras.");
        System.out.println("Digite as letras que compõem essa palavra:");

        // Obter o tempo inicial do jogo
        long tempoInicial = System.currentTimeMillis();

        // Criar um loop para ler as letras do usuário
        while (true) {
            // Obter o tempo atual do jogo
            long tempoAtual = System.currentTimeMillis();

            // Verificar se o tempo limite foi excedido
            if (tempoAtual - tempoInicial > tempoLimite) {
                // Mostrar uma mensagem de fim de jogo
                System.out.println("O tempo acabou!");
                break;
            }

            // Ler uma letra do usuário
            String letra = scanner.nextLine().toLowerCase();

            // Verificar se o usuário digitou a palavra 'fim'
            if (letra.equals("fim")) {
                // Mostrar uma mensagem de fim de jogo
                System.out.println("Você encerrou o jogo!");
                break;
            }

            // Verificar se a letra tem 1 caractere
            if (letra.length() != 1) {
                // Mostrar uma mensagem de erro
                System.out.println("Você deve digitar apenas uma letra!");
                continue;
            }

            // Verificar se a letra já foi digitada
            if (letrasDigitadas.contains(letra.charAt(0))) {
                // Mostrar uma mensagem de aviso
                System.out.println("Você já digitou essa letra!");
                continue;
            }

            // Verificar se a letra faz parte da palavra
            if (palavra.contains(letra)) {
                // Incrementar o contador de letras acertadas
                contador++;
            }

            // Adicionar a letra ao conjunto de letras digitadas
            letrasDigitadas.add(letra.charAt(0));
        }

        // Mostrar o resultado do jogo
        System.out.println("Você digitou " + contador + " letras válidas e diferentes que compõem a palavra " + palavra + ".");
        System.out.println("As letras que você digitou foram: " + letrasDigitadas);
    }
}
