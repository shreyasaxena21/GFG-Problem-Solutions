// User function Template for Java

class Solution {
    int getOddOccurrence(int[] arr, int n) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
            
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue()%2!=0){
                return entry.getKey();
            }   
        }
        
        return 0;
    }
}
