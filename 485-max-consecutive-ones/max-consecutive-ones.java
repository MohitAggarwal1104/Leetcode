class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOne=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                count++;
            }
            else{
                if(count>maxOne){
                    maxOne=count;
                }
                count=0;
            }
            if(count>maxOne){
                    maxOne=count;
            }
        }
        return maxOne;
    }
}