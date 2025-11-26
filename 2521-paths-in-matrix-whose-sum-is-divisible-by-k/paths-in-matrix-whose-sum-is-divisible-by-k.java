class Solution {
    public int paths(int n,int m,int [][]grid,int sum,int del[],int col[],int k,Integer dp[][][]){
        if(n<0 || m<0 )return 0;
        sum%=k;
        if(n==0 && m==0){
            if((sum+grid[n][m])%k==0)return 1;
            else return 0;
        }
        if(dp[n][m][sum] != null)return dp[n][m][sum];
        int min=0;
        for(int i=0;i<2;i++){
            int nrow=n+del[i];
            int ncol=m+col[i];
            min=(min+paths(nrow,ncol,grid,(sum+grid[n][m])%k,del,col,k,dp))%((int)1e9+7);
        }
        return dp[n][m][sum]=min;
    }
    public int numberOfPaths(int[][] grid, int k) {
        int delrow[] = {-1,0};
        int delcol[] = {0,-1};
        int n=grid.length;int m=grid[0].length;
        Integer dp[][][]= new Integer[n][m][k];
        return paths(n-1,m-1,grid,0,delcol,delrow,k,dp);
    }
}