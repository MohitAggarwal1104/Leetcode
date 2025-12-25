class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> st=new HashSet<>();
        Set<Integer> st2=new HashSet<>();
        for(int i : nums1)st.add(i);
        for(int i : nums2)st2.add(i);
        ArrayList<Integer> list=new ArrayList<>();
       for (Integer i : st) {
            if (st2.contains(i)) {
                list.add(i);
            }
        }

        int arr[]=new int[list.size()];
        for(int i=0;i<list.size();i++)arr[i]=list.get(i);
        return arr;
    }
}