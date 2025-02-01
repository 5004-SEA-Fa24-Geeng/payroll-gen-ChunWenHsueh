import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import student.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class TimeCardTest {
    private TimeCard timeCard;

    @BeforeEach
    void setUp() {
        timeCard = new TimeCard("NEU001", new BigDecimal("40.00"));
    }

    @Test
    void testGetEmployeeID() {
        assertEquals("NEU001", timeCard.getEmployeeID());
    }

    @Test
    void testGetHoursWorked() {
        assertEquals(40.00, timeCard.getHoursWorked(), 0.01);
    }
}
