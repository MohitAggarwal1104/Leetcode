class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int prev = 0; // max up to i-1
        int curr = 0; // max up to i
        for (int n : nums) {
            int next = Math.max(curr, prev + n);
            prev = curr;
            curr = next;
        }
        return curr;
    }
}
