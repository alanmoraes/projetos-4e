/**
 * A classe principal de uma simples calculadora. Crie uma instância
 * dela e então terá uma calculadora na sua tela.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Calculator
{
    private CalcEngine engine;
    private UserInterface gui;

    /**
     * Cria uma nova calculadora e mostra-a.
     */
    public Calculator()
    {
        engine = new CalcEngine();
        gui = new UserInterface(engine);
    }

    /**
     * Caso a janela tenha sido fechada, mostra-a novamente.
     */
    public void show()
    {
        gui.setVisible(true);
    }
}
