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
    public List<Integer> postorderTraversal(TreeNode root) {
     List<Integer> answer = new ArrayList<>();
     btp(root, answer);
     return answer;

    }
    public void btp (TreeNode root, List<Integer> answer){
        if(root == null){
            return;
        }
        btp(root.left, answer);
        btp(root.right, answer);
        answer.add(root.val);


    }
}