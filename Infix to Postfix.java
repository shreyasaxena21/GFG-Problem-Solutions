class Solution {
    public static String infixToPostfix(String s) {
        // code here
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                result.append(ch);
            }
            
            else if(ch=='('){
                stack.push(ch);
                
            }
            
            else if(ch==')'){
                while(!stack.isEmpty() && stack.peek()!='('){
                    result.append(stack.pop());
                }
                
                stack.pop();
            }
            
            else{
                while(!stack.isEmpty() && precedence(ch)<=precedence(stack.peek())){
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        
        return result.toString();
        
    }
    
    private static int precedence(char operator){
        switch(operator){
            case '+':
                case '-':
                    return 1;
            case '*':
                case '/':
                    return 2;
            case '^':
                return 3;
                
            default:
                return 0;
        }
    }
}