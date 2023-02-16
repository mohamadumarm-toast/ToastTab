import java.util.ArrayList;

public class MasterData {
    private ArrayList<Employee> employee_list;

    public MasterData(ArrayList<Employee> employee_list){
        this.employee_list = employee_list;
    }

    public ArrayList<Employee> getMasterData(){
        return employee_list;
    }
    
}
