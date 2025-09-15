class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String arr[] = text.split(" ");
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            boolean truth = true;
            for (int j = 0; j < brokenLetters.length(); j++) {
                if (arr[i].contains(String.valueOf(brokenLetters.charAt(j)))) { 
                    truth = false;
                    break;
                }
            }
            if (truth) count++;
        }
        return count;
    }
}
