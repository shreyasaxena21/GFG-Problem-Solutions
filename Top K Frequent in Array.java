class Solution {
    public ArrayList<Integer> topKFrequent(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        
        ArrayList<Map.Entry<Integer, Integer>> l = new ArrayList<>(map.entrySet());
        Collections.sort(l, (first,second)->first.getValue().equals(second.getValue())?second.getKey().compareTo(first.getKey()):second.getValue().compareTo(first.getValue()));
        int i = 0;
        for(Map.Entry<Integer, Integer> m : l){
            int key = m.getKey();
            if(i<k){
                result.add(key);
                i++;
            }
        }
        
        return result;
    }
}
