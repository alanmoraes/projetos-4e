/**
 * Uma classe que modela um item (ou conjunto de items) de um leilão: um lote.
 *
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class Lot
{
    // Um número de identificação único.
    private final int number;
    // Uma descrição para esse lote.
    private String description;
    // O lance mais alto para esse lote.
    private Bid highestBid;

    /**
     * Constrói um Lote, definindo seu número e descrição.
     * @param number O número do lote.
     * @param description Uma descrição para esse lote.
     */
    public Lot(int number, String description)
    {
        this.number = number;
        this.description = description;
    }

    /**
     * Tenta arrematar um lote. Um lance bem-sucedido deve ter um valor mais
     * alto do que qualquer lance existente.
     *
     * @param bid O novo lance.
     * @return true, se bem sucedido; false, caso contrário
     */
    public boolean bidFor(Bid bid)
    {
        if((highestBid == null) ||
               (bid.getValue() > highestBid.getValue())) {
            // Este é o melhor lance até agora.
            highestBid = bid;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * @return Uma string representando os dados deste lote.
     */
    public String toString()
    {
        String details = number + ": " + description;
        if(highestBid != null) {
            details += "    Bid: " +
                       highestBid.getValue();
        }
        else {
            details += "    (No bid)";
        }
        return details;
    }

    /**
     * @return O número do Lote.
     */
    public int getNumber()
    {
        return number;
    }

    /**
     * @return A descrição do Lote.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @return O lance mais alto para este Lote.
     *         Pode retornar null se não houver lances.
     */
    public Bid getHighestBid()
    {
        return highestBid;
    }
}
