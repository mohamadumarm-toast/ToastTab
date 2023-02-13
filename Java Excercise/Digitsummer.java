import java.util.Scanner;
public class Digitsummer{
	
	public static int countDigits(long n){
		String num = n+"";
		return num.length();
	}
	
	public static long addDigits(long n){
		long res = 0;
		while(n != 0){
			res = res + (n%10);
			n = n / 10;
		}
		return res;
	}
	
	
	public static void main(String[] args){
		System.out.print("Enter a number: ");
		Scanner sin = new Scanner(System.in);
		long num = sin.nextLong();
		long temp = num;
		while(countDigits(temp)!=1){
			temp = addDigits(temp);
		}
		System.out.print("Answer is " + temp);
	}
}