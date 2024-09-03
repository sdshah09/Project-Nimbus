import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
      int[][] dp = new int[n + 1][maxWeight + 1];

      for (int i = 1; i < dp.length; i++) {
        for (int j = 1; j < dp[0].length; j++) {
          if (weight[i - 1] <= j) {
            dp[i][j] = Math.max(value[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);
          } else {
            dp[i][j] = dp[i - 1][j];
          }
        }
      }
      return dp[n][maxWeight];
    }
}
// TC : (items * capacity)
// SC : (items * capacity)
