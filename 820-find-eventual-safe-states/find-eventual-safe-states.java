class Solution {
    public boolean dfs(int node,int V, int vis[], int pathvis[],int graph[][]){
        vis[node]=1;
        pathvis[node]=1;
        for(int i : graph[node]){
            if(vis[i]==0){
                if(dfs(i,V,vis,pathvis,graph))return true;
            }
            else if(pathvis[i]==1)return true;
        }
        pathvis[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        int vis[]=new int[V];
        int pathvis[]=new int[V];
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(vis[i]==0)dfs(i,V,vis,pathvis,graph);
        }
        for(int i=0;i<V;i++){
            if(pathvis[i]==0)list.add(i);
        }
        return list;
    }
}