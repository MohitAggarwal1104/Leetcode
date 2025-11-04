class Solution {
    public int findKthLargest(int[] nums, int k) {
         PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
         for(int i : nums)maxHeap.add(i);
         for(int i=1;i<k;i++)maxHeap.poll();
         return maxHeap.poll();
    }
}