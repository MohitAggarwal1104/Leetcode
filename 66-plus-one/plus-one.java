class Solution {
    public int[] plusOne(int[] digits) {
        int carry=1;
        for(int i=digits.length-1;i>=0;i--){
            int n=digits[i]+carry;
            if(n>9){
                digits[i]=n%10;
                carry=n/10;
            }
            else{
                digits[i]=n;
                carry=0;
            }
        }
        if(carry==1){
            int [] arr=new int[digits.length+1];
            arr[0]=1;
            for(int i=0;i<digits.length;i++)arr[i+1]=digits[i];
            return arr;
        }
        return digits;
    }
}