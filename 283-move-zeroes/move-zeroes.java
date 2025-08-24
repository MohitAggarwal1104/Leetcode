class Solution {
    public void moveZeroes(int[] nums) {
        // int low=0;
        // int h2=nums.length-1;
        // int high=1;
        // if(nums.length==1){
        //     low=nums.length;
        // }
        // while(low<=h2){
        //     if(nums[low]==0){
        //         if(nums[high]!=0){
        //             nums[low]=nums[high];
        //             nums[high]=0;
        //             low++;
        //             high=low+1;
        //             if(high==nums.length){
        //                 low=nums.length;
        //             }
        //         }
        //         else{
        //             high++;
        //             if(high==nums.length){
        //                 low=nums.length;
        //             }
        //         }
        //     }
        //     else{
        //         low++;
        //         high++;
        //          if(high==nums.length){
        //                 low=nums.length;
        //             }
        //     }
        // }
        int nonZeroIndex = 0; // Pointer for the position of the next nonzero element
        
        // Move all nonzero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex] = nums[i];
                nonZeroIndex++;
            }
        }
        
        // Fill the remaining positions with zero
        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex] = 0;
            nonZeroIndex++;
        }
    }
}