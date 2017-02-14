package find2missingNumbers;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class MissingNumbers {

	public static Set<Integer> numbers = new LinkedHashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		for(int i=0;i<number-2;i++){
			numbers.add(sc.nextInt());
		}
		System.out.println("missing numbers : ");
		for(int i=1;i<=number;i++){
			if(numbers.add(i)){
				System.out.print(i+" ");
			}
		}
		
	}
}
