package stringInterleaving;

import java.util.LinkedList;
import java.util.List;

public class StringInterleaving {
	public static String str1="aab";
	public static String str2="axy";
	public static String str4="wz";
	public static String str3="aawxabzy";
	public static List<Character> sampleStr = null;
	public static int sampleStrLength = 0;
	public static void main(String[] args) {
	
		List<String> elementStr = new LinkedList<>();
		elementStr.add(str1);
		elementStr.add(str2);
		elementStr.add(str4);
		sampleStr = new LinkedList<>();
		
		for(char c : str3.toCharArray()){
			sampleStr.add(c);
		}
		sampleStrLength = sampleStr.size();
		for(String str : elementStr){
			for(int i=str.length()-1;i>=0;i--){
				if(!findElement(str.charAt(i), --sampleStrLength)){
					System.out.println(" not a case of string interleaving at char : "+str);
				}
			}
			sampleStrLength = sampleStr.size();
		}
	}
	
	public static boolean findElement(char element , int index){
		if(sampleStr.get(index)==element){
			sampleStr.set(index, ' ');
			return true;
		}
		if(index == 0){
			return false;
		}
		return findElement(element , --sampleStrLength );
	}
}
