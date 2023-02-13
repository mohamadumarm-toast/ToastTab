import java.util.Random;
import java.util.ArrayList;
public class Rand {
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<Integer>(50);
        Random r = new Random();
        int val = 0;
        for(int i= 0; i< 50; i++){
            val = r.nextInt(101);
            arr.add(val);
        }
        System.out.println("\nGenerated Array:");
        for(int i= 0; i< arr.size(); i++){
            System.out.print(arr.get(i)+ " ");
        }
        while(arr.size()!=25){
            val = r.nextInt(101);
            int size =arr.size();
            for(int i= size -1 ; i>=0; i--) {
                if(arr.get(i) == val){
                    arr.remove(i);
                }
            }
        }
        System.out.println("\nAfter Deleting 25 elements from the Array:");
        for(int i= 0; i< arr.size(); i++){
            System.out.print(arr.get(i)+ " ");
        }
          
    }
}
