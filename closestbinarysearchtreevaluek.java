/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> pre = new Stack<>();
        Stack<Integer> suc = new Stack<>();
        inorder(root,target,false,pre);
        inorder(root,target,true,suc);
        while (k>0){
            if (pre.isEmpty()) res.add(suc.pop());
            else if (suc.isEmpty()) res.add(pre.pop());
            else{
               if  (Math.abs(pre.peek()-target)<Math.abs(suc.peek()-target)) res.add(pre.pop());
               else res.add(suc.pop());
                
            } 
            k--;
        }
        return res;
    }
    
    public void inorder(TreeNode root, double target, boolean reverse, Stack<Integer> stack){
        if (root==null) return;
        inorder(reverse?root.right:root.left,target,reverse,stack);
        if ((reverse && root.val<=target)||(!reverse && root.val>target)) return;
        stack.push(root.val);
        inorder(reverse?root.left:root.right,target,reverse,stack);
    }
}