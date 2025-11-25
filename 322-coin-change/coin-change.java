class Solution {
    public int mincoin(int n,int target,int coins[],int dp[][]){
        if(n==0){
            if(target%coins[n]==0)return target/coins[n];
            else return (int)1e9;
        }
        if(dp[n][target]!=-1)return dp[n][target];
        int nottake=0+mincoin(n-1,target,coins,dp);
        int take=Integer.MAX_VALUE;
        if(coins[n]<=target){
            take=1+mincoin(n,target-coins[n],coins,dp);
        }
        return dp[n][target]=Math.min(nottake,take);

    }
    public int coinChange(int[] coins, int amount) {
        // int dp[][]=new int[coins.length][amount+1];
        // for(int i=0;i<coins.length;i++)Arrays.fill(dp[i],-1);
        // int ans=mincoin(coins.length-1,amount,coins,dp);
        // if(ans!=(int)1e9)return ans;
        // else return -1;   

        int dp[][]=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++)Arrays.fill(dp[i],-1);

        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0)dp[0][i]=i/coins[0];
            else dp[0][i]=(int)1e9;
        }

        for(int i=1;i<coins.length;i++){
            for(int j=0;j<=amount;j++){
                int nottake=0+dp[i-1][j];
                int take=Integer.MAX_VALUE;
                if(coins[i]<=j){
                    take=1+dp[i][j-coins[i]];
                }
                dp[i][j]=Math.min(nottake,take);
            }
        }
        int ans=dp[coins.length-1][amount];
        if(ans!=(int)1e9)return ans;
        else return -1;
    }
}