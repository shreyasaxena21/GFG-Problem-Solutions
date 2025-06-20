import java.util.HashMap;

class Solution {
    int maxLen(int arr[]) {
        // Create a map to store the first occurrence of a prefix sum
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int maxLength = 0;
        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // If prefix sum is 0, update maxLength (from 0 to i)
            if (prefixSum == 0) {
                maxLength = i + 1;
            }

            // If prefix sum is already seen, subarray from previous index+1 to i has sum 0
            if (map.containsKey(prefixSum)) {
                int prevIndex = map.get(prefixSum);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                // Store the first occurrence of this prefix sum
                map.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}
