import java.util.*;
public class TestEmployee {
    public static void main(String[] args){
        double salary;
        int  choice = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        while(true){
            while(true){
                try{
                    System.out.println("\nAdd an Employee~\n1.Yes\n2.No\nEnter your choice:");
                    choice = Integer.parseInt(scanner.nextLine());
                }
                catch(NumberFormatException e){
                    System.out.println(">>>Enter Single Integer Value!");
                    continue;
                }
                if(choice > 0 && choice < 3){
                    break;
                }
                else{
                    System.out.println(">>>Enter valid choice!");
                }
            }
            if(choice == 1){
                Employee employee = new Employee();
                System.out.println("\nEmployee Id: "+ employee.getEmpID());
                System.out.println("Enter the name of employee: ");
                employee.setName(scanner.nextLine());
                System.out.println("\nAvailable Deaprtments:-\n1.HR\n2.Support\n3.Testing\n4.Design\n5.Financial\nEnter the Department: ");
                employee.setDepartment(scanner.nextLine());
                System.out.println("\nAvailable Designations:-\n1.Manager\n2.Administrator\n3.Tester\n4.UI/UX Designer\n5.Developer\nEnter the Designation: ");
                employee.setDesignation(scanner.nextLine());
                while(true){
                    try{
                        System.out.println("\nEnter Salary: ");
                        salary = Double.parseDouble(scanner.nextLine());
                    }
                    catch(NumberFormatException e){
                        System.out.println(">>>Enter valid Salary");
                        continue;
                    }
                    employee.setSalary(salary);
                    break;
                }
                employees.add(employee);                
            }
            else{
                if(employees.size()!=0){
                    MasterData data = new MasterData(employees);
                    for (Employee emp : data.getMasterData()) {
                        emp.setAllowance();
                        System.out.println(emp.toString());
                    }
                    // for (int i = 0; i < employees.size(); i++){
                    //         System.out.println(employees.get(i).toString());
                    //         employees.get(i).setAllowance();
                    //     }
                }
                else{
                    System.out.println("---No Employee Added!---");
                }
                break;
            }
        }
        scanner.close();
    }
}
