package student;

import java.math.BigDecimal;

/**
 * This abstract class implements the IEmployee interface and provides base
 * functionality
 * for different types of employees in the payroll system. It handles common
 * operations
 * such as storing employee information and calculating taxes.
 */
public abstract class AbstractEmployee implements IEmployee {
    /** The name of the employee. */
    private String name;
    /** The unique identifier of the employee. */
    private String id;
    /** The pay rate of the employee (hourly rate or salary). */
    private BigDecimal payRate;
    /** The pretax deductions amount for the employee. */
    private BigDecimal pretaxDeductions;
    /** The year-to-date earnings of the employee. */
    private BigDecimal ytdEarnings;
    /** The year-to-date taxes paid by the employee. */
    private BigDecimal ytdTaxesPaid;
    /** The type of employee (HOURLY or SALARY). */
    private EmployeeType employeeType;

    /**
     * The tax rate used to calculate taxes.
     */
    private static final BigDecimal TAX_RATE = new BigDecimal(0.2265);

    protected AbstractEmployee(
            String name,
            String id,
            BigDecimal payRate,
            BigDecimal pretaxDeductions,
            BigDecimal ytdEarnings,
            BigDecimal ytdTaxesPaid,
            EmployeeType employeeType) {
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
        this.employeeType = employeeType;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getID() {
        return id;
    }

    @Override
    public double getPayRate() {
        return payRate.doubleValue();
    }

    /**
     * @return The pay rate as a BigDecimal
     */
    public BigDecimal getPayRateBigDecimal() {
        return payRate;
    }

    @Override
    public String getEmployeeType() {
        return employeeType.name();
    }

    @Override
    public double getYTDEarnings() {
        return ytdEarnings.doubleValue();
    }

    @Override
    public double getYTDTaxesPaid() {
        return ytdTaxesPaid.doubleValue();
    }

    @Override
    public double getPretaxDeductions() {
        return pretaxDeductions.doubleValue();
    }

    protected abstract BigDecimal calculateGrossPay(double hoursWorked);

    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null;
        }
        BigDecimal grossPay = calculateGrossPay(hoursWorked);
        BigDecimal taxes = grossPay.subtract(pretaxDeductions).multiply(TAX_RATE);
        BigDecimal netPay = grossPay.subtract(pretaxDeductions).subtract(taxes);
        ytdEarnings = ytdEarnings.add(netPay);
        ytdTaxesPaid = ytdTaxesPaid.add(taxes);
        return new PayStub(this, netPay, taxes);
    }

    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f,%.2f,%.2f,%.2f",
                employeeType, name, id,
                getPayRate(),
                getPretaxDeductions(),
                getYTDEarnings(),
                getYTDTaxesPaid());
    }
}
