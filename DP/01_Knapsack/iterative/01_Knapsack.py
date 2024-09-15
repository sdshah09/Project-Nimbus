'''
Problem statement
A thief is robbing a store and can carry a maximal weight of W into his knapsack. There are N items and the ith item weighs wi and is of value vi. Considering the constraints of the maximum weight that a knapsack can carry, you have to find and return the maximum value that a thief can generate by stealing items.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= T <= 10
1 <= N <= 10^2
1<= wi <= 50
1 <= vi <= 10^2
1 <= W <= 10^3

Time Limit: 1 second
Sample Input:
1 
4
1 2 4 5
5 4 8 6
5
Sample Output:
13

'''

class Solution:
    def knapsack(self, weight, value, n, maxWeight):
        # Initialize the memoization table with -1
        memo = [[0 for _ in range(maxWeight + 1)] for _ in range(n + 1)]
            # Base case: if no items left or no capacity left
        for i in range(1,n+1):
            for j in range(1,maxWeight+1):
                if weight[i-1]<=j:
                    memo[i][j] = max(value[i-1]+memo[i-1][j-weight[i-1]],memo[i-1][j]) 
                else:
                    memo[i][j] = memo[i-1][j]   
        
        return memo[n][maxWeight]

if __name__ == "__main__":
    sol = Solution()
    print(sol.knapsack([2,3,5],[20,10,25],3,5))