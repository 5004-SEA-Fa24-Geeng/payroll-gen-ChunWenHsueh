# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for? 
   
CSV stands for Comma-Separated Values. It's a file format that stores data where each row is a data and each column is different field of data. The values are separated by commas.

2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?

Using `List<IEmployee>` instead of `ArrayList<HourlyEmployee>` gives us more flexibility. `ArrayList` and `HourlyEmployee` are implementation of `List` and `IEmployee` respectively. By using the interface type, we can store any object that implements the `List` and `IEmployee` interface, not just `ArrayList` and `HourlyEmployee` objects. This allows for polymorphism and easier extensibility.

3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?

It is called a "has-a" relationship or composition/aggregation.

4. Can you provide an example of a has-a relationship in your code (if one exists)?

In my code, the `PayStub` class has-a IEmployee object.

5. Can you provide an example of an is-a relationship in your code (if one exists)?

`HourlyEmployee` and `SalaryEmployee` is-a `IEmployee`. This is an example of an is-a relationship in the code.

6. What is the difference between an interface and an abstract class?

An interface only contains method names, while an abstract class can have both abstract and concrete methods, as well as variables.

7. What is the advantage of using an interface over an abstract class?

Interface is better for defining methods that classes should implement, while abstract classes are better for sharing code between related classes. Also, interface allow for multiple inheritance while abstract class does not.

8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it. 

`List<int> numbers = new ArrayList<int>();` is not valid in Java because primitive types cannot be used as type parameters. It should be `List<Integer> numbers = new ArrayList<Integer>();` using the Integer class instead.

9. Which class/method is described as the "driver" for your application? 

The PayrollGenerator class's main method is the driver for this application. It's the entry point of the program, and reads employee data, calculates the pay, and generating reports.

10. How do you create a temporary folder for JUnit Testing? 

In JUnit testing, you can create a temporary folder using the `@TempDir` syntax. This ensures test files are properly cleaned up after tests complete.

## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits.

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 

https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs
https://www.hrdive.com/news/gender-pay-gap-widening-in-stem/717223/

I think we can add a new field in the employee file, such as years of experience, education level, or certifications. These data points can help us determine if the employee is being paid fairly based on their qualifications and experience. We can also look at the data at the end of the payroll process, after calculating the pay, to see if there are any discrepancies in pay between employees that have similar experience and education level. By analyzing this data, we can identify any pay gaps and take steps to address them. This can help ensure that employees are being paid fairly and help promote diversity and inclusion in the workplace.