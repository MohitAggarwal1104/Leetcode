class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Arrays.sort(nums);
        // for(int i=1;i<nums.length;i++){
        //     if(nums[i-1]==nums[i])return true;
        // }
        // return false;
         int j = 0, key = 0;
        for( int i=1; i<nums.length; i++ ){
            j = i-1;
            key = nums[i];

            while(j>=0 && nums[j] > key ){
                nums[j+1] = nums[j];
                j--; 
            }

            if ( j >= 0 && nums[j] == key ) return true;

            nums[j+1] = key;
        }
        return false;
    }
}