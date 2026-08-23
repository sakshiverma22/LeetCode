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
class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> freq=new HashMap<>();
        inorder(root,freq);
        int maxCount=0;
        for(int c:freq.values()) maxCount=Math.max(maxCount,c);
        List<Integer>modes=new ArrayList<>();
        for(Map.Entry<Integer, Integer> e:freq.entrySet()){
            if(e.getValue()==maxCount) modes.add(e.getKey());
        }
        int[] result=new int[modes.size()];
        for(int i=0;i<modes.size();i++) result[i]=modes.get(i);
        return result;
    }
    private void inorder(TreeNode node, Map<Integer, Integer> freq){
        if(node==null) return;
        inorder(node.left, freq);
        freq.put(node.val, freq.getOrDefault(node.val,0)+1);
        inorder(node.right,freq);
    }
}