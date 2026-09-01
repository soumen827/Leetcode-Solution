class Solution {
    // public int level(TreeNode root, Map<TreeNode,Integer> dp){
    //     if(root==null) return 0;
    //     if(dp.containsKey(root)) return dp.get(root); // like dp[i][j] != -1 return dp[i][j];
    //     int leftLevels = level(root.left,dp);
    //     int rightLevels = level(root.right,dp);
    //     dp.put(root,1+Math.max(leftLevels,rightLevels));// like dp[i][j]me save karte the return karne se pehele,isame map me put kar raha hay
    //     return dp.get(root);
    // }
    // public int diameter(TreeNode root, Map<TreeNode,Integer> dp) {
    //     if(root==null) return 0;
    //     int myDia = (level(root.left,dp) + level(root.right,dp)+1)-1;
    //     int leftDia = diameter(root.left,dp);
    //     int rightDia = diameter(root.right,dp);
    //     return Math.max(Math.max(myDia,leftDia),rightDia);
        
    // }
    //  public int diameterOfBinaryTree(TreeNode root) {
    //    Map<TreeNode,Integer> dp = new HashMap<>();
    //     return diameter(root,dp);
        
    // }



    static Map<TreeNode,Integer> dp;
    public int level(TreeNode root){
        if(root==null) return 0;
        if(dp.containsKey(root)) return dp.get(root); // like dp[i][j] != -1 return dp[i][j];
        int leftLevels = level(root.left);
        int rightLevels = level(root.right);
        dp.put(root,1+Math.max(leftLevels,rightLevels));// like dp[i][j]me save karte the return karne se pehele,isame map me put kar raha hay
        return dp.get(root);
    }
    public int diameter(TreeNode root) {
        if(root==null) return 0;
        int myDia = (level(root.left) + level(root.right)+1)-1;
        int leftDia = diameter(root.left);
        int rightDia = diameter(root.right);
        return Math.max(Math.max(myDia,leftDia),rightDia);
        
    }
     public int diameterOfBinaryTree(TreeNode root) {
        dp = new HashMap<>();
        return diameter(root);
        
    }
}