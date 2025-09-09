import java.util.*;

class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        dp[1] = 1;

        long sum = 0;
        for (int day = 2; day <= n; day++) {
            if (day - delay >= 1) {
                sum = (sum + dp[day - delay]) % MOD;
            }
            if (day - forget >= 1) {
                sum = (sum - dp[day - forget] + MOD) % MOD;
            }
            dp[day] = (int) sum;
        }

        long ans = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            if (i >= 1) ans = (ans + dp[i]) % MOD;
        }

        return (int) ans;
    }
}

// class tuple{
//     char personName;
//     int delay;
//     int forget;
//     tuple(char personName,int delay,int forget){
//         this.personName=personName;
//         this.delay=delay;
//         this.forget=forget;
//     }
// }
// class Solution {
//     public int peopleAwareOfSecret(int n, int delay, int forget) {
//         ArrayList<tuple> list=new ArrayList<>();
//          char currentName = 'A';
//         int countperson=0;
//         for(int i=1;i<=n;i++){
//             if(i==1){
//                 list.add(new tuple('A',delay-1,forget-1));
//                 countperson++;
//             }
//             else{
//                 ArrayList<tuple>helper=new ArrayList<>();
//                 Iterator<tuple> it = list.iterator();
//                 while (it.hasNext()) {
//                     tuple t = it.next();

//                     t.delay--;
//                     t.forget--;

//                     if (t.forget < 0) {
//                         it.remove();
//                         countperson--;
//                         continue;
//                     }

//                     if (t.delay < 0 && t.forget >= 0) {
//                         currentName++;
//                         helper.add(new tuple(currentName, delay - 1, forget - 1));
//                     }
//                 }

//                 if (!helper.isEmpty()) {
//                     list.addAll(helper);
//                     countperson += helper.size();
//                 }
//             }
//         }
//         return countperson;
//     }
// }