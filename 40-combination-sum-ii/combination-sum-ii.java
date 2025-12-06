class Solution {
    public void backtracking(int index, int[] arr, int target, 
                             List<List<Integer>> result, List<Integer> now) {

        if (target == 0) {
            result.add(new ArrayList<>(now));
            return;
        }

        for (int i = index; i < arr.length; i++) {

            // Skip duplicates at the same recursion depth
            if (i > index && arr[i] == arr[i - 1]) continue;

            // Stop early because array is sorted
            if (arr[i] > target) break;

            now.add(arr[i]);
            backtracking(i + 1, arr, target - arr[i], result, now);  // move to next index
            now.remove(now.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        backtracking(0, arr, target, result, new ArrayList<>());
        return result;
    }
}
