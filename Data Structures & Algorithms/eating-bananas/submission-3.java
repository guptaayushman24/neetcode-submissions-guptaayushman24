class Solution {
    public boolean isPossible (int mid,int h,int [] piles){
        for (int i=0;i<piles.length;i++){
            if (piles[i]<=mid){
                h = h-1;
            }
            else {
                h = h-(piles[i]+(mid-1))/mid;
            }
        }

        if (h>=0){
            return true;
        }

        return false;
    }
    public static int max (int [] piles){
        int maxi = Integer.MIN_VALUE;
        for (int i=0;i<piles.length;i++){
            maxi = Math.max(maxi,piles[i]);
        }

        return maxi;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = max(piles);;
        int ans = Integer.MAX_VALUE;
        while (low<=high){
            int mid = (low+high)/2;
            if (isPossible (mid,h,piles)){
                ans = Math.min(ans,mid);
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        if (ans==Integer.MAX_VALUE){
            return high;
        }
        return ans;
    }
}
