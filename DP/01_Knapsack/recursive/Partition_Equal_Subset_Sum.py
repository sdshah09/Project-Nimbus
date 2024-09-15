'''
416. Partition Equal Subset Sum
Solved
Medium
Topics
Companies
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100

'''
from typing import List
class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        if sum(nums)%2!=0:
            return False
        target = sum(nums)//2
        dp = [[-1 for _ in range(target+1)] for _ in range(len(nums)+1)]
        def recurse(nums,target,index,dp):
            if index==0 and target!=0:
                return False
            if index==0 and target==0:
                return True
            if dp[index][target]!=-1:
                return dp[index][target]
            dp[index][target] = recurse(nums,target-nums[index-1],index-1,dp) or recurse(nums,target,index-1,dp)
            return dp[index][target]
        return recurse(nums,target,len(nums),dp)

