class Solution {
    public boolean backspaceCompare(String s, String t) {
        ArrayList<Character>list1=new ArrayList<>();
        ArrayList<Character>list2=new ArrayList<>();
        for(char i : s.toCharArray()){
            if(i=='#'){
                if(!list1.isEmpty())
                list1.remove(list1.size()-1);
            }
            else list1.add(i);
        }

         for(char i : t.toCharArray()){
            if(i=='#'){
                if(!list2.isEmpty())list2.remove(list2.size()-1);
            }
            else list2.add(i);
        }
        if(list1.size()!=list2.size())return false;
        for(int i=0;i<list1.size();i++){
            if(list1.get(i)!=list2.get(i))return false;
        }
        return true;

    }
}