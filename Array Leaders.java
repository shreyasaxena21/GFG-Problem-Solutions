class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> leaders = new ArrayList<>();
        int leader = 0;
        for(int i=arr.length-1; i>=0; i-- ){
            if(arr[i]>=leader){
                leader = arr[i];
                leaders.add(leader);
            }
        }
        
        Collections.reverse(leaders);
        return leaders;
    }
}
