/**
 * Mantem os detalhes de alguém participando do leilão.
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class Person
{
    // O nome da pessoa.
    private final String name;

    /**
     * Cria uma nova pessoa com o nome fornecido.
     * @param name O nome da pessoa.
     */
    public Person(String name)
    {
        this.name = name;
    }

    /**
     * @return O nome da pessoa.
     */
    public String getName()
    {
        return name;
    }
}
