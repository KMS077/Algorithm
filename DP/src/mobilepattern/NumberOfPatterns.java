package mobilepattern;

public class NumberOfPatterns {

	public static void main(String[] args) {
		int overall = 0;
		int minlen=1;
		int maxlen=9;
		for(int i=minlen;i<=maxlen;i++){
		int cornercount = patternCount('c',i,true);
		int edgecount = patternCount('e',i,true);
		int centercount = patternCount('m',i,true);
		System.out.println("-------------------------- len = "+ i +"--------------------------------------");
		System.out.println("corner count : "+cornercount +"\negde count : "+edgecount +"\ncenter count : "+centercount);
		int total = (4*cornercount+4*edgecount+centercount);
		System.out.println("total patterns : "+ total);
		overall+=total;
		}
		
		System.out.println(" ------------ total = "+overall+" ---------------------------");
		
	}
	
	public static int patternCount(char k , int count , boolean firstCall){
		if(k=='c'){
			if(count==1){
				if(firstCall){
					return 3;
				}
				return 2;
			}
			return (2*patternCount('e',count-1,false)+patternCount('m',count-1,false));
		}
		if(k=='m'){
			if(count==1){
				if(firstCall){
					return 8;
				}
				return 7;
			}
			return (4*patternCount('e',count-1,false)+4*patternCount('c',count-1,false));
		}
		if(k=='e'){
			if(count==1){
				if(firstCall){
					return 5;
				}
				return 4;
			}
			return (2*patternCount('c',count-1,false)+2*patternCount('e',count-1,false)+patternCount('m',count-1,false));
		}
		return 0;
	}
}
