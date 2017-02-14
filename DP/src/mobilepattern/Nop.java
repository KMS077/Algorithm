package mobilepattern;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Nop {
	public static Map<Integer,List<Integer>> pathMap = new LinkedHashMap<Integer,List<Integer>>();
	public static void main(String[] args) {
		for(int i=1;i<10;i++){
		pathMap.put(i, new LinkedList<Integer>());
		}
		
		pathMap.get(1).add(2);
		pathMap.get(1).add(5);
		pathMap.get(1).add(4);
		
		
		
		
	}
	
}
