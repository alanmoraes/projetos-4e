import java.util.HashSet;
import java.util.Scanner;

/**
 * InputReader lê a entrada digitada no terminal de texto padrão.
 * O texto digitado pelo usuário é então cortado em palavras, 
 * resultando em uma série de palavras.
 * 
 * @author     Michael Kolling and David J. Barnes
 * @version    1.0
 */
public class InputReader
{
    private Scanner reader;

    /**
     * Cria um novo InputReader que lê palavras digitadas do terminal de texto.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Lê uma linha de texto a partir da entrada padrão (o terminal
     * de texto) e a retorna como um conjunto de palavras.
     *
     * @return  Um conjunto de Strings, em que cada String é uma das
     *          palavras digitadas pelo usuário.
     */
    public HashSet<String> getInput() 
    {
        System.out.print("> ");                // Imprime o prompt
        String inputLine = reader.nextLine().trim().toLowerCase();

        String[] wordArray = inputLine.split(" ");  // Corta entre os espaços

        // adiciona palavras do array no HashSet
        HashSet<String> words = new HashSet<String>();
        for(String word : wordArray) {
            words.add(word);
        }
        return words;
    }
}
