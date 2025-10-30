class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
        int count=0;
        for(char j : s.toCharArray()){
            if(j=='(')st.push('(');
            else {
                if(st.isEmpty()){
                    count++;
                }
                else{
                    st.pop();
                }
            }
        }
        return count+st.size();
    }
}