class TimeMap {
    class Pair{
        String key;
        String value;
        int time;

        Pair (String key,String value,int time){
            this.key = key;
            this.value = value;
            this.time = time;
        }
    }
    ArrayList<Pair> list;
    ArrayList<Integer> timeList;
    HashMap<Integer,Integer> map;
    int idx;
    public boolean isTimeStampPresent (ArrayList<Pair> list,String key,int timestamp){
        for (int i=0;i<list.size();i++){
            if (list.get(i).key.equals(key) && list.get(i).time==timestamp){
                return true;
            }
        }
        return false;
    }
    public TimeMap() {
        list = new ArrayList<>();
        timeList = new ArrayList<>();
        map = new HashMap<>();
        idx = 0;
    }
    
    public void set(String key, String value, int timestamp) {
        list.add(new Pair(key,value,timestamp));
        timeList.add(timestamp);
        map.put(timestamp,idx);
        idx++;
    }
    
    public String get(String key, int timestamp) {
        String ans = "";
        if (isTimeStampPresent (list,key,timestamp)){
            return list.get(map.get(timestamp)).value;
        }
        else{
            while (timestamp>=1){
                timestamp = timestamp-1;
            if (isTimeStampPresent(list,key,timestamp)){
                 ans = list.get(map.get(timestamp)).value;
                 break;
            }
          }
        }

        return ans;
    }
}
