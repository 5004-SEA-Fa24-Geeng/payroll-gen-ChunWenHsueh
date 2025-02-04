package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents a salaried employee in the payroll system.
 * This class extends AbstractEmployee and implements specific pay calculation
 * logic
 * for employees paid on a salary basis.
 */
public class SalaryEmployee extends AbstractEmployee {
    /**
     * Constant used to convert annual salary to hourly rate.
     * The divisor of 24 represents the standard pay periods in a year.
     */
    private final BigDecimal SALARY_EMPLOYEE_DIVISOR = new BigDecimal(24);

    /**
     * Constructs a new SalaryEmployee with the specified parameters.
     *
     * @param name             The employee's full name
     * @param id               The employee's unique identifier
     * @param payRate          The employee's annual salary
     * @param ytdEarnings      The employee's year-to-date earnings
     * @param ytdTaxesPaid     The employee's year-to-date taxes paid
     * @param pretaxDeductions The employee's pretax deductions
     */
    public SalaryEmployee(
            String name,
            String id,
            BigDecimal payRate,
            BigDecimal ytdEarnings,
            BigDecimal ytdTaxesPaid,
            BigDecimal pretaxDeductions) {
        super(name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid, EmployeeType.SALARY);
    }

    /**
     * Constructs a new SalaryEmployee with the specified parameters.
     *
     * @param name             The employee's full name
     * @param id               The employee's unique identifier
     * @param payRate          The employee's annual salary as a double
     * @param ytdEarnings      The employee's year-to-date earnings as a double
     * @param ytdTaxesPaid     The employee's year-to-date taxes paid as a double
     * @param pretaxDeductions The employee's pretax deductions as a double
     */
    public SalaryEmployee(
            String name,
            String id,
            double payRate,
            double ytdEarnings,
            double ytdTaxesPaid,
            double pretaxDeductions) {
        super(name, id, BigDecimal.valueOf(payRate), BigDecimal.valueOf(pretaxDeductions),
                BigDecimal.valueOf(ytdEarnings), BigDecimal.valueOf(ytdTaxesPaid), EmployeeType.SALARY);
    }

    /**
     * Calculates the gross pay for the salaried employee.
     * For salaried employees, this calculates their pay rate per hour
     * by dividing their annual salary by 24 (pay periods).
     *
     * @param hoursWorked The number of hours worked (not used in calculation for
     *                    salaried employees)
     * @return The calculated hourly pay rate, rounded to 2 decimal places
     */
    @Override
    public BigDecimal calculateGrossPay(double hoursWorked) {
        BigDecimal hourlyPayRate = payRate.divide(SALARY_EMPLOYEE_DIVISOR, 2,
                RoundingMode.HALF_UP);
        return hourlyPayRate;
    }
}
