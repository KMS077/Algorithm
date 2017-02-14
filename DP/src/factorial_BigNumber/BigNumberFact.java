package factorial_BigNumber;

import java.util.Scanner;

public class BigNumberFact {

	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String current="1";
		if (num < 0){
			   throw new Exception("Factorial of negative number is always infinity");
		}else if (num == 0 || num == 1){
			System.out.println("factorial : "+current);
		}else{
			for(int i=2;i<=num;i++){
				current = multi(current,i);
			}
			System.out.println("factorial : "+current);
		}
		
	}
	
	public static String multi(String current , int i){
		StringBuilder res = new StringBuilder();
		int len = current.length();
		int carry=0;
		int digit;
		int rem;
		for(int j=len-1;j>=0;j--){
			digit = Integer.parseInt(String.valueOf(current.charAt(j)))*i+carry;
			carry=digit/10;
			rem=digit%10;
			res.insert(0,rem);
		}
		if(carry!=0){
			res.insert(0, carry);
		}
		return res.toString();
	}
}
