/**
 * Esta classe Item representa um item de multimídia.
 * Informações sobre o item são armazenadas e podem ser recuperadas.
 * Esta classe serve como uma superclasse para itens mais específicos.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Item
{
    private String title; // Título
    private int playingTime; // Tempo de execução
    private boolean gotIt; // Se o usuário possui o item
    private String comment; // Comentários

    /**
     * Inicializa os campos do item.
     * @param theTitle O título desse item.
     * @param time O tempo de reprodução desse item.
     */
    public Item(String theTitle, int time)
    {
        title = theTitle;
        playingTime = time;
        gotIt = false;
        comment = "";
    }

    /**
     * Insere um comentário para esse item.
     * @param comment O comentário a ser inserido.
     */
    public void setComment(String comment)
    {
        this.comment = comment;
    }

    /**
     * @return O comentário para este item.
     */
    public String getComment()
    {
        return comment;
    }

    /**
     * Configura a flag que indica se possuímos esse ttem.
     * @param ownIt true se possuímos o item, false caso contrário.
     */
    public void setOwn(boolean ownIt)
    {
        gotIt = ownIt;
    }

    /**
     * @return true se possuímos uma cópia desse item.
     */
    public boolean getOwn()
    {
        return gotIt;
    }

    /**
     * Imprime detalhes sobre esse item no terminal de texto.
     */
    public void print()
    {
        System.out.print("title: " + title + " (" + playingTime + " mins)");
        if(gotIt) {
            System.out.println("*");
        } else {
            System.out.println();
        }
        System.out.println("    " + comment);
    }
}
