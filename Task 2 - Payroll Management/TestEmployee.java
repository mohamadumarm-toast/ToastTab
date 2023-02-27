import java.util.*;
public class TestEmployee {
    public static void main(String[] args){
        double salary;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Employee> temp = new ArrayList<>();
        Hashtable<Employee, Integer> dict = new Hashtable<>();
        menu:
        while(true){
            int  choice = 0;
            boolean flag = false;
            while(choice < 1 || choice > 2){
                try{
                    System.out.println("\nAdd an Employee~\n1.Yes\n2.No\nEnter your choice:");
                    choice = Integer.parseInt(scanner.nextLine());
                    if(choice < 1 || choice > 2){
                        System.out.println(">>>Enter valid choice!");   
                    }
                }
                catch(NumberFormatException e){
                    System.out.println(">>>Enter Single Integer Value!");
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
                        employee.setSalary(salary);
                        break;
                    }
                    catch(NumberFormatException e){
                        System.out.println(">>>Enter valid Salary");
                    }
                }
                employees.add(employee);
                temp.add(employee);           
            }
            else{
                if(employees.size()!=0){
                    MasterData data = new MasterData(employees);
                    System.out.println("\n------------Employees Details-------------");
                    for (Employee emp : data.getMasterData()) {
                        // emp.setAllowance();
                        System.out.println(emp.toString());
                        System.out.println("----------------------------------------");
                    }
                    while(true){
                        choice = 0;
                        while(choice < 1 || choice > 5){
                            try{
                                System.out.println("\n1.Add Attendance to Employees\n2.Update Attendance by ID\n3.Show Eligible List\n4.Go back\n5.Exit\nEnter your choice:");
                                choice = Integer.parseInt(scanner.nextLine());
                                if(choice < 1 || choice > 5){
                                    System.out.println(">>>Enter valid choice!");
                                }
                            }
                            catch(NumberFormatException e){
                                System.out.println(">>>Enter Single Integer Value!");
                            }
                        }
                        if(choice == 1){
                            int days;
                            System.out.println("----------------Attendance Portal--------------------");
                            for (Employee employee : temp) {
                                while(true){
                                    try{
                                        System.out.println("Id: "+employee.getEmpID());
                                        System.out.println("Name: "+employee.getName());
                                        System.out.println("Enter No. of working days:");
                                        days = Integer.parseInt(scanner.nextLine());
                                        if(days >=  0){
                                            dict.put(employee, days);
                                            break;
                                        }
                                        else{
                                            System.out.println(">>>Enter non-negative number!");
                                        }
                                    }
                                    catch(NumberFormatException e){
                                        System.out.println(">>>Enter Integer Value!");
                                    }
                                }
                                System.out.println("--------------------------------------------");
                                flag = true;
                            }
                        }
                        else if(choice == 2){
                            int keyId, days;
                            boolean empFound = false;
                            System.out.println("----------------Update Attendance By ID--------------------");
                            while(true){
                                try{
                                    System.out.println("Enter Employee ID:");
                                    keyId = Integer.parseInt(scanner.nextLine());
                                    for (Employee emp : employees) {
                                        if(emp.getEmpID() == keyId){
                                            empFound = true;
                                            while(true){
                                                try{
                                                    System.out.println("Id: "+emp.getEmpID());
                                                    System.out.println("Name: "+emp.getName());
                                                    System.out.println("Enter No. of working days:");
                                                    days = Integer.parseInt(scanner.nextLine());
                                                    if(days >=  0){
                                                        dict.put(emp, days);
                                                        break;
                                                    }
                                                    else{
                                                        System.out.println(">>>Enter non-negative number!");
                                                    }
                                                }
                                                catch(NumberFormatException e){
                                                    System.out.println(">>>Enter Integer Value!");
                                                }
                                            }
                                            break;
                                        }
        
                                    }
                                    if(!empFound){
                                        System.out.println(">>>>Employee not found! Re-enter Valid Employee ID...");
                                    }
                                    else
                                        break;
                                }
                                catch(NumberFormatException e){
                                    System.out.println(">>>Enter Integer Value!");
                                }
                            }
                        }
                        else if(choice == 3){
                            if(dict.size()!=0){
                                AttendanceMaster employeeAttendance = new AttendanceMaster(dict);
                                System.out.println("-------------Eligible Employees-------------");
                                employeeAttendance.showEligibleList();
                            }
                            else{
                                System.out.println(">>>>Attendance not yet Entered!");
                            }
                        }
                        else if(choice == 4){
                            if(flag == true){
                                temp.clear();
                            }
                            continue menu;
                        }
                        else{
                            System.exit(0);
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
