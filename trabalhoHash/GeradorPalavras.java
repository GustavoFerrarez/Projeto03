package trabalhoHash;

import java.util.Random;

public class GeradorPalavras {

    public static String gerarPalavraAleatoria(int tamanhoMin, int tamanhoMax) {
        Random random = new Random();
        int tamanho = random.nextInt(tamanhoMax - tamanhoMin + 1) + tamanhoMin;
        StringBuilder palavra = new StringBuilder(tamanho);

        for (int i = 0; i < tamanho; i++) {
            char letra = (char) (random.nextInt(26) + 97);
            palavra.append(letra);
        }

        return palavra.toString();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(gerarPalavraAleatoria(3, 10));
        }
    }
}







