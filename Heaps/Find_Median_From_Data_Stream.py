'''
295. Find Median from Data Stream
Solved
Hard
Topics
Companies
The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 

Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.
 

Follow up:

If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?

'''

import heapq

class MedianFinder:

    def __init__(self):
        self.large, self.small = [], []  # min-heap (large) and max-heap (small) with negated values

    def addNum(self, num: int) -> None:
        # Always push the number into the correct heap
        if self.small and (-1 * num) > self.small[0]:
            heapq.heappush(self.small, -1 * num)  # Push into max-heap (negate)
        else:
            heapq.heappush(self.large, num)  # Push into min-heap

        # Balance the heaps if their size difference exceeds 1
        if len(self.small) > len(self.large) + 1:
            # Move element from small (max-heap) to large (min-heap)
            node = heapq.heappop(self.small)
            heapq.heappush(self.large, -1 * node)
        elif len(self.large) > len(self.small) + 1:
            # Move element from large (min-heap) to small (max-heap)
            node = heapq.heappop(self.large)
            heapq.heappush(self.small, -1 * node)

    def findMedian(self) -> float:
        # If one heap has more elements, return its top element
        if len(self.large) > len(self.small):
            return self.large[0]
        elif len(self.small) > len(self.large):
            return -1 * self.small[0]
        # Otherwise, return the average of the two top elements
        return (-1 * self.small[0] + self.large[0]) / 2.0

# Example usage:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
