import java.util.*;
public class TestEmployee {
    public static void main(String[] args){
        double salary;
        boolean filtered = false;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Employee> temp = new ArrayList<>();
        Hashtable<Employee, Integer> dict = new Hashtable<>();
        AttendanceMaster employeeAttendance = new AttendanceMaster(dict);
        while(true){
            MasterData data = new MasterData(employees);
            int  choice = 0;
            boolean flag = false;
            while(choice < 1 || choice > 7){
                try{
                    System.out.println("_______________MENU_______________");
                    System.out.println("\n1.Add an Employee\n2.Add Attendance to Employees\n3.Update Attendance by ID\n4.Filter Eligible Employees\n5.Display Employee List\n6.Calculate Salary\n7.Exit\nEnter your choice:");
                    choice = Integer.parseInt(scanner.nextLine());
                    if(choice < 1 || choice > 7){
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
                employee.setAllowance(); 
                System.out.println(">>>>>Employee Added Successfully!");       
            }
            else if(choice == 2){
                if(employees.size()!=0){
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
                    }
                    temp.clear();
                    System.out.println(">>>>Attendance Added for All Employees!");
                }
                else{
                    System.out.println(">>>>No Employees Added yet!");
                }
            }
            else if(choice == 3){
                if(employees.size()!=0){
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
                                                filtered = false;
                                                System.out.println(">>>>Attendance Updated!");
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
                else{
                    System.out.println(">>>>No Employees Added yet!");
                }
            }
            else if(choice == 4){
                if(dict.size()!=0){
                    System.out.println(">>>Filtering Employees....");
                    employeeAttendance.filterEmployeeList();
                    filtered = true;
                }
                else{
                    System.out.println(">>>>Attendance not yet Entered!");
                }
            }
            else if(choice == 5){
                if(employees.size()!=0){
                    System.out.println("\n------------Employees Details-------------");
                    for (Employee emp : data.getMasterData()) {
                        System.out.println(emp.toString());
                        System.out.println("----------------------------------------");
                    }
                }
                else{
                    System.out.println("---No Employee Added!---");
                }
            }
            else if(choice == 6){
                if(employees.size()!=0){
                    if(filtered){
                        SalCalculator calc = new SalCalculator();
                        calc.calculateSalary(employeeAttendance.employeeDict);
                        filtered = false;
                    }
                    else{
                        System.out.println(">>>>>Filter before Calculating the salary. Choose 4 to filter....");
                    }
                }
                else{
                    System.out.println(">>>>No Employees Added yet!");
                }

            }
            else{
                System.exit(0);
            }
        }
    }
}