class Solution {
    public boolean match(int i,int j, String s, String p,int dp[][]){
        if(i<0 && j<0)return true;
        if(i<0 && j>=0)return false;
        if(j<0 && i>=0){
            for(int pp=0;pp<=i;pp++){
                if(s.charAt(pp)!='*')return false;
            }
            return true;
        }
        if(dp[i][j]!=-1)return dp[i][j]==1;
        if(s.charAt(i)==p.charAt(j) || s.charAt(i)=='?'){
            dp[i][j]=match(i-1,j-1,s,p,dp)?1:0;
            return dp[i][j]==1;
        }
        else if(s.charAt(i)=='*'){
            dp[i][j]=(match(i-1,j,s,p,dp)||match(i,j-1,s,p,dp))?1:0;
            return dp[i][j]==1;
        }
        return false;
    }
    public boolean isMatch(String s, String p) {
        // int n=s.length();
        // int m=p.length();
        // int dp[][]=new int[m][n];
        // for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        // return match(m-1,n-1,p,s,dp);
        // int n = s.length();
        // int m = p.length();

        // boolean dp[][] = new boolean[m+1][n+1];
        // dp[0][0] = true;
        // for(int i = 1; i <= m; i++){
        //     if(p.charAt(i-1) == '*')
        //         dp[i][0] = dp[i-1][0];
        // }
        // for(int i = 1; i <= m; i++){
        //     for(int j = 1; j <= n; j++){

        //         if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?'){
        //             dp[i][j] = dp[i-1][j-1];
        //         }
        //         else if(p.charAt(i-1) == '*'){
        //             dp[i][j] = dp[i-1][j]     // * matches empty
        //                      || dp[i][j-1]; // * matches 1 or more
        //         }
        //         else{
        //             dp[i][j] = false;
        //         }
        //     }
        // }

        // return dp[m][n];

        int n = s.length();
        int m = p.length();

        boolean dp[] = new boolean[n + 1];
        boolean prev[] = new boolean[n + 1];

        prev[0] = true;

        for (int i = 1; i <= m; i++) {

            dp[0] = (p.charAt(i - 1) == '*' ? prev[0] : false);

            for (int j = 1; j <= n; j++) {

                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                    dp[j] = prev[j - 1];
                }
                else if (p.charAt(i - 1) == '*') {
                    dp[j] = dp[j - 1] || prev[j];
                }
                else {
                    dp[j] = false;
                }
            }

            prev = dp.clone();
        }

        return prev[n];
    }
}