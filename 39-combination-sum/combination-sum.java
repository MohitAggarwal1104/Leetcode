class Solution {
    public void backtracking(int index,int arr[],int target,List<List<Integer>> result,List<Integer> now){
        if(index==arr.length){
            if(target==0)result.add(new ArrayList<>(now));
            return;
        }

        if(target<0)return;

        now.add(arr[index]);
        backtracking(index,arr,target-arr[index],result,now);

        now.remove(now.size()-1);
        backtracking(index+1,arr,target,result,now);
    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> result=new ArrayList<>();
        backtracking(0,arr,target,result,new ArrayList<>());
        return result;
    }
}