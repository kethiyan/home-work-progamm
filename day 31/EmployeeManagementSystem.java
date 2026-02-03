
package employee.management.system;


public class EmployeeManagementSystem {

    
    public static void main(String[] args) 
    {
        Employee em=new Employee("kiri",25000);
        em.display();
        derived dr=new derived("aruk",3000,"it");
        dr.display();
    }
    
}
