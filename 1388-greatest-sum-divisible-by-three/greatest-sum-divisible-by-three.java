// class Solution {
//     public int max(int[]nums,int i,int sum,int dp[][]){
//         if(i==0){
//             if((sum+nums[0])%3==0)return sum+nums[0];
//             else if(sum%3==0)return sum;
//             else return 0;
//         }
//         if(dp[i][sum]!=-1)return dp[i][sum];
//         int taken =max(nums,i-1,sum+nums[i],dp);
//         int nottaken=max(nums,i-1,sum,dp);
//         return dp[i][sum]=Math.max(taken,nottaken);
//     }
//     public int maxSumDivThree(int[] nums) {
//         int total=0;
//         for(int i : nums)total+=i;
//         int dp[][]=new int[nums.length][total];
//         for(int i=0;i<nums.length;i++)Arrays.fill(dp[i],-1);
//         return max(nums,nums.length-1,0,dp);
//     }
// }
// import java.util.Arrays;

// class Solution {
//     public int maxSumDivThree(int[] nums) {

//         int n = nums.length;
//         int total = 0;
//         for (int x : nums) total += x;

//         // dp[i][s] = max sum achievable using elements up to i with total sum = s
//         int dp[][] = new int[n][total + 1];

//         // initialize with -1 (meaning unreachable)
//         for (int i = 0; i < n; i++)
//             Arrays.fill(dp[i], -1);

//         // base case for i = 0
//         dp[0][0] = 0; // sum = 0 by not taking
//         dp[0][nums[0]] = nums[0]; // taking first element

//         // fill table
//         for (int i = 1; i < n; i++) {
//             for (int s = 0; s <= total; s++) {

//                 // NOT TAKEN
//                 if (dp[i - 1][s] != -1) {
//                     dp[i][s] = Math.max(dp[i][s], dp[i - 1][s]);
//                 }

//                 // TAKEN
//                 if (s - nums[i] >= 0 && dp[i - 1][s - nums[i]] != -1) {
//                     dp[i][s] = Math.max(dp[i][s], dp[i - 1][s - nums[i]] + nums[i]);
//                 }
//             }
//         }

//         // find maximum divisible by 3
//         int ans = 0;
//         for (int s = 0; s <= total; s++) {
//             if (dp[n - 1][s] != -1 && s % 3 == 0) {
//                 ans = Math.max(ans, dp[n - 1][s]);
//             }
//         }

//         return ans;
//     }
// }
class Solution {
    public int maxSumDivThree(int[] nums) {

        // dp[r] = maximum sum with remainder r
        int[] dp = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int num : nums) {
            int[] temp = dp.clone();

            for (int r = 0; r < 3; r++) {
                if (temp[r] != Integer.MIN_VALUE) {
                    int newSum = temp[r] + num;
                    dp[newSum % 3] = Math.max(dp[newSum % 3], newSum);
                }
            }
        }

        return dp[0]; // divisible by 3
    }
}


