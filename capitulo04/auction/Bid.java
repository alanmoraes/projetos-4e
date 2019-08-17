/**
 * Uma classe que modela um lance de leilão.
 * Ela contem uma referência para o pessoa que fez o lance e o tamanho do lance.
 *
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class Bid
{
    // A pessoa fazendo o lance.
    private final Person bidder;
    // O valor do lance. Pode ser um valor alto desde que do tipo long.
    private final long value;

    /**
     * Cria um lance.
     * @param bidder Quem esta fazendo o lance para o lote.
     * @param value O valor do lance.
     */
    public Bid(Person bidder, long value)
    {
        this.bidder = bidder;
        this.value = value;
    }

    /**
     * @return Quem fez o lance.
     */
    public Person getBidder()
    {
        return bidder;
    }

    /**
     * @return O valor do lance.
     */
    public long getValue()
    {
        return value;
    }
}
