import java.util.ArrayList;

public class MasterData {
    private ArrayList<Employee> employeeList;

    public MasterData(ArrayList<Employee> employeeList){
        this.employeeList = employeeList;
    }

    public ArrayList<Employee> getMasterData(){
        return employeeList;
    }
    
}
