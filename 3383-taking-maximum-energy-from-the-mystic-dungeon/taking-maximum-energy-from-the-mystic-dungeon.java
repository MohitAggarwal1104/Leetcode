// class Solution {
//     public int maximumEnergy(int[] energy, int k) {
//         int max=Integer.MIN_VALUE;
//         for(int i=0;i<energy.length;i++){
//             int sum=0;
//             for(int j=i;j<energy.length;j+=k){
//                 sum+=energy[j];
//             }
//             if(sum>max)max=sum;
//         }
//         return max;
//     }
// }
class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int[] dp = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = energy[i] + (i + k < n ? dp[i + k] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}
