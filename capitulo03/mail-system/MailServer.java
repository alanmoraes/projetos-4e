import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * Um simples modelo de um servidor de correspondências. O servidor é capaz de receber
 * items de correio para armazenamento e os envia para os clientes conforme
 * a demanda.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class MailServer
{
    // Armazenamento para o número arbitrário de emails a ser armazenado
    // no servidor.
    private List<MailItem> items;

    /**
     * Constrói o servidor de correspondências.
     */
    public MailServer()
    {
        items = new ArrayList<MailItem>();
    }

    /**
     * Retorna quantos items de correio estão em espera para um usuário.
     * @param who O usuário para o qual checar.
     * @return Quantos items estão em espera.
     */
    public int howManyMailItems(String who)
    {
        int count = 0;
        for(MailItem item : items) {
            if(item.getTo().equals(who)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Retorna o próximo item para um usuário ou null se não há items.
     * @param who O usuário solicitando o próximo item.
     * @return O próximo item do usuário.
     */
    public MailItem getNextMailItem(String who)
    {
        Iterator<MailItem> it = items.iterator();
        while(it.hasNext()) {
            MailItem item = it.next();
            if(item.getTo().equals(who)) {
                it.remove();
                return item;
            }
        }
        return null;
    }

    /**
     * Adiciona o item fornecido à lista de mensagens.
     * @param item O item a ser armazenado no servidor.
     */
    public void post(MailItem item)
    {
        items.add(item);
    }
}
