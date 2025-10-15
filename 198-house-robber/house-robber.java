class Solution {
    public int robHelper(int index,int nums[],int dp[]){
        if(index==0)return nums[index];
        if(index<0)return 0;
        if(dp[index]!=-1)return dp[index];
        int pick=nums[index]+robHelper(index-2,nums,dp);
        int notPick=0+robHelper(index-1,nums,dp);
        dp[index]=Math.max(pick,notPick);
        return Math.max(pick,notPick);
    }
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp, -1);
        return robHelper(nums.length-1,nums,dp);

    }
}
