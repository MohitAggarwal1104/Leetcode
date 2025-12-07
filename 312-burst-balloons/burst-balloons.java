class Solution {
    public int f(int i,int j,int nums[],int dp[][]){

        if(i>j)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        int cost=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int costing=nums[i-1]*nums[k]*nums[j+1]+f(i,k-1,nums,dp)+f(k+1,j,nums,dp);
            cost=Math.max(cost,costing);
        }
        return dp[i][j]=cost;
    }
    public int maxCoins(int[] nums) {
        // int n=nums.length;
        // int nums2[]=new int[n+2];
        // int dp[][]=new int[n+2][n+2];
        // nums2[0]=1;nums2[n+1]=1;
        // for(int i=0;i<n;i++)nums2[i+1]=nums[i];
        // for(int i=0;i<n+2;i++)Arrays.fill(dp[i],-1);
        // return f(1,n,nums2,dp);
        int n=nums.length;
        int nums2[]=new int[n+2];
        int dp[][]=new int[n+2][n+2];
        nums2[0]=1;nums2[n+1]=1;
        for(int i=0;i<n;i++)nums2[i+1]=nums[i];

        for(int i=n;i>=1;i--){
            for(int j=0;j<=n;j++){
                int cost=Integer.MIN_VALUE;
                if(i>j)continue;
                for(int k=i;k<=j;k++){
                    int costing=nums2[i-1]*nums2[k]*nums2[j+1]+dp[i][k-1]+dp[k+1][j];
                    cost=Math.max(cost,costing);
                }
                dp[i][j]=cost;
            }
        }
        return dp[1][n];
    }
}