package student;

import java.math.BigDecimal;

/**
 * Represents a pay stub that contains payment information for an employee.
 * Includes details about net pay, taxes, and provides methods to access and
 * format this information.
 */
public class PayStub implements IPayStub {
    /** The employee associated with this pay stub. */
    private IEmployee employee;
    /** The net pay amount after taxes and deductions. */
    private BigDecimal netPay;
    /** The amount of taxes withheld. */
    private BigDecimal taxes;

    /**
     * Constructs a new PayStub with the specified parameters.
     *
     * @param employee The employee associated with this pay stub
     * @param netPay   The net pay amount after taxes and deductions
     * @param taxes    The amount of taxes withheld
     */
    public PayStub(IEmployee employee, BigDecimal netPay, BigDecimal taxes) {
        this.employee = employee;
        this.netPay = netPay;
        this.taxes = taxes;
    }

    /**
     * @return The net pay amount as a double
     */
    @Override
    public double getPay() {
        return netPay.doubleValue();
    }

    /**
     * @return The taxes paid amount as a double
     */
    @Override
    public double getTaxesPaid() {
        return taxes.doubleValue();
    }

    /**
     * Converts the pay stub information to a CSV format string.
     *
     * @return A CSV string containing employee name, pay amount, taxes paid, YTD
     *         earnings, and YTD taxes
     */
    @Override
    public String toCSV() {
        return String.format("%s,%.2f,%.2f,%.2f,%.2f",
                employee.getName(),
                getPay(),
                getTaxesPaid(),
                employee.getYTDEarnings(),
                employee.getYTDTaxesPaid());
    }

}
