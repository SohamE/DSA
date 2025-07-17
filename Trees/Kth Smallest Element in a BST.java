class Solution {
    int count = 0;
    int temp;
    boolean found = false;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);   
        return temp;
    }

    public void inOrder(TreeNode root,int k){
        if(root==null || found) return;

        inOrder(root.left,k);

        count++;
        if(count==k) {
            temp=root.val;
            found = true;
            return;
        }
        inOrder(root.right,k);
        return;
    }
}
