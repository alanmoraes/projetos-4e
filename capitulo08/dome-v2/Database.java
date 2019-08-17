import java.util.ArrayList;

/**
 * A classe database fornece um recurso para armazenar objetos de
 * entretenimento (Item). Uma lista de todos os itens pode ser impressa
 * no terminal de saída.
 * 
 * Essa versão não salva os dados no disco e
 * não fornece nenhuma função de pesquisa.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Database
{
    private ArrayList<Item> items; // Lista de itens

    /**
     * Constrói um banco de dados vazio.
     */
    public Database()
    {
        items = new ArrayList<Item>();
    }

    /**
     * Adiciona um item ao banco de dados.
     * @param theItem O item a ser adicionado.
     */
    public void addItem(Item theItem)
    {
        items.add(theItem);
    }

    /**
     * Imprime uma lista de todos os itens atualmente armazenados
     * no terminal de texto.
     */
    public void list()
    {
        for(Item item : items) {
            item.print();
            System.out.println();   // linha vazia entre itens
        }
    }
}
