package fuckleetcode;

import java.util.Stack;

/**
 * @author: huhao
 * @time: 2020/2/9 10:48
 * @desc:
 */
public class MinStack {
    Stack<Integer> stack;

    int min = Integer.MAX_VALUE;

    public MinStack(){
        stack = new Stack<Integer>();
    }

    public void push(int x){
        min = Math.min(x, min);
        stack.push(x);
    }

    public void pop(){
        stack.pop();
    }

    public int top(){
        int ret = stack.get(0);
        return ret;
    }

    public int getMin(){
        return min;
    }
}
