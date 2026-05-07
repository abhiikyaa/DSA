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
    public int goodNodes(TreeNode root) 
    {
        int max = root.val;
        int count = 0;
        int ans = helper(root, max,count);
        return ans;
    }
    public int helper(TreeNode root, int max, int c)
    {
        c = 0;
        if(root == null) return 0;
        if(root.val >= max)
        {
            max = root.val;
            c =1;
        }

        int leftside = helper(root.left,max,c);
        int rightside = helper(root.right, max , c);

        return c + leftside + rightside;
        
    }

}