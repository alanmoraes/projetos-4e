/**
 * Demonstra as classes StockManager e Produto.
 * A demonstração torna-se funcional conforme a classe StockManager é completada.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class StockDemo
{
    // O gerente de estoque.
    private StockManager manager;

    /**
     * Cria um StockManager e o povoa com alguns produtos.
     */
    public StockDemo()
    {
        manager = new StockManager();
        manager.addProduct(new Product(132, "Clock Radio"));
        manager.addProduct(new Product(37,  "Mobile Phone"));
        manager.addProduct(new Product(23,  "Microwave Oven"));
    }

    /**
     * Fornece uma simples demonstracao de como um StockManager pode ser
     * utilizado. Detalhes dos produtos é mostrado, o estoque de um produto é
     * reabastecido e, entao, os detalhes dos produtos sao exibidos novamente.
     */
    public void demo()
    {
        // Mostra os detalhes de todos os produtos.
        manager.printProductDetails();
        // Recebe a remessa de 5 items de um dos produtos.
        manager.delivery(132, 5);
        manager.printProductDetails();
    }

    /**
     * Mostra os detalhes de um produto. Se encontrado, seu nome e quantidade
     * em estoque sao exibidos.
     * @param id O ID do produto para buscar.
     */
    public void showDetails(int id)
    {
        Product product = getProduct(id);
        if(product != null) {
            System.out.println(product.toString());
        }
    }

    /**
     * Vende um item.
     * Mostra o status do produto antes e depois da venda.
     * @param id O ID do produto sendo vendido.
     */
    public void sellProduct(int id)
    {
        Product product = getProduct(id);

        if(product != null) {
            showDetails(id);
            product.sellOne();
            showDetails(id);
        }
    }

    /**
     * Obtem o produto com o ID fornecido.
     * Uma mensagem de erro é exibido se nenhum produto for encontrado.
     * @param id O ID do produto.
     * @return O produto, ou null se nenhum produto for encontrado.
     */
    public Product getProduct(int id)
    {
        Product product = manager.findProduct(id);
        if(product == null) {
            System.out.println("Product with ID: " + id +
                               " is not recognised.");
        }
        return product;
    }

    /**
     * @return O gerente de estoque.
     */
    public StockManager getManager()
    {
        return manager;
    }
}
