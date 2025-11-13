class Solution {
     public int recuPath(int i,int j,int dp[][],int mat[][]){
        if(i>=0 && j>=0 && mat[i][j]==1)return 0;
        if(i==0 && j==0)return 1;
        if(i< 0 || j < 0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int up=recuPath(i-1,j,dp,mat);
        int left=recuPath(i,j-1,dp,mat);
        return dp[i][j]=up+left;
    }
    public int uniquePathsWithObstacles(int[][] mat) {
        // Memoiation 

        int dp[][]=new int[mat.length][mat[0].length];

        for(int i=0;i<mat.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return recuPath(mat.length-1,mat[0].length-1,dp,mat);
    }
}