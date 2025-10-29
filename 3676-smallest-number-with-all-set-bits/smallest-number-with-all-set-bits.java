class Solution {
    public int smallestNumber(int n) {
        if(n==0 || n==1)return n;
        int prev=2;
        int power=4;
        while(true){
            if(n>=prev && n<power){
                return power-1;
            }
            prev=power;
            power*=2;

        }
    }
}