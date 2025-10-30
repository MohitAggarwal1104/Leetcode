class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        int count=0;
        int n=0;
        for(char j : s.toCharArray()){
            if(j=='(')n++;
            else {
                if(n==0){
                    count++;
                }
                else{
                    n--;
                }
            }
        }
        return count+n;
    }
}