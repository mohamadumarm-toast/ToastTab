import java.util.ArrayList;
import java.util.Scanner;
public class ObjectSort {
    public static void printDetails(ArrayList<Employee> l){
        System.out.println("Employee Details:");
        System.out.println("ID\tFirst Name\tLast Name");
        for(int i =0; i < l.size(); i++){
            System.out.println(l.get(i).id + "\t" + l.get(i).firstName + "\t\t" + l.get(i).lastName);
        }
    }
    public static void sortBubble(ArrayList<Employee> employeeList, int choice){
        for(int i = 0; i < employeeList.size() - 1; i++){  
            for(int j = i+1; j < employeeList.size(); j++){
                String val1 = "", val2 = "" ;
                if(choice == 1){
                    val1 = employeeList.get(i).id;
                    val2 = employeeList.get(j).id;
                }
                else if(choice == 2){
                    val1 = employeeList.get(i).firstName;
                    val2 = employeeList.get(j).firstName;
                }
                else{
                    val1 = employeeList.get(i).lastName;
                    val2 = employeeList.get(j).lastName;
                }
                if( val1.compareTo( val2 ) > 0 ){
                    Employee temp = employeeList.get(i);
                    employeeList.set(i, employeeList.get(j));
                    employeeList.set(j, temp);
                }
            }
        }  
    }
    public static int partition(ArrayList<Employee> arr, int begin, int end, int choice) {
        int i = (begin-1);
        for (int j = begin; j < end; j++) {
            String value = "", pivot= "";
            if(choice == 1 ){
                pivot = arr.get(end).id;
                value = arr.get(j).id;
            }
            else if(choice == 2){
                pivot = arr.get(end).firstName;
                value = arr.get(j).firstName;
            }
            else{
                pivot = arr.get(end).lastName;
                value = arr.get(j).lastName;
            }

            if (value.compareTo(pivot) <= 0){
                i++;
                Employee temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        Employee temp = arr.get(i+1);
        arr.set(i+1, arr.get(end));
        arr.set(end, temp);
        return i+1;
    }
    public static void quickSort(ArrayList<Employee> arr, int begin, int end, int choice) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end, choice);
            quickSort(arr, begin, partitionIndex-1, choice);
            quickSort(arr, partitionIndex+1, end, choice);
        }
    }
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>(20);
        //String [] id = {"1", "3", "13", "11", "5", "16", "7", "18", "9", "10", "2", "4", "12", "6", "15", "8", "19","20", "14", "17"};
        int [] id = {1,3,13,11,5,16,7,18,9,10,2,4,12,6,15,8,19,20,14,17};
        String [] employeeFirstName = {"John", "Jane", "Muruga","Muneer", "Mohamad", "Johnson", "Andrew", "Zain","Bala","Ajith", "Michael", "Ross", "Sheldon", "Mari", "Mohamad", "Nathon", "Jane", "Mahatma", "Donald", "King"};
        String [] employeeLastName = {"Doe", "Doe", "Doss","Umar","Umair","Kate","Tate", "Maalik","Raja", "Kumar", "Rayappan","Green","Cooper", "Raj","Akbar", "Doir", "Willy", "Candy", "Trump", "Charles"};
        for(int i = 0; i < id.length; i++){
            String employeeId = "";
            if(id[i]>0 && id[i]<10){
                employeeId = ""+id[i];
            }
            else{
                employeeId = ""+id[i];
            }
            list.add(new Employee(employeeId, employeeFirstName[i], employeeLastName[i]));
        }
        printDetails(list);
        int choice = 0;
        do{
            System.out.println("\n\n1.Sort by Id\n2.Sort by First Name\n3.Sort by Last Name\n4.Exit\nEnter your choice:");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            if(choice <= 3){
                // sortBubble(list , choice);
                quickSort(list, 0, list.size()-1, choice);
                printDetails(list);
            }
        }while(choice<4);       
    }    
}
class Employee{
    String id;
    String firstName;
    String lastName;

    Employee() {
        id = "10000";
        firstName = "John";
        lastName = "Doe";
    }
    Employee(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
