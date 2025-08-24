class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
        }

        return candidate;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        // }
        // for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
        //     int var1=entry.getKey();
        //     int var2=entry.getValue();
        //     if(var2>nums.length/2)return var1;
        // }
        // return -1;
}
}