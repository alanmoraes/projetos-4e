/**
 * Fornece uma demonstração das classes Club e Membership.
 *
 * @author (seu nome)
 * @version (um número de versão ou data)
 */
public class ClubDemo
{
    // variáveis de instância - substitua o exemplo abaixo com as suas
    private Club club;

    /**
     * Construtor para os objetos da classe ClubDemo
     */
    public ClubDemo()
    {
        club = new Club();
    }

    /**
     * Adiciona alguns membros para o clube, e então mosta quantos membros
     * existem.
     * Chamadas adicionais podem ser realizadas caso mais funcionalidades forem
     * implementadas na classe Club.
     */
    public void demo()
    {
        club.join(new Membership("David", 2, 2004));
        club.join(new Membership("Michael", 1, 2004));
        System.out.println("The club has " +
                           club.numberOfMembers() +
                           " members.");
    }
}
