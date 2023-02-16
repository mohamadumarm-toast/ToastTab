import java.util.Hashtable;

public class AttendanceMaster {
    Hashtable<Employee, Integer> employeeDict;

    public AttendanceMaster(Hashtable<Employee, Integer> employeeDict){
        this.employeeDict = employeeDict;
    }

    public void showEligibleList(){
        int count =0;
        for (Employee emp : this.employeeDict.keySet()) {
            int days = this.employeeDict.get(emp);
            if(days >= 10){
                System.out.println(emp.toString());
                count++;
            }
        }
        if(count==0){
            System.out.println("---No one is eligible!---");
        }
    }
}
