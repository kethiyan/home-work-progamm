
package employee.management.system;


public class derived extends Employee
{
    String Department;
    
    public derived(String name, double salary,String Department)
    {
        super(name, salary);
        this.Department=Department;
    }
     void display()
     {
         System.out.println(super.name);
         System.out.println(super.salary);
         System.out.println("Department :"+ Department);
     }
}
