class Solution {
    public static int maxOfPiles (int [] piles){
        int maxi = Integer.MIN_VALUE;
        for (int i=0;i<piles.length;i++){
            maxi = Math.max(maxi,piles[i]);
        }

        return maxi;
    }

    public static boolean isPossible (int [] piles,int h,int totalHour,int k){
        for (int i=0;i<piles.length;i++){
          if (k>=piles[i]){
            totalHour = totalHour+1;
          }
          else{
            totalHour = totalHour + (piles[i] + k - 1) / k;
          }
        }

        if (totalHour<=h){
            return true;
        }
        
        return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = maxOfPiles(piles);
        int ans = 0;
        while (low<=high){
            int totalHour = 0;
            int mid = low+(high-low)/2;
            if (isPossible (piles,h,totalHour,mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return ans;
    }
}
