class Solution {
    
    int getFirst(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int firstIndex = -1;
          
        while(low<=high){
            int mid = low + (high-low)/2;
          
            if(arr[mid] == x){
                firstIndex = mid;
                // move left
                high = mid-1; 
            }
            
            else if(arr[mid]<x){
                low = mid+1;
            }
            
            else{
                high = mid-1;
            }
        }
        return firstIndex;
    }
    
     int getLast(int[] arr, int x){
        int low = 0;
        int high = arr.length-1;
        int lastIndex = -1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] == x){
                lastIndex = mid;
                // move right
                low = mid+1; 
            }
            
            else if(arr[mid]<x){
                low = mid+1;
            }
            
            else{
                high = mid-1;
            }
        }
        return lastIndex;
    }
    
    
    int countFreq(int[] arr, int target) {
        // code here
        int first = getFirst(arr, target);
        int last = getLast(arr, target);
        
        if(first == -1){
            return 0;
        }
        
        return last - first + 1;
        
    }
}
