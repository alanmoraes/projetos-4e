/**
 * Mantém os compromissos de um dia na agenda.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class Day
{
    // As horas iniciais e finais agendáveis em um dia.
    public static final int START_OF_DAY = 9;
    public static final int FINAL_APPOINTMENT_TIME = 17;
    // O número de horas agendáveis em um dia.
    public static final int MAX_APPOINTMENTS_PER_DAY =
                                FINAL_APPOINTMENT_TIME -
                                START_OF_DAY + 1;
    
    // O número do dia em um ano em particular. (1-366)
    private int dayNumber;
    // A lista atual de compromissos durante esse dia.
    private Appointment[] appointments;

    /**
     * Construtor para objetos da classe Day.
     * @param dayNumber O número desse dia no ano (1-366).
     */
    public Day(int dayNumber)
    {
        this.dayNumber = dayNumber;
        appointments = new Appointment[MAX_APPOINTMENTS_PER_DAY];
    }

    /**
     * Tentar encontrar espaço para um compromisso
     * @param appointment O compromisso a ser agendado.
     * @return A primeira hora de hoje que pode acomodar
     *              o compromisso. Retorna -1 se não houver
     *              espaço suficiente.
     */ 
    public int findSpace(Appointment appointment)
    {
        int duration = appointment.getDuration();
        for(int slot = 0; slot < MAX_APPOINTMENTS_PER_DAY; slot++) {
            if(appointments[slot] == null) {
                final int time = START_OF_DAY + slot;
                // Ponto inicial potencial.
                if(duration == 1) {
                    // Somente um único slot necessário.
                    return time;
                }
                else {
                    // Quantos slots mais são necessáios?
                    int further_slots_required = duration - 1;
                    for(int nextSlot = slot + 1;
                                further_slots_required > 0 &&
                                appointments[nextSlot] == null;
                                    nextSlot++) {
                        further_slots_required--;
                    }
                    if(further_slots_required == 0) {
                        // Um espaço grande o suficiente foi encontrado.
                        return time;
                    }
                }
            }
        }
        // Sem espaço suficiente disponível.
        return -1;
    }

    /**
     * Agendar um compromisso.
     * @param time A hora em que o compromisso inicia.
     * @param appointment O compromisso a ser agendado.
     * @return true se o compromisso foi bem-sucedido,
     *         false caso contrário.
     */
    public boolean makeAppointment(int time,
                                   Appointment appointment)
    {
        if(validTime(time)) {
            int startTime = time - START_OF_DAY;
            if(appointments[startTime] == null) {
                int duration = appointment.getDuration();
                // Preenche todos os slots pela duração integral
                // do compromisso.
                for(int i = 0; i < duration; i++) {
                    appointments[startTime + i] = appointment;
                }
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
    
    /**
     * @param time Qual hora do dia. Precisa estar entre
     *        START_OF_DAY e the FINAL_APPOINTMENT_TIME.
     * @return O Appointment na hora especificada.
     *         null é retornado se uma das horas for inválida
     *         ou se não houver nenhum Appointment na hora especificada.
     */
    public Appointment getAppointment(int time)
    {
        if(validTime(time)) {
            return appointments[time - START_OF_DAY];
        }
        else {
            return null;
        }
    }

    /**
     * Imprime uma lista dos compromissos do dia.
     */
    public void showAppointments()
    {
        System.out.println("=== Day " + dayNumber + " ===");
        int time = START_OF_DAY;
        for(Appointment appointment : appointments) {
            System.out.print(time + ": ");
            if(appointment != null) {
                System.out.println(appointment.getDescription());
            }
            else {
                System.out.println();
            }
            time++;
        }
    }

    /**
     * @return O número desse dia no ano (1 - 366).
     */
    public int getDayNumber()
    {
        return dayNumber;
    }
    
    /**
     * @return true se a hora estiver entre START_OF_DAY e
     *         END_OF_DAY, false do contrário.
     */
    public boolean validTime(int time)
    {
        return time >= START_OF_DAY && time <= FINAL_APPOINTMENT_TIME;
    }
}
