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
        if (prices.length == 0) return 0;
        // int n=prices.length;
        // int dp[][][]=new int[n][2][3];
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<2;j++)Arrays.fill(dp[i][j],-1);
        // }

        // return maxmoney(0,1,2,prices,dp);


        // //tabulation code

        // int n=prices.length;
        // int dp[][][]=new int[n+1][2][3];
        // // for(int i=0;i<=n;i++){
        // //     for(int j=0;j<2;j++)Arrays.fill(dp[i][j],-1);
        // // }
        // // // cap==0 wala case
        // // for(int i=0;i<=n;i++)for(int j=0;j<2;j++)dp[i][j][0]=0;

        // // //ind==n wala case
        // // for(int i=0;i<2;i++)for(int j=0;j<3;j++)dp[n][i][j]=0;


        // for(int i=n-1;i>=0;i--){
        //     for(int buy=0;buy<2;buy++){
        //         for(int k=1;k<3;k++){
        //             int profit=0;
        //             if(buy==1){
        //                 profit=Math.max((-prices[i]+dp[i+1][0][k]),dp[i+1][1][k]);
        //             }
        //             else{
        //                 profit=Math.max((prices[i]+dp[i+1][1][k-1]),dp[i+1][0][k]);
        //             }
        //             dp[i][buy][k]=profit;
        //         }
        //     }
        // }

        // return dp[0][1][2];

        // //tabulation code

        // int n=prices.length;
        // int after[][]=new int[2][3];
        // int curr[][]=new int[2][3];
        // for(int i=n-1;i>=0;i--){
        //     for(int buy=0;buy<2;buy++){
        //         for(int k=1;k<3;k++){
        //             int profit=0;
        //             if(buy==1){
        //                 profit=Math.max((-prices[i]+after[0][k]),after[1][k]);
        //             }
        //             else{
        //                 profit=Math.max((prices[i]+after[1][k-1]),after[0][k]);
        //             }
        //             curr[buy][k]=profit;
        //         }
        //     }
        //     after=curr;
        // }

        // return after[1][2];

        int cap=2;
         int n = prices.length;
        int dp[][] = new int[2][cap+1];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 1; buy >= 0; buy--) {
                for (int k = cap; k >= 1; k--) {

                    if (buy == 1) {
                        dp[buy][k] = Math.max(-prices[i] + dp[0][k],dp[1][k]);
                    } else {
                        dp[buy][k] = Math.max( prices[i] + dp[1][k - 1],dp[0][k]);
                    }
                }
            }
        }

        return dp[1][cap];

    }
}