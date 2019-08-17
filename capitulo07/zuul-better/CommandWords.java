/**
 * Esta classe é parte da aplicação "Mundo de Zuul".
 * O "Mundo de Zuul" é um jogo de aventura em texto simples.
 * 
 * Esta classe mantém um conjunto de todas as palavras de comandos
 * conhecidas e válidas desse jogo.
 * É usada para reconhecer os comandos quando eles são inseridos
 * pelo usuário.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class CommandWords
{
    // um array constante que armazena todas as palavras de comando válidas
    private static final String[] validCommands = {
        "go", "quit", "help"
    };

    /**
     * Construtor - inicializa as palavras de comando.
     */
    public CommandWords()
    {
        // nada a fazer no momento...
    }

    /**
     * Verifica se uma dada String é uma palavra de comando válida neste jogo.
     * @return true se a String fornecida é uma palavra de comando válida,
     * false caso contrário.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // Se chegarmos a este ponto, a String não foi encontrada em validCommands
        return false;
    }

    /**
     * Imprimir todos os comandos válidos para System.out.
     */
    public void showAll() 
    {
        for(String command: validCommands) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
