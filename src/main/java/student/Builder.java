package student;

import java.math.BigDecimal;

/**
 * This is a static class (essentially functions) that will help you build
 * objects from CSV strings.
 * These objects are then used in the rest of the program. Often these builders
 * are associated
 * with the objects themselves and the concept of a factory, but we placed
 * them here to keep the code clean (and to help guide you).
 */
public final class Builder {

    private Builder() {
    }

    /**
     * Builds an employee object from a CSV string.
     * 
     * You may end up checking the type of employee (hourly or salary) by looking at
     * the first
     * element of the CSV string. Then building an object specific to that type.
     * 
     * @param csv the CSV string
     * @return the employee object
     */
    public static IEmployee buildEmployeeFromCSV(String csv) {
        String[] parts = csv.split(",");
        if (parts.length != 7) {
            return null;
        }
        String employeeType = parts[0];
        String employeeName = parts[1];
        String employeeID = parts[2];
        BigDecimal payRate;
        BigDecimal pretaxDeductions;
        BigDecimal ytdEarnings;
        BigDecimal ytdTaxesPaid;

        try {
            payRate = new BigDecimal(parts[3]);
            pretaxDeductions = new BigDecimal(parts[4]);
            ytdEarnings = new BigDecimal(parts[5]);
            ytdTaxesPaid = new BigDecimal(parts[6]);
        } catch (NumberFormatException e) {
            return null;
        }

        if ("HOURLY".equals(employeeType)) {
            return new HourlyEmployee(employeeName, employeeID, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);
        } else if ("SALARY".equals(employeeType)) {
            return new SalaryEmployee(employeeName, employeeID, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);
        }
        return null;
    }

    /**
     * Converts a TimeCard from a CSV String.
     * 
     * @param csv csv string
     * @return a TimeCard object
     */
    public static ITimeCard buildTimeCardFromCSV(String csv) {
        String[] parts = csv.split(",");
        if (parts.length != 2) {
            return null;
        }
        String employeeID = parts[0];
        BigDecimal hoursWorked;
        try {
            hoursWorked = new BigDecimal(parts[1]);
        } catch (NumberFormatException e) {
            return null;
        }
        return new TimeCard(employeeID, hoursWorked);
    }
}
