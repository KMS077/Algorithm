package coinchange_number_of_ways;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author abhishek-2863
 * this Programm is used to find the number of Ways in which a given set of coins {c1,c2,c3,...} can be selected to produce a sum = S
 * 
 * input :
 *  firstline contains 2 val 
 *   1: S  2:numberofCOins
 *  secondline contains coins value
 *  c1 c2 c3 
 */
public class NumberOfWays {

	public static List<String> numberStringList = new LinkedList<>();
	public static Map<Integer,String> numberStringMap =  new LinkedHashMap<>();
	public static void main(String[] args) {
		
		
		Scanner reader = new Scanner(System.in);
		int number = reader.nextInt();
		String sumStr = numberTo1s(number);
		numberStringList.add(sumStr);
		
		int number_of_coins = reader.nextInt();
		
		boolean coin1 = false;
		for(int i=0;i<number_of_coins;i++){
			int coin = reader.nextInt();
			if(coin !=1){
			String numtoStr = numberTo1s(coin);
			numberStringMap.put(coin, numtoStr);
			}else{
				coin1=true;
			}
		}
		
		for(int num : numberStringMap.keySet()){
			List<String> iterationSpecificList = new LinkedList<>();
			iterationSpecificList.addAll(numberStringList);
			for(String numString : iterationSpecificList){	
			permutationGenerator(num,numString);
			}
		}
		int count=0;
		System.out.println(" 1 is in the map : "+numberStringMap.containsKey(1));
		System.out.println("actual size is : "+numberStringList.size());
		for(String value : numberStringList){
			if(coin1){
				
				System.out.print(" | "+value);
				count++;
			}else{
				if(!value.contains("1")){
				System.out.print(" | "+value);
				count++;
				}
			}
		}
		
		System.out.println();
		System.out.println("total number of ways : "+ count);
	}
	
	public static boolean permutationGenerator(int num , String numberString){
		String coin = numberStringMap.get(num);
		
		int index = numberString.indexOf(coin);
		if(index==-1){
			return false;
		}
		String nextPermute = numberString.substring(0, index)+num+numberString.substring(index+coin.length());
		if(!numberStringList.contains(nextPermute)){	
			numberStringList.add(nextPermute);
		}
		return permutationGenerator(num,nextPermute);
		
	}
	
	public static String numberTo1s(int number){
		StringBuilder st = new StringBuilder();
		
		for(int i=0;i<number;i++){
			st.append("1");
		}
		return st.toString();
	}
}
