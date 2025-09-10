class Solution {
    public boolean dfs(Map<Integer, List<Integer>> adjList,int source,int destination,int vis[]){
          if (source == destination) return true;  // base case
        vis[source]=1;
       for (int neighbor : adjList.getOrDefault(source, new ArrayList<>())) {
            if (vis[neighbor] == 0) {
                if (dfs(adjList, neighbor, destination, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        int vis[]=new int[n];

        return dfs(adjList,source,destination,vis);

    }
}