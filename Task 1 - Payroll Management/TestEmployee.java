import java.util.*;
public class TestEmployee {
    public static void main(String[] args){
        String name, size;
        double salary;
        int  departmentIdx = 0, designationIdx = 0, choice = 0;
        String[] department = {"HR", "Support", "Testing", "Design", "Financial"};
        String[] designation = {"Manager", "Administrator", "Tester", "UI/UX Designer", "Developer"};
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
                System.out.println("\nEmployee Id: "+ Employee.getEmpID());
                while(true){
                    System.out.println("Enter the name of employee: ");
                    name = scanner.nextLine();
                    if(name.matches("[a-zA-Z ]+") && name.length() > 2){
                        break;
                    }
                    else{
                        System.out.println("\n>>>>>Enter a valid name!!!");
                    }
                }
                while(true){
                    try{
                        System.out.println("\nAvailable Deaprtments:-\n1.HR\n2.Support\n3.Testing\n4.Design\n5.Financial\nEnter the Department: ");
                        departmentIdx = Integer.parseInt(scanner.nextLine());
                    }
                    catch(NumberFormatException e){
                        System.out.println(">>>Enter Single Integer Value!");
                        continue;
                    }
                    if(departmentIdx > 0 && departmentIdx <= department.length){
                        break;
                    }
                    else{
                        System.out.println(">>>Enter valid choice");
                    }
                }
                while(true){
                    try{
                        System.out.println("\nAvailable Designations:-\n1.Manager\n2.Administrator\n3.Tester\n4.UI/UX Designer\n5.Developer\nEnter the Designation: ");
                        designationIdx = Integer.parseInt(scanner.nextLine());
                    }
                    catch(NumberFormatException e){
                        System.out.println(">>>Enter Single Integer Value!");
                        continue;
                    }
                    if(designationIdx > 0 && designationIdx <= designation.length){
                        break;
                    }
                    else{
                        System.out.println(">>>Enter valid choice");
                    }
                }
                while(true){
                    try{
                        System.out.println("\nEnter Salary: ");
                        salary = Double.parseDouble(scanner.nextLine());
                    }
                    catch(NumberFormatException e){
                        System.out.println(">>>Enter valid Salary");
                        continue;
                    }
                    if(salary > 0){
                        break;
                    }
                    else{
                        System.out.println(">>>Enter valid Salary");
                    }
                }
                Employee employee = new Employee(name, department[departmentIdx - 1], designation[designationIdx- 1], salary);
                employees.add(employee);                
            }
            else{
                if(employees.size()!=0){
                    for (int i = 0; i < employees.size(); i++){
                            System.out.println(employees.get(i).ToString());
                            employees.get(i).setAllowance();
                        }
                }
                else{
                    System.out.println("---No Employee Added!---");
                }
                break;
            }
        }
    }
}
