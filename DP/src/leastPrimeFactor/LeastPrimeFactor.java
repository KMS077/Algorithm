package leastPrimeFactor;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author abhishek-2863
 *
 *Given a number N, print least prime factors for all numbers from 1 to N.  The least prime factor of an integer N is the smallest prime number that divides it. The least prime factor of all even numbers is 2. A prime number is its own least prime factor (as well as its own greatest prime factor).  Note : 1 needs to be printed for 1.

Input: N = 6
Output: 1 2 3 2 5 2
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N.

Output:
Print least prime factors separated by space


Constraints:
1 ≤ T ≤ 200
2 ≤ N ≤ 1000

Example:
Input:
2
6
10

Output:
1 2 3 2 5 2
1 2 3 2 5 2 7 2 3 2
 */



public class LeastPrimeFactor {

	static boolean[] primes;
	static Map<Integer,Integer> resultset = new LinkedHashMap<>();
	public static void main(String[] args) {
		List<Integer> input = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int numberOfInputs = sc.nextInt();
		for(int i=0;i<numberOfInputs;i++){
			input.add(sc.nextInt());
		}
		
		int max=Collections.max(input);
		primes = new boolean[max+1];
		primeNumberDetector();
	
		for(int n : input){	
		System.out.print(1+" ");
		for(int i=2;i<=n;i++){
			if(i%2==0){
				System.out.print(2+" ");
			}else{
			System.out.print(resultset.get(i)+" ");
			}
		}
		System.out.println();
		
	}
	}

	public static void primeNumberDetector() {
	    Arrays.fill(primes,true);        // assume all integers are prime.
	    primes[0]=primes[1]=false;       // we know 0 and 1 are not prime.
	    for (int i=2;i<primes.length;i++) {
	        //if the number is prime,
	        //then go through all its multiples and make their values false.
	        if(primes[i]) {
	        		resultset.put(i, i);
	            for (int j=2;i*j<primes.length;j++) {
	                primes[i*j]=false;
	               if(!resultset.containsKey(i*j)){
	            	   resultset.put(i*j, i);
	               }
	            }
	        }
	    }
	}
	
}
