/**
 * A classe CD representa um objeto CD de música. Informações sobre o
 * CD são armazenadas e podem ser recuperadas.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class CD
{
    private String title; // Título do CD
    private String artist; // Artista do CD
    private int numberOfTracks; // Número de faixas
    private int playingTime; // Tempo de reprodução
    private boolean gotIt; // Se o usuário possui o disco
    private String comment; // Comentários

    /**
     * Inicializa o CD.
     * @param theTitle O título do CD.
     * @param theArtist O artista do CD.
     * @param tracks O número de faixas no CD.
     * @param time O tempo de reprodução do CD.
     */
    public CD(String theTitle, String theArtist, int tracks, int time)
    {
        title = theTitle;
        artist = theArtist;
        numberOfTracks = tracks;
        playingTime = time;
        gotIt = false;
        comment = "<no comment>";
    }

    /**
     * Insere um comentário para esse CD.
     * @param comment O comentário a ser inserido.
     */
    public void setComment(String comment)
    {
        this.comment = comment;
    }

    /**
     * @return O comentário para esse CD.
     */
    public String getComment()
    {
        return comment;
    }

    /**
     * Configura a flag que indica se possuímos esse CD.
     * @param ownIt true se possuímos o CD, false caso contrário.
     */
    public void setOwn(boolean ownIt)
    {
        gotIt = ownIt;
    }

    /**
     * @return true se possuímos uma cópia desse CD.
     */
    public boolean getOwn()
    {
        return gotIt;
    }

    /**
     * Imprime detalhes sobre esse CD no terminal de texto.
     */
    public void print()
    {
        System.out.print("CD: " + title + " (" + playingTime + " mins)");
        if(gotIt) {
            System.out.println("*");
        }
        else {
            System.out.println();
        }
        System.out.println("    " + artist);
        System.out.println("    tracks: " + numberOfTracks);
        System.out.println("    " + comment);
    }
}
