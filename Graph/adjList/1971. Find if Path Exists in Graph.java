/* 1971. Find if Path Exists in Graph
There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
You want to determine if there is a valid path that exists from vertex source to vertex destination.
Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise.

Example 1:
  Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
  Output: true
  Explanation: There are two paths from vertex 0 to vertex 2:
  - 0 → 1 → 2
  - 0 → 2

Example 2:
  Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
  Output: false
  Explanation: There is no path from vertex 0 to vertex 5.
*/


class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        //impl of adjList
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>()); // 0 ->[] , 1 ->[] , 2 ->[]
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]); // 0 -> [1,2]
            adjList.get(edge[1]).add(edge[0]); // 1 -> [0] , 2 -> [0]
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source); // 0
        visited[source] = true; // mark it as visited

        while(!queue.isEmpty()){
            int node = queue.poll();

            //main condition if we reach from source to destination
            if(node == destination){
                return true;
            }
            //now will get neighbours from adjList and make them as visited and add into 
            //queue and do the same
            for(int neighbor : adjList.get(node)){
                if(!visited[neighbor]){
                    queue.add(neighbor);
                    visited[neighbor] = true; //mark them visited then add to queue 
                }
            }
        }
        return false;
    }
}
