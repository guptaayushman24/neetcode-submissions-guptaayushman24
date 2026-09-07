class Pair{
    int ele;
    int freq;

    Pair (int ele,int freq){
        this.ele = ele;
        this.freq = freq;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int [] ans = new int [k];
        int x = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            if (a.freq==b.freq){
                return b.ele-a.ele;
            }
            return b.freq-a.freq;
        });

        for (int i=0;i<nums.length;i++){
          if (hm.containsKey(nums[i])){
            int freq = hm.get(nums[i]);
            hm.put(nums[i],freq+1);
          }
          else{
            hm.put(nums[i],1);
          }
        }

        hm.forEach((key,value)->{
            pq.add(new Pair(key,value));
        });

        while (k>0){
            ans[x] = pq.peek().ele;
            pq.remove();
            x++;
            k--;
        }

        return ans;
    }
}
