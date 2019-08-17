/**
 * TicketMachine modela uma máquina simples de vender bilhetes que emite bilhetes
 * de passagem simples. O preço de um bilhete é especificado via construtor.
 * É uma máquina simples porque confia que seus usuários irão inserir dinheiro
 * suficiente antes de tentar imprimir um bilhete. Também assume que os usuários
 * inserem a quantidade correta.
 *
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class TicketMachine
{
    // O preço de um bilhete desta máquina.
    private int price;
    // A quantia inserida por um cliente até agora.
    private int balance;
    // A quantia total de dinheiro coletada por essa máquina.
    private int total;

    /**
     * Cria uma máqina que emite bilhetes de um preço determinado.
     * Observe que o preço deve ser maior que zero e que não há verificações
     * para assegurar isso.
     */
    public TicketMachine(int ticketCost)
    {
        price = ticketCost;
        balance = 0;
        total = 0;
    }

    /**
     * Retorna o preço de um bilhete.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Retorna a quantia já inserida para o próximo bilhete.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Recebe uma quantia em centavos de um cliente.
     */
    public void insertMoney(int amount)
    {
        balance = balance + amount;
    }

    /**
     * Imprime um bilhete.
     * Atualiza o total coletado e reduz o saldo para zero
     */
    public void printTicket()
    {
        // Simula a impressão de um bilhete.
        System.out.println("##################");
        System.out.println("# The BlueJ Line");
        System.out.println("# Ticket");
        System.out.println("# " + price + " cents.");
        System.out.println("##################");
        System.out.println();

        // Atualiza o total coletado com o saldo.
        total = total + balance;
        // Limpa o saldo.
        balance = 0;
    }
}
