class Solution {
    // public int level(TreeNode root){
    //     if(root==null) return 0;
    //     return 1 + Math.max(level(root.left),level(root.right));
    // }
    // public int diameterOfBinaryTree(TreeNode root) {
    //     if(root==null) return 0;
    //     int myDia = (level(root.left) + level(root.right)+1)-1;
    //     int leftDia = diameterOfBinaryTree(root.left);
    //     int rightDia = diameterOfBinaryTree(root.right);
    //     return Math.max(Math.max(myDia,leftDia),rightDia);
        
    // }
    static int maxDia;
    public int levels(TreeNode root){
        if(root==null) return 0;
        int leftLevels = levels(root.left);
        int rightLevels = levels(root.right);
        int dia =  leftLevels + rightLevels;
        maxDia = Math.max(dia,maxDia);

        return 1 +Math.max(leftLevels,rightLevels);
        
    }
    public int diameterOfBinaryTree(TreeNode root){
        maxDia = 0;
        levels(root);
        return maxDia;

    }
}