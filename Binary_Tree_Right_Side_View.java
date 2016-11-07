/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/** 
 * BFS的思路就是有一个list用来储存各个level的元素，选取最右的；DFS的思路就是建立一个hashmap，然后储存每行的所有元素，
 * 最后选择每行的list的最后一位。
 * **/

/** BFS **/

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        List<TreeNode> haha = new ArrayList<>();
        haha.add(root);
        while (haha.size() != 0){
            List<TreeNode> copy = new ArrayList<>();
            for (TreeNode node : haha) {
                if (node.left != null) copy.add(node.left);
                if (node.right != null) copy.add(node.right);
            }
            res.add(haha.get(haha.size()-1).val);
            haha = new ArrayList<>(copy);
        }
        return res;
    }
}


/** DFS **/

public class Solution {
    Map<Integer,List<Integer>> depthmap = new HashMap<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null) return new ArrayList<>();
        List<Integer> sb = new ArrayList<>();
        sb.add(root.val);
        depthmap.put(0,sb);
        helper(root,0);
        
        int i=0;
        List<Integer> res = new ArrayList<>();
        while (depthmap.containsKey(i)){
            List<Integer> level = depthmap.get(i);
            int size = level.size();
            res.add(level.get(size-1));
            i++;
        }
        return res;
    }
    
    public void helper(TreeNode root, int depth){
        if (root==null) return;
        if (root.left != null){
            if (depthmap.containsKey(depth+1)) depthmap.get(depth+1).add(root.left.val);
            else{
                List<Integer> hei = new ArrayList<>();
                hei.add(root.left.val);
                depthmap.put(depth+1,hei);
            }
            helper(root.left,depth+1);
        }
        if (root.right != null){
            if (depthmap.containsKey(depth+1)) depthmap.get(depth+1).add(root.right.val);
            else{
                List<Integer> hei = new ArrayList<>();
                hei.add(root.right.val);
                depthmap.put(depth+1,hei);
            }
            helper(root.right,depth+1);
        }
    }
}


/** ELEGANT SOLUTION **/

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
}
