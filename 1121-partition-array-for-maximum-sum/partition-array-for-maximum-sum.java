class Solution {
    public int f(int ind,int arr[],int dp[],int k,int n){
        if(ind==n)return 0;
        if(dp[ind]!=-1)return dp[ind];

        int length=0;int maxi=-1;int maxans=-1;
        for(int j=ind;j<Math.min(n,ind+k);j++){
            length++;
            maxi=Math.max(maxi,arr[j]);
            int sum=length*maxi+f(j+1,arr,dp,k,n);
            maxans=Math.max(maxans,sum);
        }
        return dp[ind]=maxans;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return f(0,arr,dp,k,n);

        // int n=arr.length;
        // int dp[]=new int[n+1];
        // dp[n]=0;
        // for(int ind=n-1;ind>=0;ind--){
        //         int length=0;int maxi=(int)-1e9;int maxans=(int)-1e9;
        //         for(int j=ind;j<Math.min(n,ind+k);j++){
        //             length++;
        //             maxi=Math.max(maxi,arr[j]);
        //             int sum=length*maxi+dp[j+1];
        //             maxans=Math.max(maxans,sum);
        //         }
        //         dp[ind]=maxans;
        // }
        // return dp[0];
    }
}