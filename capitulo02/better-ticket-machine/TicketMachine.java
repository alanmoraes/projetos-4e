/**
 * TicketMachine modela uma máquina de vender bilhetes que emite bilhetes de
 * passagem simples.
 * O preço de um bilhete é especializado via construtor.
 * As instâncias verificarão para garantir que o usuário só insira a quantidade
 * correta de dinheiro; e só imprimirá um bilhete se for inserido dinheiro
 * suficiente.
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
     * Verifica se a quantia é razoável.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount: " +
                               amount);
        }
    }

    /**
     * Imprime um bilhete se tiver sido inserido dinheiro suficiente, e reduz
     * o saldo atual pelo preço de bilhete. Imprime uma mensagem de erro se
     * for necessário mais dinheiro.
     */
    public void printTicket()
    {
        if(balance >= price) {
            // Simula a impressão de um bilhete.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Atualiza o total coletado com o preço.
            total = total + price;
            // Reduz o saldo pelo preço.
            balance = balance - price;
        }
        else {
            System.out.println("You must insert at least: " +
                               (price - balance) + " more cents.");

        }
    }

    /**
     * Retorna o dinheiro no saldo.
     * O saldo é apagado.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
