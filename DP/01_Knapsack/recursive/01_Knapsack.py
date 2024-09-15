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
        memo = [[-1 for _ in range(maxWeight + 1)] for _ in range(n + 1)]
        return self.recurse(weight, value, n, maxWeight, memo)
    
    def recurse(self, weight, value, index, maxWeight, memo):
        # Base case: if no items left or no capacity left
        if index == 0 or maxWeight == 0:
            return 0
        
        # If we've already computed this subproblem, return the memoized result
        if memo[index][maxWeight] != -1:
            return memo[index][maxWeight]
        
        # If the current item's weight exceeds the remaining capacity, skip it
        if weight[index - 1] > maxWeight:
            memo[index][maxWeight] = self.recurse(weight, value, index - 1, maxWeight, memo)
        else:
            # Choose the maximum of including or excluding the current item
            memo[index][maxWeight] = max(
                value[index - 1] + self.recurse(weight, value, index - 1, maxWeight - weight[index - 1], memo),
                self.recurse(weight, value, index - 1, maxWeight, memo)
            )
        
        return memo[index][maxWeight]