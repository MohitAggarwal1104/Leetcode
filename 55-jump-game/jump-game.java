class Solution {
    public boolean canJump(int[] nums) {
        if(nums[0]==0 && nums.length==1)return true;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(i+nums[i]>max)max=i+nums[i];
            if(i+nums[i]==max)if(nums[i]==0 && i!=nums.length-1)return false;
        }
        return true;
    }
}