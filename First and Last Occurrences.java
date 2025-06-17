// User function Template for Java

class GFG {
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
    
    
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        int first = getFirst(arr,x);
        int last = getLast(arr, x);
        ArrayList<Integer> list = new ArrayList<>();
        
        list.add(first);
        list.add(last);
        
        return list;
    }
    
}
