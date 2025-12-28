class Solution {
    public int countNegatives(int[][] grid) {
        int total=0;
        for(int i[] : grid){
            for(int p=i.length-1;p>=0;p--){
                if(i[p]<0)total++;
                else break;
            }
        }
        return total;
    }
}