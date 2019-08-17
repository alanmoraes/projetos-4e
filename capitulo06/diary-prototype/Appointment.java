/**
 * Armazena detalhes de uma agenda de compromissos.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Appointment
{
    // A descrição do compromisso.
    private String description;
    // A duração (em horas) do compromisso.
    private int duration;

    /**
     * Cria um compromisso com a duração especificada.
     * @param description A descrição do compromisso.
     * @param duration A duração em horas do compromisso.
     */
    public Appointment(String description, int duration)
    {
        this.description = description;
        this.duration = duration;
    }

    /**
     * @return A descrição do compromisso.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * @return A duração (em horas) do compromisso.
     */
    public int getDuration()
    {
        return duration;
    }
}
