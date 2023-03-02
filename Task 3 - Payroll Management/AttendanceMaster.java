import java.util.ArrayList;
import java.util.Hashtable;

public class AttendanceMaster {
    Hashtable<Employee, Integer> employeeDict;

    public AttendanceMaster(Hashtable<Employee, Integer> employeeDict){
        this.employeeDict = employeeDict;
    }

    public void showEligibleList(){
        System.out.printf("%-10s %-15s %-15s %-15s %-15s\n","Id", "Name", "Department", "Designation", "Salary");
        for (Employee emp : this.employeeDict.keySet()) {
            int days = this.employeeDict.get(emp);
            if(days > 10){
                System.out.println("--------------------------------------------------------------------");
                System.out.println(emp.toString());
            }
        }
        System.out.println("--------------------------------------------------------------------");
    }

    public void filterEmployeeList(){
        ArrayList<Employee> keys = new ArrayList<>(this.employeeDict.keySet());
        for (Employee emp : keys) {
            int days = this.employeeDict.get(emp);
            if(days <= 10){
                this.employeeDict.remove(emp);
            }
        }
        if(this.employeeDict.size()!=0)
            showEligibleList();
        else{
            System.out.println(">>>No eligible employees!");
        }

    }
}
