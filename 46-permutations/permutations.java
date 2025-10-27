class Solution {
    public void swap(int index,int index2,int arr[]){
        int temp=arr[index];
        arr[index]=arr[index2];
        arr[index2]=temp;
    }
    public void Backtracking(List<List<Integer>> result,int arr[],int index){
        if(index==arr.length){
            List<Integer> list=new ArrayList<>();
            for(int i: arr)list.add(i);
            result.add(list);
        }

        for(int i=index;i<arr.length;i++){
            swap(i,index,arr);
            Backtracking(result,arr,index+1);
            swap(i,index,arr);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Backtracking(result,nums,0);
        return result;

    }
}