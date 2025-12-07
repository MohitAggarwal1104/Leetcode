class Solution {
    boolean isPalindrome(String s ,int i ,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
    public int f(int i,int n,String s,int dp[]){
        if(i==n)return 0;
        if(dp[i]!=-1)return dp[i];

        int minCost=(int)1e9;
        for(int j=i;j<n;j++){
            if(isPalindrome(s,i,j)){
                int cost=1+f(j+1,n,s,dp);
                minCost=Math.min(minCost,cost);
            }
        }
        return dp[i]=minCost;
    }
    public int minCut(String s) {
        int n=s.length();
        int dp[]=new int[n];
        Arrays.fill(dp,-1);
        return f(0,n,s,dp)-1;
    }
}