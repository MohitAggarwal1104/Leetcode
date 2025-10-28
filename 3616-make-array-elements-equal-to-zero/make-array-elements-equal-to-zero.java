class Solution {
    public int countValidSelections(int[] nums) {
        int count = 0;
        int total = 0;
        for (int x : nums) total += x;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int leftSum = 0;
                for (int j = 0; j < i; j++) leftSum += nums[j];
                int rightSum = total - leftSum;
                if (leftSum == rightSum) count += 2;
                else if (Math.abs(leftSum - rightSum) == 1) count += 1;
            }
        }
        return count;
    }
}
