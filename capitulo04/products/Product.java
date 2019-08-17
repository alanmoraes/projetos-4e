/**
 * Modela detalhes sobre um produto vendido por uma companhia.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Product
{
    // Um número de identificação para este produto.
    private int id;
    // O nome deste produto.
    private String name;
    // A quantidade deste produto em estoque.
    private int quantity;

    /**
     * Construtor para objetos da classe Product.
     * A quantidade inicial em estoque é zero.
     *
     * @param id O número de identificação do produto.
     * @param name O nome do produto.
     */
    public Product(int id, String name)
    {
        this.id = id;
        this.name = name;
        quantity = 0;
    }

    /**
     * @return O id do produto.
     */
    public int getID()
    {
        return id;
    }

    /**
     * @return O nome do produto.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return A quantidade em estoque.
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     * @return O id, nome e quantidade em estoque.
     */
    public String toString()
    {
        return id + ": " +
               name +
               " stock level: " + quantity;
    }

    /**
     * Abastece o estoque deste produto com a quantidade fornecida.
     * A quantidade atual é incrementada pelo valor fornecido.
     *
     * @param amount O número de novos items adicionados ao estoque.
     *               O valor deve ser maior que zero.
     */
    public void increaseQuantity(int amount)
    {
        if(amount > 0) {
            quantity += amount;
        }
        else {
            System.out.println("Attempt to restock " +
                               name +
                               " with a non-positive amount: " +
                               amount);
        }
    }

    /**
     * Vende um item deste produto.
     * Um erro é reportado se não houver produtos no estoque.
     *
     */
    public void sellOne()
    {
        if(quantity > 0) {
            quantity--;
        }
        else {
            System.out.println(
                "Attempt to sell an out of stock item: " + name);
        }
    }
}
