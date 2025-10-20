class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x=0;
        for(String i : operations){
            if(i.equals("++X"))x++;
            if(i.equals("X++"))++x;
            if(i.equals("--X"))--x;
            if(i.equals("X--"))x--;
        }
        return x;
    }
}