// class Solution {
//     boolean isPalindrome(String s ,int i ,int j){
//         while(i<j){
//             if(s.charAt(i)!=s.charAt(j))return false;
//             i++;
//             j--;
//         }
//         return true;
//     }
//     public int f(int i,int n,String s,int dp[]){
//         if(i==n)return 0;
//         if(dp[i]!=-1)return dp[i];

//         int minCost=(int)1e9;
//         for(int j=i;j<n;j++){
//             if(isPalindrome(s,i,j)){
//                 int cost=1+f(j+1,n,s,dp);
//                 minCost=Math.min(minCost,cost);
//             }
//         }
//         return dp[i]=minCost;
//     }
//     public int minCut(String s) {
//         // int n=s.length();
//         // int dp[]=new int[n];
//         // Arrays.fill(dp,-1);
//         // return f(0,n,s,dp)-1;

//         int n=s.length();
//         int dp[]=new int[n+1];
//         dp[n]=0;

//         for(int i=n-1;i>=0;i--){
//             int minCost=(int)1e9;
//             for(int j=i;j<n;j++){
//                 if(isPalindrome(s,i,j)){
//                     int cost=1+dp[j+1];
//                     minCost=Math.min(minCost,cost);
//                 }
//             }
//             dp[i]=minCost;
//         }
//         return dp[0]-1;
//     }
// }
class Solution {

    public int minCut(String s) {
        int n = s.length();
        
        boolean pal[][] = new boolean[n][n];

        // Precompute palindromes
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || pal[i+1][j-1])) {
                    pal[i][j] = true;
                }
            }
        }

        int dp[] = new int[n + 1];
        dp[n] = 0;

        // Bottom-up DP
        for (int i = n - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (pal[i][j]) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }

        return dp[0] - 1; // cuts = partitions - 1
    }
}
