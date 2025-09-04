class Solution {
    public int findClosest(int x, int y, int z) {
        int person1= Math.abs(x - z);
        int person2= Math.abs(y - z);
        if(person1>person2)return 2;
        else if(person1<person2)return 1;
        else return 0;
    }
}