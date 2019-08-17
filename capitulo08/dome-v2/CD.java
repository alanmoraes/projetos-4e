/**
 * A classe CD representa um objeto CD de música. Informações sobre o
 * CD são armazenadas e podem ser recuperadas.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class CD extends Item
{
    private String artist; // Artista do CD
    private int numberOfTracks; // Número de faixas

    /**
     * Inicializa o CD.
     * @param theTitle O título do CD.
     * @param theArtist O artista do CD.
     * @param tracks O número de faixas no CD.
     * @param time O tempo de reprodução do CD.
     */
    public CD(String theTitle, String theArtist, int tracks, int time)
    {
        super(theTitle, time);
        artist = theArtist;
        numberOfTracks = tracks;
    }

    /**
     * @return O artista deste CD.
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * @return O número de faixas presentes neste CD.
     */
    public int getNumberOfTracks()
    {
        return numberOfTracks;
    }
}
