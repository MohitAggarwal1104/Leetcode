import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // add current number
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

            // maintain window of size k
            if (i >= k) {
                int out = nums[i - k];
                freq.put(out, freq.get(out) - 1);
                if (freq.get(out) == 0) freq.remove(out);
            }

            // when window full
            if (i >= k - 1) {
                // sort by freq desc, value desc
                List<Map.Entry<Integer, Integer>> sorted = new ArrayList<>(freq.entrySet());
                sorted.sort((a, b) -> {
                    if (!a.getValue().equals(b.getValue()))
                        return b.getValue() - a.getValue(); // frequency desc
                    else
                        return b.getKey() - a.getKey();     // value desc
                });

                int sum = 0;
                int count = 0;
                for (Map.Entry<Integer, Integer> e : sorted) {
                    if (count == x) break;
                    sum += e.getKey() * e.getValue();
                    count++;
                }

                res.add(sum);
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
}
