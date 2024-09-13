/* 463. Island Perimeter
You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

Example 1:
  Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
  Output: 16
  Explanation: The perimeter is the 16 yellow stripes in the image above.

Example 2:
  Input: grid = [[1]]
  Output: 4

Example 3:
  Input: grid = [[1,0]]
  Output: 4
*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int perimeter = 0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1){
                    queue.add(new int[] {i,j});
                    grid[i][j]=9;//visited

                    while(!queue.isEmpty()){
                        int[] node = queue.poll();

                        //check all 4 directions
                        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};

                        for(int[] dir : directions){
                            int r = dir[0] + node[0];
                            int c = dir[1] + node[1];

                            if(r<0 || c<0 || r>=row || c>=col || grid[r][c] ==0){
                                perimeter++;
                            }
                            else if(grid[r][c] == 1){
                                    queue.add(new int[] {r,c});
                                    grid[r][c] = 9;//visited
                            }
                        }
                    }
                }
            }
        }
        return perimeter;
    }    
}
