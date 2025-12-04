class Solution {
    public int maxmoney(int i,int buy,int arr[],int dp[][]){
        if(i>=arr.length)return 0;
        int profit=0;
        if(dp[i][buy]!=-1)return dp[i][buy];
        if(buy==1){
            profit=Math.max((-arr[i]+maxmoney(i+1,0,arr,dp)),maxmoney(i+1,1,arr,dp));
        }
        else{
            profit=Math.max((arr[i]+maxmoney(i+2,1,arr,dp)),maxmoney(i+1,0,arr,dp));
        }
        return dp[i][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){Arrays.fill(dp[i],-1);}
        return maxmoney(0,1,prices,dp);
    }
}