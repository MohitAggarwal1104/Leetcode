class Solution {
    public int count(String s1,String s2,int i , int j,int dp[][]){
        if(i<0 || j<0)return 0;
        if(dp[i][j]!=-1)return dp[i][j];
        if(s1.charAt(i)==(s2.charAt(j)))return dp[i][j]= 1+count(s1,s2,i-1,j-1,dp);
        else return dp[i][j]=Math.max(count(s1,s2,i-1,j,dp),count(s1,s2,i,j-1,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        // int dp[][]=new int[text1.length()][text2.length()];
        // for(int i=0;i<text1.length();i++)Arrays.fill(dp[i],-1);
        // return count(text1,text2,text1.length()-1,text2.length()-1,dp);

        // int dp[][]=new int[text1.length()+1][text2.length()+1];
        // for(int i=0;i<=text1.length();i++)Arrays.fill(dp[i],-1);
        // for(int i=0;i<=text1.length();i++){
        //     dp[i][0]=0;
        // }
        // for(int i=0;i<=text2.length();i++){
        //     dp[0][i]=0;
        // }

        // for(int i=1;i<=text1.length();i++){
        //     for(int j=1;j<=text2.length();j++){
        //         if(text1.charAt(i-1)==(text2.charAt(j-1)))dp[i][j]= 1+dp[i-1][j-1];
        //         else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        //     }
        // }
        // return dp[text1.length()][text2.length()];
        
        int dp[]=new int[text2.length()+1];
        Arrays.fill(dp,-1);
        for(int i=0;i<=text2.length();i++){
            dp[i]=0;
        }

        for(int i=1;i<=text1.length();i++){
            int prev = 0; 
            for(int j=1;j<=text2.length();j++){
                 int temp = dp[j];
                if(text1.charAt(i-1)==(text2.charAt(j-1))) dp[j] = 1 + prev;
                else dp[j]=Math.max(dp[j],dp[j-1]);
                prev = temp;
            }
        }
        return dp[text2.length()];
    }
}