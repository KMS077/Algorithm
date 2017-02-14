package minimumCostPath;

import java.util.Scanner;

public class MinCostPath {

	public static int[][] parent ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		
		int[][] input = new int[rows][cols];
		parent = new int[rows][cols];
		for(int i =0;i<rows;i++){
			for(int j=0;j<cols;j++){
				input[i][j]=sc.nextInt();
			}
		}
		
		System.out.println("minimum cost "+minCostRec(input ,rows-1,cols-1,0,0));
		
		/**
		 * in order to trace the path , just traverse the parent array starting from 0,0
		 * and selecting those index whose val is minimum till you reach the value 0.
		 * 
		 *  in case if diagonal movement is not allowed.
		 *  then just find min among parent [i][j+1] and parent[i+1][j].
		 *  and then jump to the min index and then repeat the same process .
		 *  these jumps are the real trace to the min path.
		 *  
		 */
		for(int i=0;i<rows;i++){
			for(int j=0;j<cols;j++){
				System.out.print(parent[i][j]);
			}
			System.out.println();
		}
	}
	
	 public static int minCostRec(int cost[][], int m, int n, int x, int y){
	        if(x > m || y > n){
	            return Integer.MAX_VALUE;
	        }
	        if(x == m && y == n){
	            return cost[m][n];
	        }
	        
	        int t1 = minCostRec(cost, m , n, x+1, y);
	        int t2 = minCostRec(cost, m , n, x+1, y+1);
	        int t3 = minCostRec(cost, m , n, x, y+1);
	       
	        /**
	         * when only right and down movements are allowed.
	         * return cost[x][y] + min(t1,t3);
	         */
	        
	        // when right down and diagonal movements are allowed.
	        int result = min(t1,t2,t3);
	        parent[x][y]=cost[x][y] + result;
	        return cost[x][y] + result;
	    }
	 
	 public static int min(int a , int b, int c){
		 return Math.min(c, Math.min(a, b));
	 }
	 public static int min(int a , int b){
		 return Math.min(a, b);
	 }
	 
}
