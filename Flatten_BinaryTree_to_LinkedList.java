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
    public void flatten(TreeNode root) {
        if (root==null) return;
        if (root.left==null && root.right == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode cur = root.left;
        if (cur != null){    //这步是很容易遗忘的，一定要牢记
            while (cur.right != null) cur = cur.right;
            cur.right = root.right;
            root.right = root.left;
            root.left = null;
        }
    }
}