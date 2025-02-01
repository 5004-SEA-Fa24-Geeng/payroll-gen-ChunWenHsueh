import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import student.*;

import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {

    String invalidEmplyee;
    String hourlyEmployeeString, salaryEmployeeString;
    String invalidTimeCardString;
    String timeCardString;

    @BeforeEach
    void setUp() {
        hourlyEmployeeString = "HOURLY,Luffy,NEU001,30.0,0,20000,4530";
        salaryEmployeeString = "SALARY,Zoro,NEU002,200000,1000,17017,4983";
    }

    @Test
    void testBuildEmployeeFromCSVWithInvalidInput() {
        invalidEmplyee = "SALARY,Nami,NEU001,200000,1000,17017,abcd";
        IEmployee employee = Builder.buildEmployeeFromCSV(invalidEmplyee);
        assertNull(employee);
        invalidEmplyee = "INVALID,Nami,NEU001,200000,1000,17017,1";
        employee = Builder.buildEmployeeFromCSV(invalidEmplyee);
        assertNull(employee);
    }

    @Test
    void testBuildEmployeeFromCSV() {
        IEmployee hourlyEmployee = Builder.buildEmployeeFromCSV(hourlyEmployeeString);
        assertEquals("Luffy", hourlyEmployee.getName());
        assertEquals("NEU001", hourlyEmployee.getID());
        assertEquals(30.0, hourlyEmployee.getPayRate());
        assertEquals(0.0, hourlyEmployee.getPretaxDeductions());
        assertEquals(20000.0, hourlyEmployee.getYTDEarnings());
        assertEquals(4530.0, hourlyEmployee.getYTDTaxesPaid());

        IEmployee salaryEmployee = Builder.buildEmployeeFromCSV(salaryEmployeeString);
        assertEquals("Zoro", salaryEmployee.getName());
        assertEquals("NEU002", salaryEmployee.getID());
        assertEquals(200000.0, salaryEmployee.getPayRate());
        assertEquals(1000.0, salaryEmployee.getPretaxDeductions());
        assertEquals(17017.0, salaryEmployee.getYTDEarnings());
        assertEquals(4983.0, salaryEmployee.getYTDTaxesPaid());
    }

    @Test
    void testBuildTimeCardFromCSVInvalidInput() {
        invalidTimeCardString = "NEU001,40a";
        ITimeCard timeCard = Builder.buildTimeCardFromCSV(invalidTimeCardString);
        assertNull(timeCard);
        invalidTimeCardString = "NEU001,40,50";
        timeCard = Builder.buildTimeCardFromCSV(invalidTimeCardString);
        assertNull(timeCard);
    }

    @Test
    void testBuildTimeCardFromCSV() {
        String TimeCardString = "NEU001,40";
        ITimeCard timeCard = Builder.buildTimeCardFromCSV(TimeCardString);
        assertEquals("NEU001", timeCard.getEmployeeID());
        assertEquals(40.0, timeCard.getHoursWorked());
    }
}