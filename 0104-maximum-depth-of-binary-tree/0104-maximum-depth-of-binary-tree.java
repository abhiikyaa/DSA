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
    public int maxDepth(TreeNode root) {
        int max = findMax(root);
        return max;
    }
    public int findMax(TreeNode root){
        if(root == null){
            return 0;
        }
        int maxdepth = 1 + Math.max(findMax(root.left) , findMax(root.right));
        return maxdepth;
    }
}