class Solution {
    public int f(int i,int j,int[]cuts,int dp[][]){
        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int mini=(int)1e9;

        for(int k=i;k<=j;k++){
            int cost=cuts[j+1]-cuts[i-1]+f(i,k-1,cuts,dp)+f(k+1,j,cuts,dp);
            mini=Math.min(mini,cost);
        }
        return dp[i][j]=mini;
    }
    public int minCost(int n, int[] cuts) {
        // int cuts2[]=new int[cuts.length+2];
        // Arrays.sort(cuts);
        // cuts2[0]=0;
        // cuts2[cuts.length+1]=n;
        // for(int i=0;i<cuts.length;i++)cuts2[i+1]=cuts[i];
        // int dp[][]=new int[cuts.length+1][cuts.length+1];
        // for(int i=0;i<cuts.length+1;i++)Arrays.fill(dp[i],-1);
        // return f(1,cuts.length,cuts2,dp);


        int cuts2[]=new int[cuts.length+2];
        Arrays.sort(cuts);
        cuts2[0]=0;cuts2[cuts.length+1]=n;
        for(int i=0;i<cuts.length;i++)cuts2[i+1]=cuts[i];
        int dp[][]=new int[cuts.length+2][cuts.length+2];

        for(int i=cuts.length;i>=1;i--){
            for(int j=1;j<=cuts.length;j++){
                int mini=(int)1e9;
                if(i>j)continue;
                for(int k=i;k<=j;k++){
                    int cost=cuts2[j+1]-cuts2[i-1]+dp[i][k-1]+dp[k+1][j];
                    mini=Math.min(mini,cost);
                }
                dp[i][j]=mini;
            }
        }
        return dp[1][cuts.length];
    }
}