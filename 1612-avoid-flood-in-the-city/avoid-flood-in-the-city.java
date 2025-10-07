// import java.util.*;

// class Solution {
//     public int[] avoidFlood(int[] rains) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int[] arr = new int[rains.length];
//         ArrayList<Integer> list = new ArrayList<>();

//         for (int i = 0; i < rains.length; i++) {
//             int lake = rains[i];

//             if (lake == 0) {
//                 list.add(i);
//                 arr[i] = 1;
//                 continue;
//             }

//             arr[i] = -1;

//             if (map.containsKey(lake)) {
//                 int lastRainDay = map.get(lake);
//                 int dryDayIndex = -1;

//                 for (int j : list) {
//                     if (j > lastRainDay) {
//                         dryDayIndex = j;
//                         break;
//                     }
//                 }

//                 if (dryDayIndex == -1) {
//                     return new int[0];
//                 }

//                 arr[dryDayIndex] = lake;
//                 list.remove(Integer.valueOf(dryDayIndex));
//                 map.remove(lake);
//             }

//             map.put(lake, i);
//         }

//         return arr;
//     }
// }
import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        int[] arr = new int[rains.length];

        for (int i = 0; i < rains.length; i++) {
            int lake = rains[i];

            if (lake == 0) {
                dryDays.add(i);
                arr[i] = 1;
                continue;
            }

            arr[i] = -1;

            if (map.containsKey(lake)) {
                int lastRainDay = map.get(lake);
                Integer dryDayIndex = dryDays.higher(lastRainDay);

                if (dryDayIndex == null) {
                    return new int[0];
                }

                arr[dryDayIndex] = lake;
                dryDays.remove(dryDayIndex);
            }

            map.put(lake, i);
        }

        return arr;
    }
}
