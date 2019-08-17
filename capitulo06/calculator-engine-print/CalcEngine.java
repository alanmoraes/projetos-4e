/**
 * A parte principal da calculadora para efetuar os cálculos.
 * Essa versão incorpora algumas impressões de debug em seu código.
 * 
 * @author Hacker T. Largebrain (version 0.1)
 * @version 0.2
 */
public class CalcEngine
{
    // O valor presente no visor.
    private int displayValue;
    // O último operador digitado (+ ou -).
    private char previousOperator;
    // O operando a esquerda de previousOperator.
    private int leftOperand;

    /**
     * Cria uma CalcEngine.
     */
    public CalcEngine()
    {
        displayValue = 0;
        previousOperator = ' ';
        leftOperand = 0;
    }

    /**
     * @return O valor que deve ser corretamente exibido
     * no visor da calculadora.
     */
    public int getDisplayValue()
    {
        return displayValue;
    }

    /**
     * Um botão de um número foi pressionado.
     */
    public void numberPressed(int number)
    {
        System.out.println("numberPressed called with: " +
                           number);
        displayValue = displayValue * 10 + number;
        reportState("end of numberPressed");
    }

    /**
     * O botão 'plus'/'+' foi pressionado.
     */
    public void plus()
    {
        System.out.println("plus called");
        applyPreviousOperator();
        previousOperator = '+';
        displayValue = 0;
        reportState("end of plus");
    }

    /**
     * O botão 'minus'/'-' foi pressionado.
     */
    public void minus()
    {
        applyPreviousOperator();
        previousOperator = '-';
        displayValue = 0;
    }
    
    /**
     * O botão '=' foi pressionado.
     */
    public void equals()
    {
        System.out.println("equals called");
        if(previousOperator == '+') {
            displayValue = leftOperand + displayValue;
        }
        else {
            displayValue = leftOperand - displayValue;
        }
        leftOperand = 0;
        reportState("end of equals");
    }

    /**
     * O botão 'C' (limpar) foi pressionado.
     */
    public void clear()
    {
        System.out.println("clear called");
        displayValue = 0;
        reportState("end of clear");
    }

    /**
     * @return O título deste molde de calculadora.
     */
    public String getTitle()
    {
        return "Super Calculator";
    }

    /**
     * @return O autor deste molde de calculadora.
     */
    public String getAuthor()
    {
        return "Hacker T. Largebrain";
    }

    /**
     * @return O número da versão deste molde de calculadora.
     */
    public String getVersion()
    {
        return "version 0.2";
    }

    /**
     * Imprime os valores dos campos deste objeto.
     * @param where "Quem" chamou esse método.
     */
    public void reportState(String where)
    {
        System.out.println("displayValue: " + displayValue +
                           " leftOperand: " + leftOperand +
                           " previousOperator: " +
                           previousOperator + " at " + where);
    }
    
    /**
     * O botão de um operador foi pressionado.
     * Aplica imediatamente o operador precedente
     * para calcular um resultado intermediário. Isso
     * irá formar o operando esquerdo do novo operador.
     */
    private void applyPreviousOperator()
    {
        System.out.println("applyPreviousOperator called");
        if(previousOperator == '+') {
            leftOperand += displayValue;
        }
        else if(previousOperator == '-') {
            leftOperand -= displayValue;
        }
        else {
            // Não havia um operador precedente.
            leftOperand = displayValue;
        }
        reportState("end of applyPreviousOperator");
    }
}
