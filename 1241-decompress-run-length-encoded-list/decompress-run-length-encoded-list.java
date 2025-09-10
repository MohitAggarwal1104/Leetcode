class Solution {
    public int[] decompressRLElist(int[] nums) {
        // ArrayList<Integer>list=new ArrayList<>();
        // for(int i=0;i<nums.length;i++){
        //     if(i%2==0){
        //         int freq=nums[i];
        //         int val=nums[i+1];
        //         for(int j=0;j<freq;j++)list.add(val);
        //     }
        // }
        // int arr[]=new int[list.size()];
        // int count=0;
        // for(int i : list)arr[count++]=i;
        // return arr;
        int size = 0;
    for (int i = 0; i < nums.length; i+=2) {
        size += nums[i];
    }
    int [] result = new int [size];
    int index = 0;
    for (int i = 0; i < nums.length; i+=2) {
        int freq = nums[i];
        int val = nums[i + 1];
        for (int j = 0; j < freq; j++) {
            result[index] = val;
            index++;
        }
    }
    return result;
    }
}