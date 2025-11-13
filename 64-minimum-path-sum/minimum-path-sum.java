class Solution {
    public int minrecu(int i,int j,int dp[][],int a[][]){
        if(i==0 && j==0)return a[0][0];
        if(i<0 || j<0)return (int)1e9;

        if(dp[i][j]!=-1)return dp[i][j];

        int up=a[i][j]+minrecu(i-1,j,dp,a);
        int left=a[i][j]+minrecu(i,j-1,dp,a);

        return dp[i][j]=Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        return minrecu(m-1,n-1,dp,grid);
    }
}