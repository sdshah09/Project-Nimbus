/* 200. Number of Islands
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
  Input: grid = [
    ["1","1","1","1","0"],
    ["1","1","0","1","0"],
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
  ]
  Output: 1

Example 2:
  Input: grid = [
    ["1","1","0","0","0"],
    ["1","1","0","0","0"],
    ["0","0","1","0","0"],
    ["0","0","0","1","1"]
  ]
  Output: 3
  */

class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        int row = grid.length;
        int col = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == '1'){
                    queue.add(new int[] {i,j});
                    grid[i][j]='0'; //mark it visited

                    while(!queue.isEmpty()){
                        int[] node = queue.poll(); //[0,0]

                        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
                        for(int[] dir : directions){
                            int r = dir[0] + node[0];
                            int c = dir[1] + node[1];

                            if(r>=0 && c>=0 && r<row && c<col && grid[r][c]=='1'){
                                queue.add(new int[] {r,c}); // if you found 1 then add to queue
                                grid[r][c] = '0'; // and then make it as visited
                            }
                        }
                    }count++;
                }   
            }
        }
        return count;
    }
}
