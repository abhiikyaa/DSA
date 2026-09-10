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
    public int averageOfSubtree(TreeNode root) 
    {
        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<TreeNode> list = new ArrayList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            list.add(curr);

            if(curr.left != null)
            {
                q.add(curr.left);
            }    
            if(curr.right != null)
            {
                q.add(curr.right);
            }    
        }

        int ans = 0;
        HashMap<TreeNode, Integer> sum = new HashMap<>();
        HashMap<TreeNode, Integer> cnt = new HashMap<>();
        for(int i = list.size() - 1; i >= 0; i--)
        {
            TreeNode curr = list.get(i);

            int s = curr.val;
            int c = 1;

            if(curr.left != null)
            {
                s += sum.get(curr.left);
                c += cnt.get(curr.left);
            }

            if(curr.right != null)
            {
                s += sum.get(curr.right);
                c += cnt.get(curr.right);
            }

            sum.put(curr, s);
            cnt.put(curr, c);

            if(s / c == curr.val) ans++;
        }
        return ans;
    }
}