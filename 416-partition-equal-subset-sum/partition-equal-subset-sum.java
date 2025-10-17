class Solution {
    Boolean[][] dp;

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;

        if (total % 2 != 0) return false;

        int target = total / 2;
        dp = new Boolean[nums.length][target + 1];

        return subSetSum(nums, 0, 0, target);
    }

    private boolean subSetSum(int[] nums, int index, int current, int target) {
        if (current == target) return true;
        if (index >= nums.length || current > target) return false;
        if (dp[index][current] != null) return dp[index][current];

        boolean include = subSetSum(nums, index + 1, current + nums[index], target);
        boolean exclude = subSetSum(nums, index + 1, current, target);

        return dp[index][current] = include || exclude;
    }
}
