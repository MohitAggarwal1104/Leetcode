class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        generateCombinations(n,k,1,new ArrayList<>(),result);
        return result;
    }
    public void generateCombinations(int n,int k,int start,List<Integer> current, List<List<Integer>> result){
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try all numbers starting from 'start' to 'n'
        for (int i = start; i <= n; i++) {
            current.add(i); // choose
            generateCombinations(n, k, i + 1, current, result); // explore
            current.remove(current.size() - 1); // un-choose (backtrack)
        }
    }
}