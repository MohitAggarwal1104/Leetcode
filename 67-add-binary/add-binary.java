class Solution {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int aL = a.length() - 1;
        int bL = b.length() - 1;
        int carry = 0;

        while (aL >= 0 || bL >= 0 || carry > 0) {
            int sum = carry;
            
            if (aL >= 0) sum += a.charAt(aL--) - '0';
            if (bL >= 0) sum += b.charAt(bL--) - '0';
            
            str.insert(0, sum % 2);
            carry = sum / 2;
        }

        return str.toString();
    }
}
