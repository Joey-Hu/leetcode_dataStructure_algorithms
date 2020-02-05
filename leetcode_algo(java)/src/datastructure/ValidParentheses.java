package datastructure;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/2/2 14:53
 * @desc:
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] sChar = s.toCharArray();

        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] == '(' || sChar[i] == '[' || sChar[i] == '{') {
                stack.push(sChar[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char topStack = stack.pop();
                if (sChar[i] == '(' && topStack != ')') {
                    return false;
                }
                if (sChar[i] == '[' && topStack != ']') {
                    return false;
                }
                if (sChar[i] == '{' && topStack != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "kbbhbj{dsD}dsg";
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid(s));

    }
}
