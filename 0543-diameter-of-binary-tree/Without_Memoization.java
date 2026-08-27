class Solution {
    static int maxDia;
   public int level(TreeNode root){
        if(root==null) return 0;
        int leftLevels = level(root.left);
        int rightLevels = level(root.right);
        int myDia =  leftLevels + rightLevels ;//extra
        maxDia = Math.max(myDia,maxDia);  //extra
        return 1 + Math.max(leftLevels,rightLevels);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxDia =0;
        level(root);
        return maxDia;
        
    }
}
