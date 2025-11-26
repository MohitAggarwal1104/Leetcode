class Solution {
    public int findAll(int i ,int sum,int target,int arr[]){
        if(i==0){
            if(sum+arr[i]==target && sum-arr[i]==target)return 2;
            else if(sum+arr[i]==target )return 1;
            else if(sum-arr[i]==target)return 1;
            else return 0;
        }
        int neg=findAll(i-1,sum-arr[i],target,arr);
        int pos=findAll(i-1,arr[i]+sum,target,arr);
        return neg+pos;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return findAll(nums.length-1,0,target,nums);   
    }
}