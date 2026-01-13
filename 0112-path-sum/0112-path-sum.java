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
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root ==null) return false ;
        return inOrder(root  , 0 , targetSum);
    }

    public boolean inOrder(TreeNode root , int sum , int targetSum){

        if(root==null){
            return false ;
        }

        if(root.left==null && root.right==null){
            if((sum+root.val)==targetSum) return true;
        }
        if(inOrder(root.left , sum+root.val , targetSum)==true) return true ;

        if(inOrder(root.right , sum+root.val , targetSum)==true) return true ;

        return false ;

    }
}