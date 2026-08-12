class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        return way(0,arr,target);
    }
    public int way(int i, int[] arr, int target) {
        if(i==arr.length){
            if(target==0) return 1; // 1valid way
            else return 0;
        }
        int add = way(i+1,arr,target-arr[i]); // same as take skip
        int sub = way(i+1,arr,target+arr[i]);
        return add+sub;
    }
}
