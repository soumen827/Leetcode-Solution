class Solution {
    public class Envelop implements Comparable<Envelop>{
        int w;
        int h;
        Envelop(int w, int h){
            this.w = w;
            this.h = h;
        }
        public int compareTo(Envelop e){
            if(this.w==e.w) return e.h - this.h; // width same hua to hight dehko jiska bara hay (ulta)
            return this.w - e.w;
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Envelop[] arr = new Envelop[n];
        for(int i=0;i<n;i++){
            int w = envelopes[i][0];
            int h = envelopes[i][1];
            arr[i] = new Envelop(w,h);
        }
        Arrays.sort(arr);


        int max =0;
        int [] dp = new int[n];
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(arr[j].h<arr[i].h) dp[i] = Math.max(dp[i],dp[j]);
            }
            dp[i] += 1; // for idx i 
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
// this is Dp approch TLE problem
