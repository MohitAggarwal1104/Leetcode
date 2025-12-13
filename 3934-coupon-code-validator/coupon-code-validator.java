import java.util.*;

class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        // Fixed business line order
        Map<String, Integer> order = new HashMap<>();
        order.put("electronics", 0);
        order.put("grocery", 1);
        order.put("pharmacy", 2);
        order.put("restaurant", 3);

        // List to store valid coupons as (order, code)
        List<Pair> validCoupons = new ArrayList<>();

        for (int i = 0; i < code.length; i++) {
            if (!isActive[i]) continue;

            String c = code[i];
            String b = businessLine[i];

            // Validate business line
            if (!order.containsKey(b)) continue;

            // Validate code: non-empty & only alphanumeric + underscore
            if (c == null || c.isEmpty()) continue;
            if (!c.matches("[A-Za-z0-9_]+")) continue;

            validCoupons.add(new Pair(order.get(b), c));
        }

        // Sort by business line order, then by code lexicographically
        Collections.sort(validCoupons, (a, b) -> {
            if (a.lineOrder != b.lineOrder) {
                return a.lineOrder - b.lineOrder;
            }
            return a.code.compareTo(b.code);
        });

        // Extract result
        List<String> result = new ArrayList<>();
        for (Pair p : validCoupons) {
            result.add(p.code);
        }

        return result;
    }

    // Helper class
    static class Pair {
        int lineOrder;
        String code;

        Pair(int lineOrder, String code) {
            this.lineOrder = lineOrder;
            this.code = code;
        }
    }
}
