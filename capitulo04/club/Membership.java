/**
 * Guarda detalhes de um membro do clube.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Membership
{
    // O nome do membro.
    private String name;
    // O mês no qual o membro se associou.
    private int month;
    // O ano no qual o membro se associou.
    private int year;

    /**
     * Construtor para objetos da classe Membership.
     * @param name O nome do membro.
     * @param month O mês que o membro se associou. (1 ... 12)
     * @param year O ano que o membro se associou.
     */
    public Membership(String name, int month, int year)
        throws IllegalArgumentException
    {
        if(month < 1 || month > 12) {
            throw new IllegalArgumentException(
                "Month " + month + " out of range. Must be in the range 1 ... 12");
        }
        this.name = name;
        this.month = month;
        this.year = year;
    }

    /**
     * @return O nome do membro.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return O mês no qual o membro se associou.
     *         Um valor variando de 1 a 12.
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * @return O ano em que o membro se associou.
     */
    public int getYear()
    {
        return year;
    }

    /**
     * @return Uma string representando esta associação.
     */
    public String toString()
    {
        return "Name: " + name +
               " joined in month " +
               month + " of " + year;
    }
}
