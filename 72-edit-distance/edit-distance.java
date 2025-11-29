class Solution {
    public int count(int i,int j,String word1, String word2,int dp[][]){
        if(i<0)return j+1;
        if(j<0)return i+1;
        if(dp[i][j]!=-1)return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)){
            return dp[i][j]= count(i-1,j-1,word1,word2,dp);
        }
        else{
            int insert=1+count(i,j-1,word1,word2,dp);
            int remove=1+count(i-1,j,word1,word2,dp);
            int replace=1+count(i-1,j-1,word1,word2,dp);
            return dp[i][j]= Math.min(insert,Math.min(remove,replace));
        }
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++)Arrays.fill(dp[i],-1);

        return count(n-1,m-1,word1,word2,dp);
    }
}