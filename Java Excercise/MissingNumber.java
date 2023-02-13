import java.util.*;

public class MissingNumber{
	
	public static int checkType(int[] arr){
		int oddcnt = 0, evencnt = 0;
		for(int i=0; i< 3; i++){
			if(arr[i] % 2 == 0)
				evencnt++;
			else
				oddcnt++;
		}
		if(oddcnt == 0)
			return 1; //even series
		else if(evencnt == 0)
			return 2; // odd series
		else
			return 3; // natural number series
	}

	
	public static int findMissing(int[] a, int n, int type){
		int actualTotal = 0;
		int total = 0;
		int diff = 0;
		for(int i =0; i < n; i++){
			total += a[i];
		}
		actualTotal = ((n + 1) * (a[0] + a[n-1]))/2;
		//For event series
		if(type == 1){
			System.out.println("Even series");
			int lastele = a[0] + ((n - 1) * 2);
			if( lastele == a[n-1])
				return 0;
			else{
				diff = actualTotal - total;
				return diff;
			}
		}
		//For odd series
		else if(type == 2){
			System.out.println("Odd series");
			int lastele = a[0] + ((n - 1) * 2);
			if( lastele == a[n-1])
				return 0;
			else{
				diff = actualTotal - total;
				return diff;
			}
			
		}
		//for natural numbers series
		else{
			System.out.println("Natural number series");
			int lastele = a[0] + (n - 1);
            if(lastele == a[n-1])
                return 0;
			else{
				diff = actualTotal - total;
				return diff;
			}
		}
	
	}
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Enter size of the array:");
		int n = in.nextInt();
		int res = 0;
		int type = 0;
		int[] arr = new int[n];
		System.out.println("\nEnter Elements:");
		for(int i =0 ;i < n; i++){
			arr[i] = in.nextInt();
		}
		type = checkType(arr);
		if(type == 1){
			res = findMissing(arr, n, type);
			if(res == 0)
				System.out.println("No missing values in the given array");
			else
				System.out.println("Missing number is " + res);
		}
		else if(type == 2){
			res = findMissing(arr, n, type);
			if(res == 0)
				System.out.println("No missing values in the given array");
			else
				System.out.println("Missing number is " + res);
		}
		else{
			res = findMissing(arr, n, type);
			if(res == 0)
				System.out.println("No missing values in the given array");
			else
				System.out.println("Missing number is " + res);
		}

				
	}
}