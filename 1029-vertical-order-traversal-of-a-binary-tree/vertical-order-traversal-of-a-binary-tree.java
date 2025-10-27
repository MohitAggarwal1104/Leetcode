/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Tuple{
    TreeNode node;
    int i;
    int j;
    Tuple(TreeNode t,int i,int j){
        node=t;
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer,Map<Integer,PriorityQueue<Integer>>> nodes=new TreeMap<>();
        Queue<Tuple> todo=new LinkedList<>();
        todo.add(new Tuple(root,0,0));
        while(!todo.isEmpty()){
            Tuple t=todo.poll();
            TreeNode node=t.node;
            int x=t.i;
            int y=t.j;

            if(!nodes.containsKey(x)){
                nodes.put(x,new TreeMap<Integer,PriorityQueue<Integer>>());
            }
            if(!nodes.get(x).containsKey(y)){
                nodes.get(x).put(y,new PriorityQueue<Integer>());
            }

            nodes.get(x).get(y).add(node.val);
            if (node.left != null) todo.add(new Tuple(node.left, x - 1, y + 1));
            if (node.right != null) todo.add(new Tuple(node.right, x + 1, y + 1));

        }
        List<List<Integer>>result=new ArrayList<>();
        for(Map<Integer,PriorityQueue<Integer>> i : nodes.values()){
            List<Integer> l=new ArrayList<>();
            for(PriorityQueue<Integer> j : i.values() ){
                while(!j.isEmpty()){
                    l.add(j.poll());
                }
            }
            result.add(l);
        }
        return result;
    }
}