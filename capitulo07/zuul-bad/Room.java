/**
 * Classe Room - uma sala em um jogo de aventura.
 *
 * Esta classe é parte da aplicação "Mundo de Zuul".
 * O "Mundo de Zuul" é um jogo de aventura em texto simples.
 *
 * Uma sala (Room) representa uma localização no cenário do jogo. Ela está
 * conectada a outras salas por saídas. As saídas são referenciadas por
 * Norte, Sul, Leste e Oeste. Para cada direção, a sala armazena uma referência
 * (variável) a uma sala vizinha, ou null se não houver saída nessa direção.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Room 
{
    public String description; // Descrição (consulte o construtor)
    public Room northExit; // Saída Norte
    public Room southExit; // Saída Sul
    public Room eastExit; // Saída Leste
    public Room westExit; // Saída Oeste

    /**
     * Cria uma sala definida com o nome "description". Inicialmente,
     * ela não tem nenhuma saída. "description" é algo como "uma
     * cozinha" ou "um pátio".
     * @param description A descrição da sala
     */
    public Room(String description) 
    {
        this.description = description;
    }

    /**
     * Define as saídas dessa sala. Cada direção ou
     * leva a outra sala ou é nula (nenhuma saída encontrada).
     * @param north A saída norte.
     * @param east A saída leste.
     * @param south A saída sul.
     * @param west A saída oeste.
     */
    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
    }

    /**
     * @return Retorna a descrição da sala (a que foi
     * definida no construtor).
     */
    public String getDescription()
    {
        return description;
    }

}
