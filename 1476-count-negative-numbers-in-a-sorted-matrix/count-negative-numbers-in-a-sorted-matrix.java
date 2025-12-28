class Solution {
    public int countNegatives(int[][] grid) {
        int total=0;
        for(int i[] : grid){
            for(int p : i){
                if(p<0)total++;
            }
        }
        return total;
    }
}