import java.util.ArrayList;

public class MasterData {
    private ArrayList<Employee> employeeList;

    public MasterData(ArrayList<Employee> employeeList){
        this.employeeList = employeeList;
    }

    public ArrayList<Employee> getMasterData(){
        return employeeList;
    }

    public void displayEmployees(){
        for (Employee emp : employeeList) {
            System.out.println(emp.toString());
            System.out.println("----------------------------------------");
        }
    }
    
}
