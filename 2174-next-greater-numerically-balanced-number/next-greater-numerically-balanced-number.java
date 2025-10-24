class Solution {
    
    // Function to check if a number is numerically balanced
    private boolean isBalanced(int num) {
        String s = String.valueOf(num);
        int[] count = new int[10];
        
        // Count frequency of each digit
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }
        
        // Check if each digit d occurs exactly d times
        for (char c : s.toCharArray()) {
            int d = c - '0';
            if (count[d] != d) return false;
        }
        return true;
    }
    
    public int nextBeautifulNumber(int n) {
        int num = n + 1;
        while (true) {
            if (isBalanced(num)) return num;
            num++;
        }
    }
}
