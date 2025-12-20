class Solution {
    public int minDeletionSize(String[] strs) {
        int count=0;

        for(int i=0;i<strs[0].length();i++){
            int position=0;
            for(int j=0;j<strs.length;j++){
                if(j!=0 && position>(strs[j].charAt(i)-'0')){
                    count++;
                    break;
                }
                else{
                    position=strs[j].charAt(i)-'0';
                }
            }
        }
        return count;
    }
}