class Solution {
     public static void swap(int arr[],int low,int high){
        int temp=arr[low];
        arr[low]=arr[high];
        arr[high]=temp;
     }
    public void nextPermutation(int[] nums) {
     int index=-1;
     int n=nums.length;
     for(int i=n-2;i>=0;i--){
        if(nums[i]<nums[i+1]){
            index=i;
            break;
        }
     }
     if(index==-1){
        int low=0;int high=n-1;
        while(low<high){
            swap(nums,low,high);
            low++;
            high--;
        }
     }else{
     for(int i=n-1;i>index;i--){
        if(nums[i]>nums[index]){
            swap(nums,i,index);
            break;
        }
     }
     int low=index+1;
     int high=n-1;
     while(low<high){
        swap(nums,low,high);
        low++;
        high--;
     }
     }
    }
}