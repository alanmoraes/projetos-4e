import java.util.ArrayList;

/**
 * Um modelo simples de um leilão.
 * O leilão mantém uma lista dos lotes com um comprimento arbitrário.
 *
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class Auction
{
    // A lista de lotes neste leilão.
    private ArrayList<Lot> lots;
    // O número que será dado ao próximo lote inserido neste leilão.
    private int nextLotNumber;

    /**
     * Cria um novo leilão.
     */
    public Auction()
    {
        lots = new ArrayList<Lot>();
        nextLotNumber = 1;
    }

    /**
     * Insere um novo lote no leilão.
     * @param description Uma descrição do lote.
     */
    public void enterLot(String description)
    {
        lots.add(new Lot(nextLotNumber, description));
        nextLotNumber++;
    }

    /**
     * Mostra a lista completa dos lotes nesse leilão.
     */
    public void showLots()
    {
        for(Lot lot : lots) {
            System.out.println(lot.toString());
        }
    }

    /**
     * Lance para um lote.
     * Uma mensagem indicando se o lance foi ou não bem-sucedido é impressa.
     * @param number O número do lote que recebe um lance.
     * @param bidder A pessoa que dá um lance pelo lote.
     * @param value  O valor do lance.
     */
    public void bidFor(int lotNumber, Person bidder, long value)
    {
        Lot selectedLot = getLot(lotNumber);
        if(selectedLot != null) {
            boolean successful = selectedLot.bidFor(new Bid(bidder, value));
            if(successful) {
                System.out.println("The bid for lot number " +
                                   lotNumber + " was successful.");
            }
            else {
                // Informa qual é o lance mais alto.
                Bid highestBid = selectedLot.getHighestBid();
                System.out.println("Lot number: " + lotNumber +
                                   " already has a bid of: " +
                                   highestBid.getValue());
            }
        }
    }

    /**
     * Retorna o lote com o número dado. Retorna nulo se um lote com esse número
     * não existir.
     * @param lotNumber O número do lote a retornar.
     */
    public Lot getLot(int lotNumber)
    {
        if((lotNumber >= 1) && (lotNumber < nextLotNumber)) {
            // O número parece ser razoável.
            Lot selectedLot = lots.get(lotNumber - 1);
            // Inclui uma verificação de segurança para garantir que temos
            // o lote correto.
            if(selectedLot.getNumber() != lotNumber) {
                System.out.println("Internal error: Lot number " +
                                   selectedLot.getNumber() +
                                   " was returned instead of " +
                                   lotNumber);
                // Não retorne um lot inválido.
                selectedLot = null;
            }
            return selectedLot;
        }
        else {
            System.out.println("Lot number: " + lotNumber +
                               " does not exist.");
            return null;
        }
    }
}
