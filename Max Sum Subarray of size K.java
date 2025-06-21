// User function Template for Java

class Solution {
    public int maximumSumSubarray(int[] arr, int k) {
        // Code here
        //sliding window
        
        int sum = 0;
        for(int i = 0; i<k; i++){
            sum = sum + arr[i];
        }
        
        int max = sum;
        for(int i = k; i < arr.length; i++){
            sum = sum - arr[i-k] + arr[i];
            max = Math.max(max, sum);
        }
        
        return max;
    }
}