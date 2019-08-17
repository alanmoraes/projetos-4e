import java.util.Scanner;

/**
 * InputReader lê a entrada digitada no terminal de texto padrão.
 * O texto digitado pelo usuário é então cortado em palavras, 
 * resultando em uma série de palavras.
 * 
 * @author     Michael Kolling and David J. Barnes
 * @version    0.2
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
     * Lê uma linha de texto da entrada padrão (o terminal de texto),
     * e retorna como uma String.
     *
     * @return  Uma String digitada pelo usuário.
     */
    public String getInput()
    {
        System.out.print("> ");         // Imprime o prompt
        String inputLine = reader.nextLine();

        return inputLine;
    }
}
