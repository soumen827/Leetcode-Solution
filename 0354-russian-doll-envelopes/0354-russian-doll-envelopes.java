class Solution {
    public class Envelop implements Comparable<Envelop> {
        int w;
        int h;
        Envelop(int w, int h) {
            this.w = w;
            this.h = h;
        }
        public int compareTo(Envelop e) {
            if (this.w == e.w)
                return e.h - this.h;

            return this.w - e.w;
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Envelop[] arr = new Envelop[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Envelop(
                envelopes[i][0],
                envelopes[i][1]
            );
        }
        Arrays.sort(arr);

        // LIS on height
        int[] lis = new int[n];
        int size = 0;
        for (int i = 0; i < n; i++) {

            int h = arr[i].h;
            // Binary Search 
            int lo = 0;
            int hi = size;

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;

                if (lis[mid] < h)
                    lo = mid + 1;
                else
                    hi = mid;
            }

            lis[lo] = h;

            if (lo == size)
                size++;
        }

        return size;
    }
}