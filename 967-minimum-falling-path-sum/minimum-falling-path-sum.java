class Solution {
    public int now(int i,int j,int dp[][],int matrix[][]){
        if(i<0 || j <0 || i>=matrix.length || j>=matrix[0].length)return (int)1e9;
        if(i==matrix.length-1)return matrix[i][j];
        if(dp[i][j]!=Integer.MAX_VALUE)return dp[i][j];

        int Ldiagonal=matrix[i][j]+now(i+1,j-1,dp,matrix);
        int down=matrix[i][j]+now(i+1,j,dp,matrix);
        int Rdiagonal=matrix[i][j]+now(i+1,j+1,dp,matrix);

        return dp[i][j]=Math.min(Ldiagonal,Math.min(down,Rdiagonal));
    }
    public int minFallingPathSum(int[][] matrix) {
        // int min=Integer.MAX_VALUE;
        // int dp[][]=new int[matrix.length][matrix[0].length];
        // for(int i=0;i<matrix.length;i++)Arrays.fill(dp[i],Integer.MAX_VALUE);

        // for(int i=0;i<matrix.length;i++){
        //     int n=now(0,i,dp,matrix);
        //     if(min>n)min=n;
        // }
        // return min;
        int n=matrix.length;
        int min=Integer.MAX_VALUE;
        int dp[]=new int[matrix[0].length];
        for(int i=0;i<matrix[0].length;i++)dp[i]=matrix[n-1][i];

        for(int i=n-2;i>=0;i--){
            int temp[]=new int[matrix[0].length];
            for(int j=0;j<matrix[0].length;j++){
                int Ldiagonal=(int)1e9;
                int Rdiagonal=(int)1e9;
                if(j-1>=0)Ldiagonal=matrix[i][j]+dp[j-1];
                int down=matrix[i][j]+dp[j];
                if(j+1<matrix[0].length)Rdiagonal=matrix[i][j]+dp[j+1];
                temp[j]=Math.min(Ldiagonal,Math.min(down,Rdiagonal));
            }
            dp=temp;
        }
        for(int i=0;i<dp.length;i++)if(dp[i]<min)min=dp[i];
        return min;
    }
}