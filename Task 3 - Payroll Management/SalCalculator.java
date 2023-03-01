import java.text.DecimalFormat;
import java.util.Hashtable;

public class SalCalculator {
    
    public SalCalculator(){

    }

    public void calculateSalary(Hashtable<Employee, Integer> filteredDict){
        double pf , gross, net, salary;
        System.out.println("-------------------------------------------------------PAYSLIP-------------------------------------------------------");
        System.out.printf("%-10s  %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n","ID","Name","Department","Designation","Salary","PF","GROSS","NET");
        for (Employee emp : filteredDict.keySet()) {
            if(emp.getDesignation().compareTo("Manager")==0){
                salary = emp.getSalary()/1.2;
            }
            else{
                salary = emp.getSalary()/1.1;
            }
            
            pf = salary * 0.1;
            gross = emp.getSalary();
            net = gross - pf; 
            System.out.println("---------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-10d %-15s %-15s %-15s %-15.2f %-15.2f %-15.2f %-15.2f\n",emp.getEmpID(),emp.getName(),emp.getDepartment(),emp.getDesignation(),salary,pf,gross,net);    
        }
    }
}
