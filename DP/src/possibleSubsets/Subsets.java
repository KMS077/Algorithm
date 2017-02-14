package possibleSubsets;

public class Subsets {
	public static void main(String[] args) {
		int N=3;
		int allMasks = (1 << N);
		System.out.println("allmask : "+allMasks);
		for (int i = 1; i < allMasks; i++)
		{
			System.out.println(" binary of "+i+" is : "+Integer.toBinaryString(i));
		    for (int j = 0; j < N; j++)
		        if ((i & (1 << j)) > 0) //The j-th element is used
		           System.out.print((j + 1) + " ");
		    System.out.println();
		}
	}
}
