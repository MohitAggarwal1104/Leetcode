class Solution {
    public int minOperations(int[] nums) {
        int []stack = new int[nums.length + 1];
        int  top = 0;
        int ans = 0;
        for (int  i = 0; i < nums.length; i++) {
            while (stack[top] > nums[i]) {
                top--;
                ans++;
            }
            if (stack[top] != nums[i])
                stack[++top] = nums[i];
        }
        return ans + top;
    }
}
// class Solution {
//     public int minOperations(int[] arr) {
//         int count = 0;
//         int n = arr.length;

//         while (true) {
//             boolean changed = false;
//             int i = 0;

//             while (i < n) {
//                 // skip zeros
//                 if (arr[i] == 0) {
//                     i++;
//                     continue;
//                 }

//                 // find one continuous non-zero subarray
//                 int j = i;
//                 int mini = Integer.MAX_VALUE;
//                 while (j < n && arr[j] != 0) {
//                     mini = Math.min(mini, arr[j]);
//                     j++;
//                 }

//                 // subtract the minimum from the entire segment
//                 for (int k = i; k < j; k++) {
//                     arr[k] -= mini;
//                 }

//                 changed = true;
//                 count++;   // one operation done for this segment
//                 i = j;
//             }

//             if (!changed) break;  // all elements are zero
//         }

//         return count;
//     }
// }
