/**
 * Realiza testes da classe Day que envolvem
 * o agendamento de compromissos de uma hora.
 * 
 * @author David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class OneHourTests
{
    // O objeto Day sendo testado.
    private Day day;

    /**
     * Constutor para objetos de OneHourTests
     */
    public OneHourTests()
    {
        // Cria um objeto Day que será usado nos testes.
        // Os métodos individuais podem optar por criar
        // sua própria instância.
        day = new Day(1);
    }

    /**
     * Testa a funcionalidade básica reservando no fim
     * de um dia e no meio do dia.
     */
    public void makeThreeAppointments()
    {
        // Inicia com um objeto Day recente.
        day = new Day(1);
        // Cria três compromissos de uma hora.
        Appointment first = new Appointment("Java lecture", 1);
        Appointment second = new Appointment("Java class", 1);
        Appointment third = new Appointment("Meet John", 1);
        
        // Agenda cada compromisso em uma hora diferente.
        day.makeAppointment(9, first);
        day.makeAppointment(13, second);
        day.makeAppointment(17, third);
        
        day.showAppointments();
    }
    
    /**
     * Verifica se a reserva dupla não é permitida.
     */
    public void testDoubleBooking()
    {
        // Configura o dia com três compromissos legítimos.
        makeThreeAppointments();
        Appointment badAppointment = new Appointment("Error", 1);
        day.makeAppointment(9, badAppointment);
        
        // Mostra que o badAppointment não foi feito.
        day.showAppointments();
    }

    /**
     * Testa a funcionalidade básica preenchendo um
     * dia inteiro com compromissos.
     */
    public void fillTheDay()
    {
        // Inicia com um objeto Day recente.
        day = new Day(1);
        for(int time = Day.START_OF_DAY;
                    time <= Day.FINAL_APPOINTMENT_TIME;
                        time++) {
            day.makeAppointment(time,
                                new Appointment("Test " + time, 1));
        }
        
        day.showAppointments();
    }
}
