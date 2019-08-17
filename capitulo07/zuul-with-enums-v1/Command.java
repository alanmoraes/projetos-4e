/**
 * Esta classe é parte da aplicação "Mundo de Zuul".
 * O "Mundo de Zuul" é um jogo de aventura em texto simples.
 *
 * Esta classe mantém informações sobre os comandos que são inseridos pelo usuário.
 * Um comando até aqui consiste de duas strings: Uma palavra de comando e
 * uma segunda palavra (por exemplo, se o comando for "take map" (pegar mapa),
 * então as duas strings são obviamente "take" e "map").
 * 
 * A maneira que isso é usado é: Ao criar uma instância dessa classe,
 * faz-se necessário verificar antes se o comando a ser fornecido é
 * válido. Se o usuário inseriu um comando inválido (isto é, uma palavra
 * que não é conhecida) então a palavra de comando é UNKNOWN.
 *
 * Se o comando contém apenas uma única palavra, então a segunda palavra é <null>.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Command
{
    private String commandWord; // Palavra de comando (primeira palavra)
    private String secondWord; // Palavra auxiliar (segunda palavra)

    /**
     * Cria um objeto Command. A primeira e segunda palavra devem ser fornecidas,
     * mas a segunda pode ser nula.
     * @param commandWord A primeira palavra do comando. UNKNOWN se o comando não
     *                  é reconhecido (isto é, trata-se de um comando inválido).
     * @param secondWord A segunda palavra do comando. Pode ser null.
     */
    public Command(CommandWord commandWord, String secondWord)
    {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    /**
     * Retorna a palavra de comando (a primeira palavra) desta instância de
     * Comando.
     * @return A palavra de comando.
     */
    public CommandWord getCommandWord()
    {
        return commandWord;
    }

    /**
     * @return A segunda palavra deste comando. Retorna null se não há uma
     * segunda palavra.
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * @return true se essa instância representa um comando não reconhecido
     * (isto é, um comando inválido).
     */
    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN);
    }

    /**
     * @return true se esse comando possui uma segunda palavra.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}

