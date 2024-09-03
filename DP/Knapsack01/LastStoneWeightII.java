class Solution {
    public int lastStoneWeightII(int[] stones) {
        int range = Arrays.stream(stones).sum();
        boolean[] arr = subsetSum(stones, range);
        int minDiff = Integer.MAX_VALUE;
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            if (arr[i]) {
                return Math.min(minDiff, range - (2*i));
            }
        }
        return minDiff;
    }

     public boolean[] subsetSum(int[] nums, int sum) {
        boolean[][] memo = new boolean[nums.length + 1][sum + 1]; 

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                if (i == 0) {
                    memo[i][j] = false;
                }

                if (j == 0) {
                    memo[i][j] = true;
                }
            }
        }

        for (int i = 1; i < memo.length; i++) {
            for (int j = 1; j < memo[0].length; j++) {
                if (nums[i - 1] <= j) {
                    memo[i][j] = memo[i - 1][j - nums[i - 1]] || memo[i - 1][j];
                } else {
                    memo[i][j] = memo[i - 1][j];
                }
            }
        }
        return memo[nums.length];
    }
}
// TC : O (items * capacity)
// SC : O (items * capacity)
// TC and SC can be improved.
// Leetcode Link : https://leetcode.com/problems/last-stone-weight-ii
