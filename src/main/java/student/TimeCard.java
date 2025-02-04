package student;

import java.math.BigDecimal;

/**
 * Represents a time card that tracks an employee's worked hours.
 * Contains the employee's ID and the number of hours they worked in a pay
 * period.
 */
public class TimeCard implements ITimeCard {
    /** The ID of the employee associated with this time card. */
    private String employeeID;
    /** The number of hours worked in the pay period. */
    private BigDecimal hoursWorked;

    /**
     * Constructs a new TimeCard with the specified parameters.
     *
     * @param employeeID  The ID of the employee
     * @param hoursWorked The number of hours worked in the pay period
     */
    public TimeCard(String employeeID, BigDecimal hoursWorked) {
        this.employeeID = employeeID;
        this.hoursWorked = hoursWorked;
    }

    /**
     * @return The employee's ID associated with this time card
     */
    @Override
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * @return The number of hours worked as a double
     */
    @Override
    public double getHoursWorked() {
        return hoursWorked.doubleValue();
    }
}
