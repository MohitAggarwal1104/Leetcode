class Solution {
    public int maxFreqSum(String s) {
        // HashMap<Character>vowels=new HashMap<>();
        // HashMap<Character>consonants=new HashMap<>();
        int vowels[]=new int[5]; // a e i o u
        int consonants[]=new int[26];
        String v="aeiou";
        for(char i : s.toCharArray()){
            if(v.indexOf(i)!=-1){
                vowels[v.indexOf(i)]+=1;
            }
            else{
                consonants[(int)i-'a']+=1;
            }
        }
        int result=0;
        int max=0;
        for(int i : consonants){
            if(i>max)max=i;
        }
        result+=max;
        max=0;
        for(int i : vowels){
            if(i>max)max=i;
        }
        result+=max;
        return result;
    }
}