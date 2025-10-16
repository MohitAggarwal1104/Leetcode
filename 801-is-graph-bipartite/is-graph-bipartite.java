class Solution {
    //using dfs
    public boolean check(int i,int v,int color[],int graph[][],int curr){
        color[i]=curr;
         for(int p : graph[i]){
            if(color[p]==-1){
                if(check(p,v,color,graph,1-curr)==false)return false;
            }
            else if(color[p]==curr)return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        int color[]=new int[V];

        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(check(i,V,color,graph,0)==false)return false;
            }
        }

        return true;
    }
    //using bfs
    // public boolean check(int start,int V,int color[],int graph[][]){
    //     Queue<Integer> q=new LinkedList<>();
    //     q.add(start);
    //     color[start]=0;
    //     while(!q.isEmpty()){
    //         int node=q.peek();
    //         q.remove();

    //         for(int it : graph[node]){
    //             if(color[it]==-1){
    //                 color[it]=1-color[node];
    //                 q.add(it);
    //             }
    //             else if(color[it]==color[node])return false;
    //         }
    //     }
    //     return true;
    // }
    // public boolean isBipartite(int[][] graph) {
    //     int V=graph.length;
    //     int color[]=new int[V];

    //     Arrays.fill(color,-1);
    //     for(int i=0;i<V;i++){
    //         if(color[i]==-1){
    //             if(check(i,V,color,graph)==false)return false;
    //         }
    //     }

    //     return true;
    // }
}