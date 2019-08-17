/**
 * Uma classe que modela um simples cliente de email. O cliente é executado por
 * um usuário, e envia e recebe emails através de um determinado servidor.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class MailClient
{
    // O servidor utilizado para enviar e receber items.
    private MailServer server;
    // O usuário executando esse cliente.
    private String user;

    /**
     * Cria um cliente executado pelo usuário e acoplado ao servidor de
     * correspondências fornecido.
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
    }

    /**
     * Retorna o próximo item de correio (se algum) para este usuário.
     */
    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }

    /**
     * Imprime no terminal o póximo item de correio (se algum) para este usuário.
     */
    public void printNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        if(item == null) {
            System.out.println("No new mail.");
        }
        else {
            item.print();
        }
    }

    /**
     * Envia uma mensagem para o destinatário através do servidor acoplado.
     * @param to O destinatário
     * @param message O texto da mensagem a ser enviada.
     */
    public void sendMailItem(String to, String message)
    {
        MailItem item = new MailItem(user, to, message);
        server.post(item);
    }
}
