import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // why 0/1 knapsack
        // choices
        // k --> capacity/ sum
        // uniqueness

        // [4,3,2,1], k = 5
        // rec(idx - 1, k - arr[idx - 1]) || rec(idx - 1, k)
        boolean[][] dp = new boolean[n + 1][k + 1];

        // initialization
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][k];
    }
    // TC : O(n * k)
    // SC : O(n * k)
}
