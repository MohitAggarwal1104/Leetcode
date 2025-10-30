class Solution {
    public int maxDepth(String s) {
        int count=0;
        int max=0;
        for(char i : s.toCharArray()){
            if(i=='('){
                count++;
                if(count>max)max=count;
            }
            else if(i==')'){
                count--;
            }
        }
        return max;
    }
}