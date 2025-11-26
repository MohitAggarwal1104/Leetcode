class Solution {
    public int count(int n,int sum,int arr[],int dp[][]){
        if(sum==0)return 1;
        if(n==0){
            if(sum%arr[n]==0)return 1;
            else return 0;
        }
        if(dp[n][sum]!=-1)return dp[n][sum];
        int Nottake=count(n-1,sum,arr,dp);
        int take=0;
        if(arr[n]<=sum)take=count(n,sum-arr[n],arr,dp);
        return dp[n][sum]=Nottake+take;
    }
    public int change(int amount, int[] coins) {
        int dp[][]=new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++)Arrays.fill(dp[i],-1);
        return count(coins.length-1,amount,coins,dp);
    }
}