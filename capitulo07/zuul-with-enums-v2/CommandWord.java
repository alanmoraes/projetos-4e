/**
 * Representações de todas as palavras de comando válidas para o jogo
 * junto com uma string em um determinado idioma.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public enum CommandWord
{
    // Um valor para cada palavra de comando juntamente com sua
    // string correspondente da interface com o usuário.
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?");
    
    // A palvra de comando.
    private String commandString;
    
    /**
     * Inicializa com a palavra de comando correspondente.
     * @param commandWord A palavra de comando.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * @return A palavra de comando como uma string.
     */
    public String toString()
    {
        return commandString;
    }
}
