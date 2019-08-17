/**
 * A classe DVD representa um objeto DVD. Informações sobre
 * o DVD são armazenadas e podem ser recuperadas.
 * Nós assumimos que lidamos apenas com DVDs de
 * de filmes até então.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class DVD 
{
    private String title; // Título do DVD
    private String director; // Diretor do filme
    private int playingTime; // Tempo de execução do filme
    private boolean gotIt; // Se o usuário possui o disco
    private String comment; // Comentários

    /**
     * Construtor para objetos da classe DVD
     * @param theTitle O título do DVD.
     * @param theDirector O diretor do DVD.
     * @param time O tempo de reprodução do DVD.
     */
    public DVD(String theTitle, String theDirector, int time)
    {
        title = theTitle;
        director = theDirector;
        playingTime = time;
        gotIt = false;
        comment = "<no comment>";
    }

    /**
     * Insere um comentário para esse DVD.
     * @param comment O comentário a ser inserido.
     */
    public void setComment(String comment)
    {
        this.comment = comment;
    }

    /**
     * @return O comentário para esse DVD.
     */
    public String getComment()
    {
        return comment;
    }

    /**
     * Configura a flag que indica se possuímos esse DVD.
     * @param ownIt true se possuímos o DVD, false caso contrário.
     */
    public void setOwn(boolean ownIt)
    {
        gotIt = ownIt;
    }

    /**
     * @return true se possuímos uma cópia desse DVD.
     */
    public boolean getOwn()
    {
        return gotIt;
    }

    /**
     * Imprime detalhes sobre esse DVD no terminal de texto.
     */
    public void print()
    {
        System.out.print("DVD: " + title + " (" + playingTime + " mins)");
        if(gotIt) {
            System.out.println("*");
        }
	else {
            System.out.println();
        }
        System.out.println("    " + director);
        System.out.println("    " + comment);
    }
}
