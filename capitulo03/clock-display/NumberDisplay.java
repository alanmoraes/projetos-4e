
/**
 * A classe NumberDisplay representa um mostrador digital de números que pode
 * armazenar valores de zero a um determinado limite.
 *
 * O limite pode ser especificado durante a criação do mostrador. Os valores
 * variam de zero (inclusive) a limite -1. Se usado, por exemplo, para os
 * segundos em um relógio digital, o limite seria 60, resultando na exibição
 * de valores de 0 a 59.
 *
 * Quando incrementado, o mostrador muda automaticamente para zero quando
 * alcançar o limite.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class NumberDisplay
{
    private int limit;
    private int value;

    /**
     * Construtor para objetos da classe NumberDisplay
     * Define o limite no qual o mostrador incrementa.
     */
    public NumberDisplay(int rollOverLimit)
    {
        limit = rollOverLimit;
        value = 0;
    }

    /**
     * Retorna o valor atual.
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Retorna o valor do mostrador (isto é, o valor atual como uma String de
     * dois dígitos. Se o valor for menor do que dez, ele será preenchido com
     * um zero à esquerda).
     */
    public String getDisplayValue()
    {
        if(value < 10) {
            return "0" + value;
        }
        else {
            return "" + value;
        }
    }

    /**
     * Configura o valor do mostrador como o novo valor especificado.
     * Se o novo valor for menor que zero ou exceder o limite, não faz nada.
     */
    public void setValue(int replacementValue)
    {
        if((replacementValue >= 0) && (replacementValue < limit)) {
            value = replacementValue;
        }
    }

    /**
     * Incrementa o valor do mostrador por um, mudando para zero se o limite
     * for alcançado.
     */
    public void increment()
    {
        value = (value + 1) % limit;
    }
}
