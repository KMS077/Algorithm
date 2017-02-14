package longestCommonSubsequence;

import java.util.Scanner;
/**
 * 
 * @author abhishek-2863
 *	Recursive approach : just to get the LCS count.
 */
public class LCS {
	public static String lcsString="";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] str1=sc.nextLine().toCharArray();
		char[] str2=sc.nextLine().toCharArray();
		int lcscount= lcsCount(str1,str1.length-1,str2,str2.length-1);
		 System.out.println(" Longest Common Subsequence count is : "+ lcscount);
		 
		
	}
	
	public static int lcsCount(char[] str1,int index1,char[] str2,int index2){
		if(index1<0||index2<0){
			return 0;
		}
		if(str1[index1]==str2[index2]){
			return 1+lcsCount(str1, index1-1, str2, index2-1);
		}
		return Math.max(lcsCount(str1, index1, str2, index2-1), lcsCount(str1, index1-1, str2, index2));
	}
	
	
}
