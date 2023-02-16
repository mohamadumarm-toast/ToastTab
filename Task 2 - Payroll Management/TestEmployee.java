import java.util.*;
public class TestEmployee {
    public static void main(String[] args){
        double salary;
        int  choice = 0;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        menu:
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
                    Hashtable<Employee, Integer> dict = new Hashtable<>();
                    MasterData data = new MasterData(employees);
                    System.out.println("\n------------Employees Details-------------");
                    for (Employee emp : data.getMasterData()) {
                        emp.setAllowance();
                        System.out.println(emp.toString());
                        System.out.println("----------------------------------------");
                    }
                    while(true){
                        while(true){
                            try{
                                System.out.println("\n1.Add Attendance to Employees\n2.Show Eligible List\n3.Go back\n4.Exit\nEnter your choice:");
                                choice = Integer.parseInt(scanner.nextLine());
                            }
                            catch(NumberFormatException e){
                                System.out.println(">>>Enter Single Integer Value!");
                                continue;
                            }
                            if(choice > 0 && choice <= 4){
                                break;
                            }
                            else{
                                System.out.println(">>>Enter valid choice!");
                            }
                        }
                        if(choice == 1){
                            int days;
                            System.out.println("----------------Attendance Portal--------------------");
                            for (Employee employee : data.getMasterData()) {
                                while(true){
                                    try{
                                        System.out.println("Id: "+employee.getEmpID());
                                        System.out.println("Name: "+employee.getName());
                                        System.out.println("Enter No. of working days:");
                                        days = Integer.parseInt(scanner.nextLine());
                                    }
                                    catch(NumberFormatException e){
                                        System.out.println(">>>Enter Integer Value!");
                                        continue;
                                    }
                                    if(days >=  0){
                                        dict.put(employee, days);
                                        break;
                                    }
                                    else{
                                        System.out.println(">>>Enter non-negative number!");
                                    }
                                }
                                System.out.println("--------------------------------------------");
                            }
                        }
                        else if(choice == 2){
                            if(dict.size()!=0){
                                AttendanceMaster employeeAttendance = new AttendanceMaster(dict);
                                System.out.println("-------------Eligible Employees-------------");
                                employeeAttendance.showEligibleList();
                            }
                            else{
                                System.out.println(">>>>Attendance not yet Entered!");
                            }
                        }
                        else if(choice == 3){
                            continue menu;
                        }
                        else{
                            break;
                        }
                    }
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
