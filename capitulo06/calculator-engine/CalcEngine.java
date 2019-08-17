/**
 * A parte principal da calculadora para efetuar os cálculos
 * de lógica aritmética.
 * 
 * @author Hacker T. Largebrain 
 * @version 0.1
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
     * @param number O dígito único.
     */
    public void numberPressed(int number)
    {
        displayValue = displayValue * 10 + number;
    }

    /**
     * O botão 'plus'/'+' foi pressionado.
     */
    public void plus()
    {
        applyPreviousOperator();
        previousOperator = '+';
        displayValue = 0;
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
        if(previousOperator == '+') {
            displayValue = leftOperand + displayValue;
        }
        else {
            displayValue = leftOperand - displayValue;
        }
        leftOperand = 0;
    }

    /**
     * O botão 'C' (limpar) foi pressionado.
     */
    public void clear()
    {
        displayValue = 0;
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
     * O botão de um operador foi pressionado.
     * Aplica imediatamente o operador precedente
     * para calcular um resultado intermediário. Isso
     * irá formar o operando esquerdo do novo operador.
     */
    private void applyPreviousOperator()
    {
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
    }
}
