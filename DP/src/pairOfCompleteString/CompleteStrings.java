package pairOfCompleteString;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CompleteStrings {

	public static void main(String[] args) {
		
		List<String> set1 = new LinkedList<>();
		List<String> set2 = new LinkedList<>();
		Set<Character> finalset =  new HashSet<>();
		
		set1.add("abcdefgh");
		set1.add("geeksforgeeks");
		set1.add("lmnopqrst");
		set1.add("abc");
		
		set2.add("ijklmnopqrstuvwxyz");
		set2.add("abcdefghijklmnopqrstuvwxyz");
		set2.add("defghijklmnopqrstuvwxyz");
		
		String stringFromSet2="";
		int outercount;
		int innercount=0;
		for(String str1: set1){
			outercount=0;
			finalset.clear();
			for(Character ch : str1.toCharArray()){
				if(finalset.add(ch)){
				outercount++;
				}
			}
			
			for(String str2: set2){
				stringFromSet2=str2;
				innercount=0;
				for(Character ch : str2.toCharArray()){
					if(finalset.add(ch)){
						finalset.remove(ch);
						innercount++;
					}
				}
			
				if((outercount+innercount) >=26){
					System.out.println("complete string pair : "+str1+"  &  "+stringFromSet2);
				}
				
			}
		}
	}
}
 