class Solution {
    public int maxConsecutiveCount(int[] arr) {
        // code here
        int current = 1;
        int max = 0;
        for(int i = 0 ; i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                current++;
               
            }
            else{
                max = Math.max(current, max);
                current = 1;
            }
        }
        
         max = Math.max(max, current);
        return max;
    }
}
