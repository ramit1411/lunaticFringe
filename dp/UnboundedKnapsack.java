package dp;

import java.util.Arrays;

public class UnboundedKnapsack {

	
	public static int UnboundKnap(int[] wt,int[] val,int W,int n) {
		
		int[][] t = new int[n+1][W+1];
		
		for(int i = 0;i<n+1;i++) {
			t[i][0] = 0;
		}
		
		for(int i = 0;i<W+1;i++) {
			t[0][i] = 0;
		}
		
		
		for(int i = 1;i<n+1;i++) {
			for(int j=1;j<W+1;j++) {
				if(wt[i-1] <= j) {
					t[i][j] = Math.max(val[i-1] + t[i][j-wt[i-1]] , t[i-1][j]);
				} else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		
		return t[n][W];
	}
	
	public static void main(String[] args) throws Exception {
		
		int[] wt = {1,3,4,5};
		int[] val = {1,4,5,7};
		int W = 7;
		int n = wt.length;
		
//		System.out.println(knapSackRecursive(wt,val,W,n));
		
//		for(int[] row : t) {
//			Arrays.fill(row, -1);
//		}
		
//		System.out.println(knapSackMemorization(wt,val,W,n));
		
		
		System.out.println(UnboundKnap(wt,val,W,n));
	}
}
