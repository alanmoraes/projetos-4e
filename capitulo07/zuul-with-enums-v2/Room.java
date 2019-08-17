import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Classe Room - uma sala em um jogo de aventura.
 *
 * Esta classe é parte da aplicação "Mundo de Zuul".
 * O "Mundo de Zuul" é um jogo de aventura em texto simples.
 *
 * Uma sala (Room) representa uma localização no cenário do jogo. Ela está
 * conectada a outras salas por saídas.  Para cada direção,
 * a sala armazena uma referência (variável) a uma sala vizinha.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Room 
{
    private String description;            // Descrição (consulte o construtor)
    private HashMap<String, Room> exits;        // armazena as saídas das salas

    /**
     * Cria uma sala definida com o nome "description". Inicialmente,
     * ela não tem nenhuma saída. "description" é algo como "uma
     * cozinha" ou "um pátio".
     * @param description A descrição da sala
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }

    /**
     * Define uma saída dessa sala.
     * @param direction A direção da saída.
     * @param neighbor  A classe room na direção especificada.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return A descrição curta da sala.
     * (aquela que é definida no construtor da classe).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Retorna uma descrição longa desse quarto, na forma:
     *     You are in the kitchen.
     *     Exits: north west
     * @return Uma descrição do quarto, incluíndo saídas
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Retorna uma descrição das saídas da sala,
     * por exemplo, "Exits: north west".
     * @return Uma descrição das saídas disponíveis.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Retorna a sala que é alcançada se sairmos desta
     * sala na direção "direction". Se não houver nenhuma sala nessa
     * direção, retorna nulo.
     * @param direction A direção de saída.
     * @return A sala na especificada direção.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

