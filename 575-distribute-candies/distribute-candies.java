class Solution {
    public int distributeCandies(int[] candyType) {
        LinkedHashSet<Integer> st=new LinkedHashSet<>();
        for(int i: candyType)st.add(i);
        int n=candyType.length/2;
        if(n<st.size())return n;
        else{
            return st.size();
        }
    }
}