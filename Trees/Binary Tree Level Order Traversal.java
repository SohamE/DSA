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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> bfs = new ArrayDeque<>();
        if (root == null) return result;
        bfs.add(root);

        while (!bfs.isEmpty()){
            int size = bfs.size();
            List<Integer> store = new ArrayList<>();
            while (size > 0) {
                TreeNode pick = bfs.poll();
                store.add(pick.val);
                if (pick.left != null)
                    bfs.add(pick.left);
                if (pick.right != null)
                    bfs.add(pick.right);
                size--;
            }
            result.add(store);
        }
        return result;
    }
}
