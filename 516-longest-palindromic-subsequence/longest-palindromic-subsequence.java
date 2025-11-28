class Solution {
    public int LCA(int i,int j,String s1,String s2 ,int dp[][]){
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))return dp[i][j]= 1+LCA(i-1,j-1,s1,s2,dp);
        else return dp[i][j]=Math.max(LCA(i-1,j,s1,s2,dp),LCA(i,j-1,s1,s2,dp));
    }
    public int longestPalindromeSubseq(String s) {
        int dp[][]=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++)Arrays.fill(dp[i],-1);
        String reversed = new StringBuilder(s).reverse().toString();
        return LCA(s.length()-1,s.length()-1,s,reversed.toString(),dp);
        
    }
}