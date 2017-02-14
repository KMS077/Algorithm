package longestCommonSubsequence;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/**
 * 
 * @author abhishek-2863
 * most effective soultion , with a slight extra space complexity 
 * we are getting the LCS 
 */
public class Lcs_eff {

	public static Map<Character,List<Integer>> commonCharMap = new LinkedHashMap<Character,List<Integer>>();
	public static Integer currIndex ;
	public static void main(String[] args) {
	/*	char[] str1="GXTXAYB".toCharArray();
		char[] str2="AGGTAB".toCharArray();*/
		
		char[] str1="AGTABXGSTSFGREDRYYYYCFRDSAED".toCharArray();
		char[] str2="AGXSRXXXXXESAD".toCharArray();
		
		Character firstMatch = null;
		
		for(int i=0;i<str2.length;i++){
			commonCharMap.put(str2[i],new LinkedList<Integer>());
		}
		
		for(int i=0;i<str1.length;i++){
			char key = str1[i];
			// from str1 update the location of those chars which are present in the str2
			if(commonCharMap.containsKey(key)){
				if(firstMatch==null){
					firstMatch=key;
				}
				commonCharMap.get(key).add(i);
			}
		}
		currIndex = Integer.MIN_VALUE;
		System.out.println("map : "+ commonCharMap.toString());
		int mapSize = commonCharMap.size();
		boolean start = false;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<str2.length;i++){
			if(str2[i]==firstMatch){
				start=true;
			}
			if(start){
				if(isValidCommonChar(str2[i],currIndex)){
					sb.append(str2[i]);
					System.out.println(str2[i]);
				}
			}
		}
		
		System.out.println(" lcs : "+sb.toString());
		
			
		
	}
		
	public static boolean isValidCommonChar (char key , int index){
		List<Integer> localList = new LinkedList<>();
		localList=commonCharMap.get(key);
		
		if(localList.size()==0){
			return false;
		}
		int size = localList.size();
		for(int i=0 ;i< size;i++){
			if(localList.get(i)>index){
				currIndex = localList.get(i);
				commonCharMap.get(key).remove(i);
				return true;
			}/*
			better don't remove b/c at run time it remove and shift the element and due to which you will get runtime exception.
			else{
				commonCharMap.get(key).remove(i);
			}*/
		}
		return false;
	}
}
