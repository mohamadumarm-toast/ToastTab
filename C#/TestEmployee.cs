using Employees;
using System.Collections.Generic;
using System;
public class TestEmployee{
    public static void Main(string[] args){
        List<Employee> employees = new List<Employee>();
        double salary ;
        int choice = 0;
        while(true){
            while(true){
                try{
                    Console.WriteLine("\nAdd an Employee~\n1.Yes\n2.No\nEnter your choice:");
                    choice = Convert.ToInt32(Console.ReadLine());
                    if(choice > 0 && choice < 3)
                        break;
                    else{
                        Console.WriteLine(">>>Enter valid choice!");
                    }
                }
                catch(FormatException){
                    Console.WriteLine(">>>Enter Single Integer Value!");
                    continue;
                }
            }
            if(choice == 1){
                Employee employee = new Employee();
                Console.WriteLine("Employee ID:"+employee.EmpID);
                Console.WriteLine("Enter Name:");
                string name = Console.ReadLine();
                employee.EmpName =  name;
                Console.WriteLine("\nAvailable Deaprtments:-\n1.HR\n2.Support\n3.Testing\n4.Design\n5.Financial\nEnter the Department: ");
                string dept = Console.ReadLine();
                employee.Dept =  dept;
                Console.WriteLine("\nAvailable Designations:-\n1.Manager\n2.Administrator\n3.Tester\n4.UI/UX Designer\n5.Developer\nEnter the Designation: ");
                string desg = Console.ReadLine();
                employee.Desg =  desg;
                while(true){
                    try{
                        Console.WriteLine("Enter Salary:");
                        salary = Convert.ToDouble(Console.ReadLine());
                        employee.Sal = salary;
                        break;
                    }
                    catch(FormatException){
                        Console.WriteLine(">>>Enter valid Salary!");
                        continue;
                    }

                }
                employees.Add(employee);
                System.Console.WriteLine(">>Employee Added Successfully!");
            }
            else{
                if(employees.Count!=0){
                    for(int i=0; i<employees.Count;i++){
                        System.Console.WriteLine(employees[i].ToString());
                        employees[i].setAllowance();
                    }
                }
                break;
            }
        }
    }
}