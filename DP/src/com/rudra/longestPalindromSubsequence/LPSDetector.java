package com.rudra.longestPalindromSubsequence;

import java.lang.annotation.ElementType;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LPSDetector {

	public static Map<Character,List<Integer>> elementPair = new LinkedHashMap<Character,List<Integer>>();
	public static String  inputString = null;
	public static List<String> palindromeStr = new LinkedList<>();
	public static void main(String[] args){
		Scanner reader = new Scanner(System.in);
		inputString=reader.nextLine();
		char[] input = inputString.toCharArray();
		
		System.out.println(input);
		int input_length = input.length; 
		
		for(int i=input_length-1;i>=0;i--){
			if(!elementPair.containsKey(input[i])){
				List<Integer> firstVal = new LinkedList<>();
				firstVal.add(i);
				elementPair.put(input[i],firstVal);
			}else{
				elementPair.get(input[i]).add(i);
			}
		}
		
		System.out.println(elementPair.toString());
		
		// detection of the palindrome subsequence 
		for(List<Integer> listValue : elementPair.values()){
			if(listValue.size()>1){
			String palindrome = palindrome(listValue.get(listValue.size()-1), listValue.get(0));
			palindromeStr.add(palindrome);
			}
		}
		
	}
	
	public static String palindrome(int start , int end){
		
		
		if(end-start==2||end-start==1||end-start==0){
			return inputString.substring(start, end);
		}
		if(end-start==3){
			return inputString.charAt(start)+"("+inputString.charAt(start+1)+"|"+inputString.charAt(end-1)+")"+inputString.charAt(end);
		}
		
	}
		
	
	
	public static boolean isFromSameList(int start , int end){
		for(List<Integer> listValue : elementPair.values()){
			if(listValue.contains(start)&&listValue.contains(end)){
				return true;
			}
		}
		return false;
	}
}
