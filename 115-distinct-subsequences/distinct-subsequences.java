class Solution {
    public int count(int i,int j,String s, String t,int dp[][]){
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(dp[i][j]!=-1)return dp[i][j];
        if(s.charAt(i)==t.charAt(j)){
            return dp[i][j]=count(i-1,j-1,s,t,dp)+count(i-1,j,s,t,dp);
        }
        else return dp[i][j]=count(i-1,j,s,t,dp);
    }
    public int numDistinct(String s, String t) {
        int dp[][]=new int[s.length()][t.length()];
        for(int i=0;i<s.length();i++)Arrays.fill(dp[i],-1);
        return count(s.length()-1,t.length()-1,s,t,dp);
    }
}