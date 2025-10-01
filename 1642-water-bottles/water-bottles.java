class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result=numBottles;
        while(numBottles>1 && numBottles>=numExchange){
            result+=numBottles/numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }
        return result;
    }
}