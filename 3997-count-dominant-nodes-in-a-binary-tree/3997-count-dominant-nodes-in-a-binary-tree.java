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
    int c = 0;

    public void Solve(TreeNode root) 
    {
        if (root != null) 
        {
            Solve(root.left);
            Solve(root.right);
            if (root.left == null && root.right == null) 
            {
                c++;
            } 
            else if (root.left != null && root.right != null && root.left.val <= root.val&& root.right.val <= root.val) 
            {
                c++;
            } 
            else if (root.left == null)
             {
                if (root.right.val > root.val) 
                {
                    root.val = root.right.val;
                } 
                else 
                {
                    c++;
                }
            } 
            else if (root.right == null) 
            {
                if (root.left.val > root.val) 
                {
                    root.val = root.left.val;
                } 
                else 
                {
                    c++;
                }
            } 
            else 
            {
                int max = Math.max(root.left.val, root.right.val);
                root.val = max;
            }
        }
    }

    public int countDominantNodes(TreeNode root) 
    {
        Solve(root);
        return c;
    }
}