class Solution {
    public int subarraySum(int[] nums, int k) {
    //  int count=0;
    //  int sum=0;
    //  for(int i=0;i<nums.length;i++){
    //     sum=0;
    //     for(int j=i;j<nums.length;j++){
    //         sum+=nums[j];
    //         if(sum==k){
    //             count++;
    //         }
    //     }
    // }
    // return count;   
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0,1);
    int count=0;
    int presum=0;
    for(int i=0;i<nums.length;i++){
        presum+=nums[i];
        int remove=presum-k;
        count += map.getOrDefault(remove, 0);
            
            // Store the current prefix sum count
        map.put(presum, map.getOrDefault(presum, 0) + 1);
    }
    return count;
    }
}