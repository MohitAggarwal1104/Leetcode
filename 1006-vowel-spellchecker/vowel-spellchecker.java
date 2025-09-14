import java.util.*;

class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> exactWords = new HashSet<>();
        Map<String, String> caseInsensitive = new HashMap<>();
        Map<String, String> vowelMap = new HashMap<>();
        
        java.util.function.Function<String, String> devowel = (word) -> {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toLowerCase().toCharArray()) {
                if ("aeiou".indexOf(c) >= 0) {
                    sb.append('*');
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        };
        
        for (String word : wordlist) {
            exactWords.add(word);
            String lower = word.toLowerCase();
            caseInsensitive.putIfAbsent(lower, word);
            String dev = devowel.apply(word);
            vowelMap.putIfAbsent(dev, word);
        }
        
        String[] result = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            if (exactWords.contains(q)) {
                result[i] = q;
            } else {
                String lower = q.toLowerCase();
                String dev = devowel.apply(q);
                if (caseInsensitive.containsKey(lower)) {
                    result[i] = caseInsensitive.get(lower);
                } else if (vowelMap.containsKey(dev)) {
                    result[i] = vowelMap.get(dev);
                } else {
                    result[i] = "";
                }
            }
        }
        return result;
    }
}
