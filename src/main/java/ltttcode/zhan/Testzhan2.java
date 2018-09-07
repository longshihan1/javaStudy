package ltttcode.zhan;

import java.util.Stack;

/**
 * 仅用递归函数和栈操作逆序一个栈
 * 一个栈一次压入了1、2、3、4、5，那么从栈顶到栈底分别为5、4、3、2、1.将这个栈转置后，
 * 从栈顶到栈底为1、2、3、4、5，也就是实现栈中元素的逆序，但是只能用递归函数来实现，不能用其他数据结构。
 * Created by dell on 2017/3/3.
 */
public class Testzhan2 {

    public static class Stacket {
        //递归
        public static void reverse(Stack<Integer> stack) {
            if (stack.isEmpty()) {
                return;
            }
            int i = getAndRemoveLastElement(stack);
            reverse(stack);
            stack.push(i);
            System.out.println(" "+i);
        }

        /**
         * 这个函数就是删除栈底元素并返回这个元素
         *
         * @param stack
         * @return
         */
        public static int getAndRemoveLastElement(Stack<Integer> stack) {
            int result = stack.pop();
            if (stack.isEmpty()) {
                return result;
            } else {
                int last = getAndRemoveLastElement(stack);
                stack.push(result);
                return last;
            }
        }

    }


    public static void main(String args[]) {
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        Stacket.reverse(stack);
    }
}
