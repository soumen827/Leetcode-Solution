class Solution {
    static int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE; // for negative value
        lineSum(root);
        return maxSum;

    }
    public int lineSum(TreeNode root) {
        if(root==null) return 0;
        //if(root==1) return root.val;
        int leftLineSum = lineSum(root.left);
        int rightLineSum = lineSum(root.right);
        int pathSum = root.val ;
        if(leftLineSum>0) pathSum += leftLineSum; // '-' value hua to ignore
        if(rightLineSum>0) pathSum += rightLineSum; // '-' hua to ignore
        maxSum = Math.max(pathSum,maxSum);
        return root.val + Math.max(0,Math.max(leftLineSum,rightLineSum)); // 0 lena hoga if max hi nehative ho to
    }
}