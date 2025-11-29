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
        int n=s.length();
        int m=p.length();
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++)Arrays.fill(dp[i],-1);
        return match(m-1,n-1,p,s,dp);
    }
}