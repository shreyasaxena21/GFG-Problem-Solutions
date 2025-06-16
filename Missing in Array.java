/*Complete the function below*/
class GfG {
    
     public void sortHelper(Stack<Integer> s) {
        if(s.isEmpty()){
            return;
        }
        
        int top = s.pop();
        sortHelper(s);
        doTheSort(top,s);
     }   
    
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        
        sortHelper(s);
        return s;
        
        
    }
    
    void doTheSort(int top, Stack<Integer> s){
        if(s.isEmpty() || s.peek()<top){
            s.push(top);
            return;
        }   
        
        int topValue = s.pop();
        doTheSort(top, s);
        s.push(topValue);
    }
}