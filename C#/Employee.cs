using System;
namespace Employees{
    public class Employee{
        private static int counter = 1001;
        private int empID;
        private string Name;
        private string Department;
        private string Designation;
        private double Salary;

        public int EmpID{
            get{empID = counter++;return empID;}
            set{empID = value;}
        }

        public string EmpName{
            get{return Name;}
            set{Name = value;}
        }
        public string Dept{
            get{return Department;}
            set{
                string[] departments = {"HR", "Support", "Testing", "Design", "Financial"};
                int departmentIdx =0;
                while(true){
                    try{
                        departmentIdx = Convert.ToInt32(value);
                        if(departmentIdx > 0 && departmentIdx <= departments.Length){
                            Department = departments[departmentIdx];
                            break;
                        }
                        else{
                            System.Console.WriteLine(">>>Enter valid choice");
                            System.Console.WriteLine("\nAvailable Deaprtments:-\n1.HR\n2.Support\n3.Testing\n4.Design\n5.Financial\nEnter the Department: ");
                            value = Console.ReadLine();
                        }
                    }
                    catch(FormatException){
                        System.Console.WriteLine(">>>Enter valid choice");
                        System.Console.WriteLine("\nAvailable Deaprtments:-\n1.HR\n2.Support\n3.Testing\n4.Design\n5.Financial\nEnter the Department: ");
                        value = Console.ReadLine();
                        continue;
                    }
                }
            }
        }
        public string Desg{
            get{return Designation;}
            set{
                string[] desgs = {"Manager", "Administrator", "Tester", "UI/UX Designer", "Developer"};
                int desIdx =0;
                while(true){
                    try{
                        desIdx = Convert.ToInt32(value);
                        if(desIdx > 0 && desIdx <= desgs.Length){
                            Designation = desgs[desIdx];
                            break;
                        }
                        else{
                            System.Console.WriteLine(">>>Enter valid choice");
                            System.Console.WriteLine("\nAvailable Deaprtments:-\n1.HR\n2.Support\n3.Testing\n4.Design\n5.Financial\nEnter the Department: ");
                            value = Console.ReadLine();
                        }
                    }
                    catch(FormatException){
                        System.Console.WriteLine(">>>Enter valid choice");
                        System.Console.WriteLine("\nAvailable Deaprtments:-\n1.HR\n2.Support\n3.Testing\n4.Design\n5.Financial\nEnter the Department: ");
                        value = Console.ReadLine();
                        continue;
                    }
                }

            }
        }
        public double Sal{
            get{return Salary;}
            set{
                while(true){
                    if(value >= 5000){
                        break;
                    }
                    else{
                        System.Console.WriteLine(">>>Enter valid Salary > 5000");
                        System.Console.WriteLine("\nEnter Salary: ");
                        value = Convert.ToDouble(Console.ReadLine());
                    }
                }
                Salary = value;
                }
        }
        public override string ToString(){
            string details = "\nID:"+empID+"\nName:"+EmpName+"\nDepartment:"+Dept+"\nDesignation"+Desg+"\nSalary:"+Sal;
            return details;
        }

        public void setAllowance(){
            if(Desg == "Manager"){
                Sal += Sal*0.2;
            }
            else{
                Sal += Sal*0.1;
            }
            System.Console.WriteLine("Salary with Allowance:"+Sal);
        }
    }
}