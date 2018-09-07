package ltttcode.zhan;

import java.util.Stack;

/**
 * 两个栈拼出一个队列
 * Created by dell on 2017/3/3.
 */
public class TestQueue {
    public static class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        /**
         * add添加stack1数据
         *
         * @param addnum
         */
        public void add(Integer addnum) {
            stack1.push(addnum);
        }

        /**
         * 弹出数据
         *
         * @return
         */
        public Integer poll() {
            popInterager();
            return stack2.pop();
        }

        public Integer peek(){
            popInterager();
            return stack2.peek();
        }

        private void popInterager() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                throw new RuntimeException("空");
            } else if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
        }

    }


    public static void main(String args[]) {


    }
}
