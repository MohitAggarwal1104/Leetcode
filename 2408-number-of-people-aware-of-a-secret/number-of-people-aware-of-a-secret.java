class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        long[] prefix = new long[n + 2];
        prefix[1 + delay] = (prefix[1 + delay] + 1) % mod;
        prefix[1 + forget] = (prefix[1 + forget] - 1 + mod) % mod;

        long share = 0;
        for (int i = 2; i <= n; i++) {
            share = (share + prefix[i]) % mod;
            dp[i] = share;
            if (i + delay <= n) prefix[i + delay] = (prefix[i + delay] + dp[i]) % mod;
            if (i + forget <= n) prefix[i + forget] = (prefix[i + forget] - dp[i] + mod) % mod;
        }

        long ans = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            if (i >= 1) ans = (ans + dp[i]) % mod;
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