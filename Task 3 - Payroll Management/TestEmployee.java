import java.util.*;
public class TestEmployee {

    public static void displayEmployees(ArrayList<Employee> employeeList){
        System.out.printf("%-10s %-15s %-15s %-15s %-15s\n","Id", "Name", "Department", "Designation", "Salary");
        for (Employee emp : employeeList) {
            System.out.println("--------------------------------------------------------------------");
            System.out.println(emp.toString());
        }
        System.out.println("--------------------------------------------------------------------");
    }
    public static void customSort(ArrayList<Employee> arr, int choice, int order){
        //Sort by name
        if(choice == 1){
            if(order == 1){ //Asc
                arr.sort((Employee e1, Employee e2) -> e1.getName().compareTo(e2.getName()));
            }
            else{ //Desc
                arr.sort((Employee e1, Employee e2) -> e2.getName().compareTo(e1.getName()));
            }
        }
        //Sort By Department
        else if(choice == 2){
            if(order == 1){ //Asc
                arr.sort((Employee e1, Employee e2) -> e1.getDepartment().compareTo(e2.getDepartment()));
            }
            else{ //Desc
                arr.sort((Employee e1, Employee e2) -> e2.getDepartment().compareTo(e1.getDepartment()));
            }
        }
        //Sort By Designation
        else{
            if(order == 1){ //Asc
                arr.sort((Employee e1, Employee e2) -> e1.getDesignation().compareTo(e2.getDesignation()));
            }
            else{ //Desc
                arr.sort((Employee e1, Employee e2) -> e2.getDesignation().compareTo(e1.getDesignation()));
            }
        }
    }
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
            while(choice < 1 || choice > 8){
                try{
                    System.out.println("\n_______________MENU_______________");
                    System.out.println("\n1.Add an Employee\n2.Add Attendance to Employees\n3.Update Attendance by ID\n4.Filter Eligible Employees\n5.Display Employee List\n6.Calculate Salary\n7.Sort\n8.Exit\nEnter your choice:");
                    choice = Integer.parseInt(scanner.nextLine());
                    if(choice < 1 || choice > 8){
                        System.out.println("\n>>>Enter valid choice!");   
                    }
                }
                catch(NumberFormatException e){
                    System.out.println("\n>>>Enter Single Integer Value!");
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
                        System.out.println("\n>>>Enter valid Salary");
                    }
                }    
                employees.add(employee);
                temp.add(employee); 
                employee.setAllowance(); 
                filtered = false;
                System.out.println("\n>>>>>Employee Added Successfully!");       
            }
            else if(choice == 2){
                if(employees.size()!=0){
                    if(temp.size() == 0){
                        System.out.println(">>>Attendance added for all employees!");
                    }
                    else{
                        int days;
                        System.out.println("\n----------------Attendance Portal--------------------");
                        for (Employee employee : temp) {
                            while(true){
                                try{
                                    System.out.println("\nId: "+employee.getEmpID());
                                    System.out.println("Name: "+employee.getName());
                                    System.out.println("Enter No. of working days:");
                                    days = Integer.parseInt(scanner.nextLine());
                                    if(days >=  0 && days <=31){
                                        dict.put(employee, days);
                                        break;
                                    }
                                    else{
                                        System.out.println("\n>>>Enter valid number of days per month!");
                                    }
                                }
                                catch(NumberFormatException e){
                                    System.out.println("\n>>>Enter Integer Value!");
                                }
                            }
                            System.out.println("--------------------------------------------");
                        }
                        temp.clear();
                        System.out.println("\n>>>>Attendance Added for All Employees!");
                    }
                }
                else{
                    System.out.println("\n>>>>No Employees Added yet!");
                }
            }
            else if(choice == 3){
                if(employees.size()!=0){
                    int keyId, days;
                    boolean empFound = false;
                    System.out.println("\n----------------Update Attendance By ID--------------------");
                    while(true){
                        try{
                            System.out.println("\nEnter Employee ID:");
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
                                            if(days >=  0 && days <=31){
                                                dict.put(emp, days);
                                                filtered = false;
                                                temp.remove(emp);
                                                System.out.println("\n>>>>Attendance Updated!");
                                                break;
                                            }
                                            else{
                                                System.out.println("\n>>>Enter valid number of days per month!");
                                            }
                                        }
                                        catch(NumberFormatException e){
                                            System.out.println("\n>>>Enter Integer Value!");
                                        }
                                    }
                                    break;
                                }
                            }
                            if(!empFound){
                                System.out.println("\n>>>>Employee not found! Re-enter Valid Employee ID...");
                            }
                            else
                                break;
                        }
                        catch(NumberFormatException e){
                            System.out.println("\n>>>Enter Integer Value!");
                        }
                    }
                }
                else{
                    System.out.println("\n>>>>No Employees Added yet!");
                }
            }
            else if(choice == 4){
                if(employees.size() != 0 ){
                    if(temp.size() == 0){
                        System.out.println("\n>>>Filtering Employees....");
                        employeeAttendance.filterEmployeeList();
                        filtered = true;
                    }
                    else{
                        System.out.println(">>>>Enter attendance for all employees!");
                    }
                }
                else{
                    System.out.println("\n>>>>No Employees Added yet!");
                }
            }
            else if(choice == 5){
                if(employees.size()!=0){
                    System.out.println("\n-------------------------Employees Details-------------------------");
                    displayEmployees(data.getMasterData());
                }
                else{
                    System.out.println("\n>>>>No Employees Added yet!");
                }
            }
            else if(choice == 6){
                if(employees.size()!=0){
                    if(filtered){
                        SalCalculator calc = new SalCalculator();
                        if(employeeAttendance.getEmployeeDict().size()!=0){
                            calc.calculateSalary(employeeAttendance.getEmployeeDict());
                        }
                        else{
                            System.out.println("\n>>>No one is eligible!");
                        }
                    }
                    else{
                        System.out.println("\n>>>>>Filter before Calculating the salary. Choose 4 to filter....");
                    }
                }
                else{
                    System.out.println("\n>>>>No Employees Added yet!");
                }

            }
            else if(choice == 7){
                if(employees.size()!=0){
                    int sortChoice, order;
                    while(true){
                        try{
                            System.out.println("\n------------SORTING------------\n1.Sort By Name\n2.Sort By Dept\n3.Sort By Designation\n4.Exit\nEnter your Choice:");
                            sortChoice = Integer.parseInt(scanner.nextLine());
                            if(sortChoice >=1 && sortChoice <=3){
                                while(true){
                                    try{
                                        System.out.println("--------------------------\n1.Ascending order\n2.Descending order\nEnter order:");
                                        order = Integer.parseInt(scanner.nextLine());
                                        if(order == 1 || order == 2){
                                            customSort(data.getMasterData(), sortChoice, order);
                                            System.out.println("\n----------------------------AFTER SORTING----------------------------");
                                            displayEmployees(data.getMasterData());
                                            break;
                                        }
                                    }
                                    catch(NumberFormatException e){
                                        System.out.println("\n>>>Enter Single Integer Value!");
                                    }
                                }
                                break;
                            }
                            else if(sortChoice == 4){
                                break;
                            }
                            else{
                                System.out.println("\n>>>>Enter Valid Choice!");
                            }
                        }
                        catch(NumberFormatException e){
                            System.out.println("\n>>>Enter Single Integer Value!");
                        }
                    }
                }
                else{
                    System.out.println("\n>>>>No Employees Added yet!");
                }
            }
            else{
                System.exit(0);
            }
        }
    }
}