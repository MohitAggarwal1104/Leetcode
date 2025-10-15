import java.util.*;

class Solution {
    public int robHelper(int index, int[] nums, int[] dp) {
        if (index == 0) return nums[0];
        if (index < 0) return 0;
        if (dp[index] != -1) return dp[index];

        int pick = nums[index] + robHelper(index - 2, nums, dp);
        int notPick = robHelper(index - 1, nums, dp);

        dp[index] = Math.max(pick, notPick);
        return dp[index];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Exclude last house
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int[] nums1 = Arrays.copyOfRange(nums, 0, n - 1);
        int res1 = robHelper(nums1.length - 1, nums1, dp1);

        // Exclude first house
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, n);
        int res2 = robHelper(nums2.length - 1, nums2, dp2);

        return Math.max(res1, res2);
    }
}
