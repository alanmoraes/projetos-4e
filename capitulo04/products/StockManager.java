import java.util.ArrayList;

/**
 * Gerencia o estoque em uma empresa.
 * O estoque é descrito por zero ou mais produtos.
 *
 * @author (seu nome)
 * @version (um número de versão ou data)
 */
public class StockManager
{
    // Uma lista dos produtos.
    private ArrayList<Product> stock;

    /**
     * Inicializa o gerente de estoque.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Adiciona um produto à lista.
     * @param item O item a ser adicionado.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }

    /**
     * Recebe uma entrega de um produto especifico.
     * Aumenta a quantidade do produto pelo valor fornecido.
     *
     * @param id O ID do produto.
     * @param amount A quantidade que deve ser acrescida ao estoque.
     */
    public void delivery(int id, int amount)
    {
    }

    /**
     * Tenta achar um produto em estoque com a ID fornecida.
     * @return O produto ou null se não houver produtos com esta ID.
     */
    public Product findProduct(int id)
    {
        return null;
    }

    /**
     * Localiza um produto pela ID fornecida, e retorna quantos deste item
     * estão em estoque. Se nenhum produto for encontrado, retorna zero.
     *
     * @param id O ID do produto.
     * @return A quantidade deste produto em estoque.
     */
    public int numberInStock(int id)
    {
        return 0;
    }

    /**
     * Imprime os detalhes de todos os produtos.
     */
    public void printProductDetails()
    {
    }
}
