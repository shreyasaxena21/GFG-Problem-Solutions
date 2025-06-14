class Solution {
    public void reverseArray(int arr[]) {
        // code here
        int low = 0;
        int high = arr.length-1;
        while(low<high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }
}