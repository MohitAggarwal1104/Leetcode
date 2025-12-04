class Solution {
    public int maxmoney(int i,int buy,int cap,int arr[],int dp[][][]){
        if(i>=arr.length)return 0;
        if(cap==0)return 0;
        int profit=0;
        if(dp[i][buy][cap]!=-1)return dp[i][buy][cap];
        if(buy==1){
            profit=Math.max((-arr[i]+maxmoney(i+1,0,cap,arr,dp)),maxmoney(i+1,1,cap,arr,dp));
        }
        else{
            profit=Math.max((arr[i]+maxmoney(i+1,1,cap-1,arr,dp)),maxmoney(i+1,0,cap,arr,dp));
        }
        return dp[i][buy][cap]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n][2][3];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++)Arrays.fill(dp[i][j],-1);
        }

        return maxmoney(0,1,2,prices,dp);
    }
}