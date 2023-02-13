public class Employee{
    private static int empId = 1001;
    private String name;
    private String department;
    private String designation;
    private double salary;
    public int publicEmpID; 

    public Employee(){    
    }
    public Employee(String name, String department, String designation, double salary){
        this.publicEmpID = empId++;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getDesignation() {
        return designation;
    }
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public static int getEmpID() {
        return empId;
      }
    public static void setEmpID(int empId) {
        Employee.empId = empId;
    }
    public String ToString(){
        String details = "Employee Id: "+this.publicEmpID+"\nName: "+this.name+"\nDepartment: "+this.department+"\nDesignation: "+this.designation+"\nSalary: "+this.salary+"\n";
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
        System.out.println("Allowance = "+ (this.salary * allowance));
        this.salary += (this.salary * allowance);
        System.out.println("Salary with Allowance = "+ this.salary);
    }
}

