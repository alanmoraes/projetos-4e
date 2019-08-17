import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Esta classe é parte da aplicação "Mundo de Zuul".
 * O "Mundo de Zuul" é um jogo de aventura em texto simples.
 * 
 * Este interpretador (parser) lê a entrada do usuário e tenta -interpretar-
 * como um comando de jogo. Toda vez ao ser chamado, ele lê uma linha do terminal
 * de texto e tenta interpreta-la como um comando de duas palavras. Por fim,
 * retorna um objeto da classe Command.
 *
 * O Parser contém uma série de comandos conhecidos/válidos. Ele verifica a
 * entrada do usuário com essa série; Se a entrada não corresponder a nenhum
 * desses comandos, então é simplesmente retornado um objeto Command marcado
 * como desconhecido (Isto é, cujo comando é nulo. Consulte a classe Command
 * para mais detalhes).
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Parser 
{
    private CommandWords commands;  // Mantém todas as palavras de comando válidas
    private Scanner reader;         // Origem da leitura (terminal de texto)

    /**
     * Cria um Parser para ler do terminal de texto.
     */
    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * @return O próximo comando do usuário.
     */
    public Command getCommand() 
    {
        String inputLine;   // Armazenará a linha inteira digitada pelo usuário
        String word1 = null; // Primeira palavra do comando
        String word2 = null; // Segunda palavra do comando

        System.out.print("> ");     // Imprime o indicador de leitura do terminal

        inputLine = reader.nextLine();

        // Encontra as duas palavras da linha inserida pelo usuário
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // Primeira palavra
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // Segunda palavra
                // nota: nós apenas ignoramos o resto da linha
                // (caso mais de duas palavra seja digitada)
            }
        }

        return new Command(commands.getCommandWord(word1), word2);
    }

    /**
     * Imprime uma lista de palavras de comando válidas.
     */
    public void showCommands()
    {
        commands.showAll();
    }
}
