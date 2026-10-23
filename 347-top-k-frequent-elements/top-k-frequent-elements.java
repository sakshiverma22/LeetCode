class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer>map=new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>>minHeap=new PriorityQueue<>((a,b)->Integer.compare(a.getValue(), b.getValue()));
        for(Map.Entry<Integer, Integer>entry:map.entrySet()){
            minHeap.add(entry);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int[] res=new int[k];
        int indx=0;
        while(!minHeap.isEmpty()){
            res[indx++]=minHeap.poll().getKey();
        }
        return res;
    }
}