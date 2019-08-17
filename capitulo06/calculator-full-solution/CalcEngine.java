/**
 * A parte principal da calculadora para efetuar os cálculos.
 * 
 * @author  David J. Barnes and Michael Kolling 
 * @version 2008.03.30
 */
public class CalcEngine
{
    // O estado da calculadora é mantido através de três campos:
    //     buildingDisplayValue, haveLeftOperand, and lastOperator.
    
    // Nós já estamos mostrando algum valor no visor, ou o próximo
    // dígito será o primeiro a ser exibido?
    private boolean buildingDisplayValue;
    // Algum operando esquerdo já foi inserido (ou calculado)?
    private boolean haveLeftOperand;
    // O operador mais recente que foi inserido.
    private char lastOperator;

    // O valor atual a ser mostrado no visor.
    private int displayValue;
    // O valor do operando esquerdo, se existir.
    private int leftOperand;

    /**
     * Cria uma CalcEngine.
     */
    public CalcEngine()
    {
        clear();
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
     * Ou inicia um novo operando, ou incorpora este número como
     * o digito menos significante de um número existente no visor.
     * @param number O número pressionado na calculadora.
     */
    public void numberPressed(int number)
    {
        if(buildingDisplayValue) {
            // Incorpora este dígito.
            displayValue = displayValue*10 + number;
        }
        else {
            // Começa a constuir um novo número.
            displayValue = number;
            buildingDisplayValue = true;
        }
    }

    /**
     * O botão 'plus'/'+' foi pressionado.
     */
    public void plus()
    {
        applyOperator('+');
    }

    /**
     * O botão 'minus'/'-' foi pressionado.
     */
    public void minus()
    {
        applyOperator('-');
    }
    
    /**
     * O botão '=' foi pressionado.
     */
    public void equals()
    {
        // Isso deve completar a construção de um segundo operando,
        // então devemos ter certeza de que temos um operando esquerdo,
        // um operador e um operando direito.
        if(haveLeftOperand &&
                lastOperator != '?' &&
                buildingDisplayValue) {
            calculateResult();
            lastOperator = '?';
            buildingDisplayValue = false;
        }
        else {
            keySequenceError();
        }
    }

    /**
     * O botão 'C' (limpar) foi pressionado.
     * Reseta tudo para um estado inicial.
     */
    public void clear()
    {
        lastOperator = '?';
        haveLeftOperand = false;
        buildingDisplayValue = false;
        displayValue = 0;
    }

    /**
     * @return O título deste molde de calculadora.
     */
    public String getTitle()
    {
        return "Java Calculator";
    }

    /**
     * @return O autor deste molde de calculadora.
     */
    public String getAuthor()
    {
        return "David J. Barnes and Michael Kolling";
    }

    /**
     * @return O número da versão deste molde de calculadora.
     */
    public String getVersion()
    {
       return "Version 1.0";
    }

    /**
     * Combina leftOperand, lastOperator, e o valor
     * mostrado no visor atualmente.
     * O resultado é então atribuído a leftOperand
     * e passa a ser exibido no visor.
     */
    private void calculateResult()
    {
        switch(lastOperator) {
            case '+':
                displayValue = leftOperand + displayValue;
                haveLeftOperand = true;
                leftOperand = displayValue;
                break;
            case '-':
                displayValue = leftOperand - displayValue;
                haveLeftOperand = true;
                leftOperand = displayValue;
                break;
            default:
                keySequenceError();
                break;
        }
    }
    
    /**
     * Aplica um operador.
     * @param operator O operador a ser aplicado.
     */
    private void applyOperator(char operator)
    {
        // Se nós não estamos no processo de construir um novo operando
        // então isso é um erro, a não ser que tenhamos acabado de
        // calcular um resultado usando '='.
        if(!buildingDisplayValue &&
                    !(haveLeftOperand && lastOperator == '?')) {
            keySequenceError();
            return;
        }

        if(lastOperator != '?') {
            // Primeiro aplica o operador anterior.
            calculateResult();
        }
        else {
            // O displayValue (valor do visor) passa a ser o operando esquerdo
            // deste novo operador.
            haveLeftOperand = true;
            leftOperand = displayValue;
        }
        lastOperator = operator;
        buildingDisplayValue = false;
    }

    /**
     * Reporta um erro na sequência em que as teclas foram pressionadas.
     */
    private void keySequenceError()
    {
        System.out.println("A key sequence error has occurred.");
        // Reset everything.
        clear();
    }
}
