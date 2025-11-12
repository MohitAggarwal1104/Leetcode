class pair{
    int first;
    int second;
    int thrid;
    pair(int f,int s,int t){
        this.first=f;
        this.second=s;
        thrid=t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<pair> list=new LinkedList<>();
        int vis[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    vis[i][j]=2;
                    list.add(new pair(i,j,0));
                }
            }
        }
        int dirR[]={0,0,1,-1};
        int dirC[]={1,-1,0,0};
        int answer=0;
        while(!list.isEmpty()){
            pair p=list.poll();
            int f=p.first;
            int s=p.second;
            int t=p.thrid;
            answer=t;
            for(int i=0;i<4;i++){
                int nrow=f+dirR[i];
                int ncol=s+dirC[i];

                if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=2;
                    list.add(new pair(nrow,ncol,t+1));
                }
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && vis[i][j]!=2)return -1;
            }
        }
        return answer;
    }
}