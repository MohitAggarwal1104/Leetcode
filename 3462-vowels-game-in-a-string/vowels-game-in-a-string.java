class Solution {
    public boolean doesAliceWin(String s) {
        String vowels = "aeiouAEIOU";
        int vowelsCount = 0;

        for (char c : s.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                vowelsCount++;
            }
        }

        return vowelsCount > 0;
    }
}
