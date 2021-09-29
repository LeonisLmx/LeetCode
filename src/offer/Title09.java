package offer;

import java.util.Stack;

/**
 * @Author: Urey
 * @Date: 2020/12/22
 */
public class Title09 {

    Stack<Integer> stack;
    Stack<Integer> stackOther;

    public Title09() {
        this.stack = new Stack<>();
        this.stackOther = new Stack<>();
    }

    public void appendTail(int value) {
        stack.push(value);
    }

    public int deleteHead() {
        if (stack.isEmpty() && stackOther.isEmpty()){
            return -1;
        }
        if (stackOther.isEmpty()){
            while (stack.size() > 0){
                stackOther.push(stack.pop());
            }
        }
        return stackOther.pop();
    }
}
