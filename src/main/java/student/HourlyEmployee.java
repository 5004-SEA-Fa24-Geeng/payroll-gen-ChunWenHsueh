package student;

import java.math.BigDecimal;

/**
 * Represents an hourly employee in the payroll system.
 * This class extends AbstractEmployee and implements specific pay calculation
 * logic
 * for employees paid on an hourly basis, including overtime calculations.
 */
public class HourlyEmployee extends AbstractEmployee {

    /**
     * Constant used to calculate overtime pay.
     */
    private static final BigDecimal OVERTIME_RATE = new BigDecimal(1.5);

    /**
     * The number of hours after which overtime pay is applied.
     * Any hours worked beyond this threshold are considered overtime.
     */
    private static final BigDecimal OVERTIME_HOUR = new BigDecimal(40);

    /**
     * Constructs a new HourlyEmployee with the specified parameters.
     *
     * @param name             The employee's full name
     * @param id               The employee's unique identifier
     * @param payRate          The employee's hourly pay rate
     * @param ytdEarnings      The employee's year-to-date earnings
     * @param ytdTaxesPaid     The employee's year-to-date taxes paid
     * @param pretaxDeductions The employee's pretax deductions
     */
    public HourlyEmployee(
            String name,
            String id,
            BigDecimal payRate,
            BigDecimal ytdEarnings,
            BigDecimal ytdTaxesPaid,
            BigDecimal pretaxDeductions) {
        super(name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid, EmployeeType.HOURLY);
    }

    /**
     * Constructs a new HourlyEmployee with the specified parameters.
     *
     * @param name             The employee's full name
     * @param id               The employee's unique identifier
     * @param payRate          The employee's hourly pay rate
     * @param ytdEarnings      The employee's year-to-date earnings
     * @param ytdTaxesPaid     The employee's year-to-date taxes paid
     * @param pretaxDeductions The employee's pretax deductions
     */
    public HourlyEmployee(
            String name,
            String id,
            double payRate,
            double ytdEarnings,
            double ytdTaxesPaid,
            double pretaxDeductions) {
        super(name, id, BigDecimal.valueOf(payRate), BigDecimal.valueOf(pretaxDeductions),
                BigDecimal.valueOf(ytdEarnings), BigDecimal.valueOf(ytdTaxesPaid), EmployeeType.HOURLY);
    }

    /**
     * Calculates the gross pay for the hourly employee based on hours worked.
     * If hours worked exceed 40, overtime pay is calculated at 1.5 times the
     * regular rate
     * for hours over 40.
     *
     * @param hoursWorked The number of hours worked in the pay period
     * @return The calculated gross pay, rounded to 2 decimal places
     */
    @Override
    public BigDecimal calculateGrossPay(double hoursWorked) {
        BigDecimal hoursWorkedBigDecimal = new BigDecimal(hoursWorked);
        BigDecimal grossPay;
        int overtimeComparison = hoursWorkedBigDecimal.compareTo(HourlyEmployee.OVERTIME_HOUR);
        if (overtimeComparison > 0) {
            BigDecimal overtimeHours = hoursWorkedBigDecimal.subtract(new BigDecimal(40));
            BigDecimal overtimePayRate = getPayRateBigDecimal().multiply(HourlyEmployee.OVERTIME_RATE);
            BigDecimal overtimeSalary = overtimeHours.multiply(overtimePayRate);
            grossPay = getPayRateBigDecimal().multiply(new BigDecimal(40)).add(overtimeSalary);
        } else {
            grossPay = getPayRateBigDecimal().multiply(hoursWorkedBigDecimal);
        }
        return grossPay;
    }
}
