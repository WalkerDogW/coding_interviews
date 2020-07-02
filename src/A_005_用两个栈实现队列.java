import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * @author Tao
 * @create 2020/6/28 16:01
 */
public class A_005_用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        //进队列时
        //把元素压入栈1
        stack1.push(node);
    }

    public int pop() {
        //出队列时
        //如果栈2没元素了
        if(stack2.isEmpty()){
            //则把栈1的元素依次弹出并压入栈2
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    /*
         8

    栈一：1 2 3 4 5
    栈二：

    栈一：
    栈二：5 4 3 2 1

    栈一：8
    栈二：5 4 3 2 1


     */
}
