class Solution {
    public int lengthOfLongestSubstring(String s) {
        StringBuilder str = new StringBuilder();
        int countmax = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = str.indexOf(String.valueOf(c));
            if (index == -1) {
                str.append(c);
            } else {
                str.delete(0, index + 1);
                str.append(c);
            }
            countmax = Math.max(countmax, str.length());
        }

        return countmax;
    }
}
