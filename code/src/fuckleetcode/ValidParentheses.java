package fuckleetcode;


import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/2/9 12:14
 * @desc:
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }else{
                if (stack.isEmpty()) {
                    return false;
                }

                char topStack = stack.pop();
                if(s.charAt(i) == ')' && topStack != '('){
                    return false;
                }
                if(s.charAt(i) == ']' && topStack != '['){
                    return false;
                }
                if(s.charAt(i) == '}' && topStack != '{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
