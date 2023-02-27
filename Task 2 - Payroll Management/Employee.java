import java.util.Scanner;

public class Employee{
    private static int counter = 1001;
    private String name;
    private String department;
    private String designation;
    private double salary;
    private int empId; 

    public Employee(){    
        this.empId = counter++;
    }
    public Employee(String name, String department, String designation, double salary){
        this.empId = counter++;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        Scanner in = new Scanner(System.in);
        while(true){
            if(name.matches("[a-zA-Z ]+") && name.length() > 2){
                break;
            }
            else{
                System.out.println("\n>>>>>Enter a valid name!!!");
                System.out.println("Enter the name of employee: ");
                name = in.nextLine();
            }
        }
        this.name = name;
        
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String dept) {
        String[] departments = {"HR", "Support", "Testing", "Design", "Financial"};
        int departmentIdx =0;
        Scanner in = new Scanner(System.in);
        while(true){
            try{
                departmentIdx = Integer.parseInt(dept);
                if(departmentIdx > 0 && departmentIdx <= departments.length){
                    this.department = departments[departmentIdx-1];
                    break;
                }
                else{
                    System.out.println(">>>Enter valid choice");
                    System.out.println("\nAvailable Deaprtments:-\n1.HR\n2.Support\n3.Testing\n4.Design\n5.Financial\nEnter the Department: ");
                    dept = in.nextLine();
                }
            }
            catch(NumberFormatException e){
                System.out.println(">>>Enter Single Integer Value!");
                System.out.println("\nAvailable Deaprtments:-\n1.HR\n2.Support\n3.Testing\n4.Design\n5.Financial\nEnter the Department: ");
                dept = in.nextLine();
                continue;
            }
        }
        
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String desgn) {
        String[] designation = {"Manager", "Administrator", "Tester", "UI/UX Designer", "Developer"};
        int designationIdx =0;
        Scanner in = new Scanner(System.in);
        while(true){
            try{
                designationIdx = Integer.parseInt(desgn);
                if(designationIdx > 0 && designationIdx <= designation.length){
                    this.designation = designation[designationIdx-1];
                    break;
                }
                else{
                    System.out.println(">>>Enter valid choice");
                    System.out.println("\nAvailable Designations:-\n1.Manager\n2.Administrator\n3.Tester\n4.UI/UX Designer\n5.Developer\nEnter the Designation: ");
                    desgn = in.nextLine();
                }
            }
            catch(NumberFormatException e){
                System.out.println(">>>Enter Single Integer Value!");
                System.out.println("\nAvailable Designations:-\n1.Manager\n2.Administrator\n3.Tester\n4.UI/UX Designer\n5.Developer\nEnter the Designation: ");
                desgn = in.nextLine();
            }
        }
        
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        Scanner in = new Scanner(System.in);
        while(true){
            if(salary > 5000){
                break;
            }
            else{
                System.out.println(">>>Enter Salary greater than 5000");
                System.out.println("\nEnter Salary: ");
                salary = in.nextDouble();
            }
        }
        this.salary = salary;
        
    }
    public int getEmpID() {
        return this.empId;
      }
    public String toString(){
        String details = "\nEmployee Id: "+this.empId+"\nName: "+this.name+"\nDepartment: "+this.department+"\nDesignation: "+this.designation+"\nSalary: "+this.salary+"\n";
        return details;
    }
    public void setAllowance(){
        double allowance;
        if( this.designation.compareTo("Manager") == 0 ){
            allowance = 0.2;
        }
        else{
            allowance = 0.1;
        }
        // System.out.println("Allowance = "+ (this.salary * allowance));
        this.salary += (this.salary * allowance);
        // System.out.println("\nSalary with Allowance = "+ this.salary);
    }
}

