/**
 * Representa o equivalente a uma semana em Dias (Days).
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Week
{
    // Representa uma Semana com uma série de Dias (Days) de segunda a sexta-feira.
    public static final int BOOKABLE_DAYS_PER_WEEK = 5;
    
    // O número da semana de um ano em particular (0-52).
    private final int weekNumber;
    private final Day[] days;

    /**
     * Construtor de objetos da Classe Week.
     * @param weekNumber O número da semana (0-52).
     */
    public Week(int weekNumber)
    {
        this.weekNumber = weekNumber;
        days = new Day[BOOKABLE_DAYS_PER_WEEK];
        int dayInYear = weekNumber * 7 + 1;
        for(int day = 0; day < BOOKABLE_DAYS_PER_WEEK; day++) {
            days[day] = new Day(dayInYear);
            dayInYear++;
        }
    }

    /**
     * Imprime uma lista de compromissos desta semana.
     */
    public void showAppointments()
    {
        System.out.println("*** Week " + weekNumber + " ***");
        for(Day day : days) {
            day.showAppointments();
        }
    }

    /**
     * @param dayInWeek Qual dia (1..BOOKABLE_DAYS_PER_WEEK).
     * @return A instância de Day representada por dayInWeek,
     *         ou null caso esteja fora dos limites.
     */
    public Day getDay(int dayInWeek)
    {
        if(dayInWeek >= 1 && dayInWeek <= BOOKABLE_DAYS_PER_WEEK) {
            return days[dayInWeek - 1];
        }
        else {
            return null;
        }
    }

    /**
     * @return O número da semana (0-52).
     */
    public int getWeekNumber()
    {
        return weekNumber;
    }
}
