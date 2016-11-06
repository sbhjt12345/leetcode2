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
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        if (root.left==null && root.right==null) return true;
        return helper(root.left,root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right){
        if (left==null && right == null) return true;
        if ((left==null && right != null) ||(left!=null && right==null) || (left.val != right.val)) return false;
        return helper(left.right,right.left) && helper(left.left,right.right);
    }
}