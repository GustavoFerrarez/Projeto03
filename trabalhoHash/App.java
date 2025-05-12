package trabalhoHash;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static int funcaoHash(String palavra, int tam){
        int hash = 13 + palavra.toUpperCase().charAt(0);
        return hash % tam;
    }

    public static boolean buscarPalavra(String palavra, ArrayList<String>[] tabelaHash, int tam){
        int categoria = funcaoHash(palavra, tam);
        return tabelaHash[categoria].contains(palavra);
    }

    public static void main(String[] args) {
        int totalCategorias = 26;
        ArrayList<String>[] tabelaHash = new ArrayList[totalCategorias];
        ArrayList<String> todasPalavras = new ArrayList<>();

        for (int i = 0; i < totalCategorias; i++) {
            tabelaHash[i] = new ArrayList<>();
        }

        System.out.println("Gerar 100 palavras aleatórias: ");
        for (int i = 0; i < 100; i++) {
            String palavra = GeradorPalavras.gerarPalavraAleatoria(3, 10);
            todasPalavras.add(palavra);
            int categoria = funcaoHash(palavra, totalCategorias);
            tabelaHash[categoria].add(palavra);
            System.out.println((i + 1) + ": " + palavra);
        }

        Scanner in = new Scanner(System.in);
        System.out.print("\nDigite uma das palavras: ");
        String palavraBusca = in.nextLine();

        if (buscarPalavra(palavraBusca, tabelaHash, totalCategorias)) {
            System.out.println("Palavra '" + palavraBusca + "' encontrada.");
        } else {
            System.out.println("Palavra '" + palavraBusca + "' não encontrada.");
        }
    }
}
