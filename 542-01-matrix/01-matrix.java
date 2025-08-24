class Pair{
    int first;
    int second;
    int step;
    public Pair(int first,int second,int step){
        this.first=first;
        this.second=second;
        this.step=step;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int result[][]=new int[n][m];
        int vis[][]=new int[n][m];

        Queue<Pair> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                else{
                    vis[i][j]=0;
                }
            }
        }

        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            int step=q.peek().step;
            q.remove();

            result[row][col]=step;

            int drow[]={-1,1,0,0};
            int dcol[]={0,0,-1,1};

            for(int i=0;i<4;i++){
                int nrow=row+drow[i];
                int ncol=col+dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol,step+1));
                }
            }
        }
        return result;
    }
}