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
        // int n=prices.length;
        // int dp[][]=new int[n][2];
        // for(int i=0;i<n;i++){Arrays.fill(dp[i],-1);}
        // return maxmoney(0,1,prices,dp);

        // int n=prices.length;
        // int dp[][]=new int[n+2][2];

        // for(int i=n-1;i>=0;i--){
        //     dp[i][1]=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
        //     dp[i][0]=Math.max((prices[i]+dp[i+2][1]),dp[i+1][0]);
        // }
        // return dp[0][1];

        int n=prices.length;
        int front1[]=new int[2];
        int front2[]=new int[2];
        int curr[]=new int[2];

        for(int i=n-1;i>=0;i--){
            curr[1]=Math.max(-prices[i]+front1[0],front1[1]);
            curr[0]=Math.max((prices[i]+front2[1]),front1[0]);

            front2 = front1.clone();
            front1 = curr.clone();

        }
        return curr[1];
    }
}