
package employee.management.system;


public class Employee
{
    String name;
    double salary;
    
    public Employee(String name,double salary)
    {
        this.name =name;
        this.salary=salary;
    }
    void display()
    {
        System.out.println("Employee Name :"+name );
        System.out.println("salary :"+salary );
        
    }
    
}
