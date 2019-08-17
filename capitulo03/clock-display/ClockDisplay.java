
/**
 * A classe ClockDisplay implementa o mostrador de um relógio digital para um
 * estilo europeu de relógio de 24 horas. O relógio mostra horas e minutos.
 * O intervalo do relógio é de 00:00 (meia-noite) a 23:59 (um minuto antes da
 * meia-noite).
 *
 * O mostrador do relógio recebe "tiques" (pelo método timeTick) a cada minuto
 * e reage incrementando o mostrador. Isso é feito no estilo de relógio comum:
 * a hora incrementa quando os minutos retornam a zero.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String displayString;    // simula o mostrador real

    /**
     * Construtor para objetos ClockDisplay. Esse construtor
     * cria um novo relógio ajustado em 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Construtor para objetos ClockDisplay. Esse construtor
     * cria um novo relógio ajustado com a hora especificada pelos parâmetros.
     */
    public ClockDisplay(int hour, int minute)
    {
        hours = new NumberDisplay(24);
        minutes = new NumberDisplay(60);
        setTime(hour, minute);
    }

    /**
     * Esse método deve ser chamado uma vez por minuto - ele faz o mostrador
     * do relógio avançar um minuto.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // acaba de voltar a zero!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Configura o tempo do mostrador com a hora e o minuto especificados.
     */
    public void setTime(int hour, int minute)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Retorna a hora atual desse mostrador no formato HH:MM
     */
    public String getTime()
    {
        return displayString;
    }

    /**
     * Atualiza a string interna que representa o mostrador.
     */
    private void updateDisplay()
    {
        displayString = hours.getDisplayValue() + ":" +
                        minutes.getDisplayValue();
    }
}
