package ltttcode.zhan;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * <p>
 * 要求：
 * <p>
 * 1、pop、push、getMin操作的时间复杂度都是O(1)
 * 2、设计的栈类型可以输用现成的栈结构
 * <p>
 * 使用辅助栈,只存储每次进去的最小值
 * Created by dell on 2017/3/3.
 */
public class TestZhan {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public TestZhan() {
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    /**
     * 压入操作
     * todo:2017-8-25 修改最小弹出栈的弹出顺序
     *
     * @param newNum
     */
    public void push(int newNum) {
        if (stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else {
            if (newNum <= stackMin.peek()) {
                stackMin.pop();
                stackMin.push(newNum);
            }
        }
        stackData.push(newNum);

    }

    /**
     * 弹出操作
     *
     * @return
     */
    public int pop() {
        if (stackData == null) {
            throw new RuntimeException("Your Stack isEmpty");
        }
        int value = stackData.pop();
        if (stackMin.peek() == value) {
            stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is Empty.");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        TestZhan stack1 = new TestZhan();
        stack1.push(3);
        stack1.push(2);
        stack1.push(1);
        int stack = stack1.pop();
        int min = stack1.getMin();
        System.out.println(stack + "," + min + "");
    }
}
