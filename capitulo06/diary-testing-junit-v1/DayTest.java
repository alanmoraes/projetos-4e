/**
 * Classe de teste DayTest.
 *
 * @author  David J. Barnes and Michael Kolling
 * @version 2008.03.30
 */
public class DayTest extends junit.framework.TestCase
{
    /**
     * Construtor padrão para a classe de teste DayTest
     */
    public DayTest()
    {
    }

    /**
     * Configura a fixture de teste.
     *
     * Chamada antes de cada método de caso de teste.
     */
    protected void setUp()
    {
    }

    /**
     * Encerra a fixture de teste.
     *
     * Chamada depois de cada método de caso de teste.
     */
    protected void tearDown()
    {
    }

    /**
     * Testa funcionalidades básicas ao marcar compromissos
     * no meio e ao fim de um dia.
     */
    public void testMakeThreeAppointments()
    {
        Day day1 = new Day(1);
        Appointment appointm1 = new Appointment("Java lecture", 1);
        Appointment appointm2 = new Appointment("Java class", 1);
        Appointment appointm3 = new Appointment("Meet John", 1);
        assertEquals(true, day1.makeAppointment(9, appointm1));
        assertEquals(true, day1.makeAppointment(13, appointm2));
        assertEquals(true, day1.makeAppointment(17, appointm3));
    }

    /**
     * Certifica-se de que a marcação dupla do mesmo compromisso não é permitida.
     */
    public void testDoubleBooking()
    {
        Day day1 = new Day(1);
        Appointment appointm1 = new Appointment("Java lecture", 1);
        Appointment appointm2 = new Appointment("Error", 1);
        assertEquals(true, day1.makeAppointment(9, appointm1));
        assertEquals(false, day1.makeAppointment(9, appointm2));
    }
}


