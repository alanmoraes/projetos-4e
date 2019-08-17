/**
 * Uma classe que modela um item de correio simples. O item possui um endereço de
 * remetente e destinatário e uma string mensagem.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class MailItem
{
    // O remetente do item.
    private String from;
    // O destinatário.
    private String to;
    // O texto da mensagem.
    private String message;

    /**
     * Cria um item de correio de remetente para o destinatário dado contendo
     * a mensagem dada.
     * @param from O remetente desse item.
     * @param to O destinatário desse item.
     * @param message O texto da mensagem a ser enviada.
     */
    public MailItem(String from, String to, String message)
    {
        this.from = from;
        this.to = to;
        this.message = message;
    }

    /**
     * @return O remetente dessa mensagem.
     */
    public String getFrom()
    {
        return from;
    }

    /**
     * @return O destinatário dessa mensagem.
     */
    public String getTo()
    {
        return to;
    }

    /**
     * @return O texto da mensagem.
     */
    public String getMessage()
    {
        return message;
    }

    /**
     * Imprime este item de correio no terminal de output.
     */
    public void print()
    {
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Message: " + message);
    }
}
