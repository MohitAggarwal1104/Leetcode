class Solution {
    public int f(int i,int prev,int nums[],int dp[][]){
        if(i==nums.length)return 0;
        if(dp[i][prev+1]!=-1)return dp[i][prev+1];

        int len=f(i+1,prev,nums,dp);
        if(prev==-1 || nums[i]>nums[prev]){
            len=Math.max(len,1+f(i+1,i,nums,dp));
        }
        return dp[i][prev+1]=len;
    }
    public int lengthOfLIS(int[] nums) {
        // int n=nums.length;
        // int dp[][]=new int[n][n+1];
        // for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);
        // return f(0,-1,nums,dp);

        // int n=nums.length;
        // int dp[][]=new int[n+1][n+1];
        // for(int i=n-1;i>=0;i--){
        //     for(int prev=i-1;prev>=-1;prev--){
        //         int len=dp[i+1][prev+1];// prev+1 due to co ordinates shieft
        //         if(prev==-1 || nums[i]>nums[prev]){
        //             len=Math.max(len,1+dp[i+1][i+1]);
        //         }
        //         dp[i][prev+1]=len;
        //     }
        // }
        // return dp[0][0];

        // int n=nums.length;
        // // int dp[]=new int[n+1];
        // int curr[]=new int[n+1];
        // for(int i=n-1;i>=0;i--){
        //     for(int prev=i-1;prev>=-1;prev--){
        //         int len=curr[prev+1];// prev+1 due to co ordinates shieft
        //         if(prev==-1 || nums[i]>nums[prev]){
        //             len=Math.max(len,1+curr[i+1]);
        //         }
        //         curr[prev+1]=len;
        //     }
        // //    dp=curr;
        // }
        // return curr[0];

        // simple tabulation form

        int n=nums.length;
        int dp[]=new int[n];
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=i-1;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(1+dp[j],dp[i]);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max+1;
        }
}