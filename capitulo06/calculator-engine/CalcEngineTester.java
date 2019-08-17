/**
 * Testa a classe CalcEngine.
 * 
 * @author Hacker T. Largebrain 
 * @version 0.1
 */
public class CalcEngineTester
{
    // O molde de calculadora a ser testado.
    private CalcEngine engine;

    /**
     * Construtor da classe para objetos CalcEngineTester
     */
    public CalcEngineTester()
    {
        engine = new CalcEngine();
    }
    
    /**
     * Testa tudo.
     */
    public void testAll()
    {
        System.out.println("Testing the addition operation.");
        System.out.println("The result is: " + testPlus());
        System.out.println("Testing the subtraction operation.");
        System.out.println("The result is: " + testMinus());
        System.out.println("All tests passed.");
    }

    /**
     * Testa a operação de adição do molde.
     * @return O resultado do cálculo de 3 + 4.
     */
    public int testPlus()
    {
        // Certifica-se de que a calculadora está em seu estado inicial limpo.
        engine.clear();
        // Simula o pressionamento: 3 + 4 =
        engine.numberPressed(3);
        engine.plus();
        engine.numberPressed(4);
        engine.equals();
        // Retorna o resultado, que deve ser 7.
        return engine.getDisplayValue();
    }

    /**
     * Testa a operação de subtração do molde.
     * @return O resultado do cálculo de 9 - 4.
     */
    public int testMinus()
    {
        // Certifica-se de que a calculadora está em seu estado inicial limpo.
        engine.clear();
        // Simula o pressionamento: 9 - 4 =
        engine.numberPressed(9);
        engine.minus();
        engine.numberPressed(4);
        engine.equals();
        // Retorna o resultado, que deve ser 5.
        return engine.getDisplayValue();
    }
}
