/**
 * A classe DVD representa um objeto DVD. Informações sobre
 * o DVD são armazenadas e podem ser recuperadas.
 * Nós assumimos que lidamos apenas com DVDs de
 * de filmes até então.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class DVD extends Item 
{
    private String director; // Diretor do filme

    /**
     * Construtor para objetos da classe DVD
     * @param theTitle O título do DVD.
     * @param theDirector O diretor do DVD.
     * @param time O tempo de reprodução do DVD.
     */
    public DVD(String theTitle, String theDirector, int time)
    {
        super(theTitle, time);
        director = theDirector;
    }

    /**
     * @return O diretor deste filme/DVD.
     */
    public String getDirector()
    {
        return director;
    }
}
