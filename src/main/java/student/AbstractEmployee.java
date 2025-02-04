package student;

import java.math.BigDecimal;

/**
 * This class is a abstract class that implements the IEmployee interface.
 * It provides the basic functionality for an employee in the payroll system.
 */
public abstract class AbstractEmployee implements IEmployee {
    protected String name;
    protected String id;
    protected BigDecimal payRate;
    protected BigDecimal pretaxDeductions;
    protected BigDecimal ytdEarnings;
    protected BigDecimal ytdTaxesPaid;
    protected EmployeeType employeeType;

    /**
     * The tax rate used to calculate taxes.
     */
    private static BigDecimal TAX_RATE = new BigDecimal(0.2265);

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
