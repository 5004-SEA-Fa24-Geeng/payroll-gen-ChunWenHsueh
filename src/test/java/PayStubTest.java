import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import student.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class PayStubTest {
    private PayStub payStub;
    private IEmployee employee;

    @BeforeEach
    void setUp() {
        employee = new HourlyEmployee(
                "Test Employee",
                "NEU001",
                new BigDecimal("20.00"),
                new BigDecimal("0.00"),
                new BigDecimal("1000.00"),
                new BigDecimal("200.00"));
        payStub = new PayStub(employee, new BigDecimal("800.00"), new BigDecimal("200.00"));
    }

    @Test
    void testGetPay() {
        assertEquals(800.00, payStub.getPay(), 0.01);
    }

    @Test
    void testGetTaxesPaid() {
        assertEquals(200.00, payStub.getTaxesPaid(), 0.01);
    }

    @Test
    void testToCSV() {
        String expected = "Test Employee,800.0,200.0,1000.0,200.0";
        assertEquals(expected, payStub.toCSV());
    }
}
