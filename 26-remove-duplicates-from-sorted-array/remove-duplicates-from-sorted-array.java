class Solution {
    public int removeDuplicates(int[] nums) {
        // int length = nums.length;
        // int Final = nums.length;
        // int nums1[]=new int[length];
        // int val=1;
        // nums1[0]=nums[0];
        // for(int i=1;i<length ; i++){
        //     if(nums[i]==nums[i-1]){
        //         Final--;
        //     }
        //     else{
        //         nums1[val]=nums[i];
        //         val++;
        //     }
        // }
        // for(int k=0;k<Final;k++){
        //     nums[k]=nums1[k];
        // }
        // return Final;
        if(nums.length==1){
            return 1;
        }
        int low=0;
        int high=1;
        int count=nums.length;
        while(low!=nums.length){
            if(nums[high]==nums[low]){
                count--;
                if(high==nums.length-1){
                    low=nums.length;
                }
                high++;
            }
            else{
                nums[low+1]=nums[high];
                low++;
                high++;
                if(high==nums.length){
                    low=nums.length;
                };
            }
        }
        return count;
    }
}