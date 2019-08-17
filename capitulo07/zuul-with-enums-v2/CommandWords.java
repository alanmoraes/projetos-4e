import java.util.HashMap;

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
    // Um mapeamento entre a palavra do comando e
    // a CommandWord associada a ela.
    private HashMap<String, CommandWord> validCommands;

    /**
     * Construtor - inicializa as palavras de comando.
     */
    public CommandWords()
    {
        validCommands = new HashMap<String, CommandWord>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    /**
     * Encontra a CommandWord associada a "commandWord"
     * @param commandWord A palavra de comando a ser procurada.
     * @return A CommandWord correspondente a commandWord,
     *         ou UNKNOWN se não for uma palavra válida.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    /**
     * Verifica se uma dada String é uma palavra de comando válida neste jogo.
     * @return true se a String fornecida é uma palavra de comando válida,
     * false caso contrário.
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }

    /**
     * Imprimir todos os comandos válidos para System.out.
     */
    public void showAll() 
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
