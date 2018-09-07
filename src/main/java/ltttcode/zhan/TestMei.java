package ltttcode.zhan;

import java.util.Iterator;

/**
 * 实现stack 的pop和push接口 要求：
 - 1.用基本的数组实现
 - 2.考虑范型
 - 3.考虑下同步问题
 - 4.考虑扩容问题
 * Created by dell on 2017/3/9.
 */
public class TestMei {

    public static void main(String args[]) {
        TestStack testStack=new TestStack();
        String tets="wencwecbnbcoajdbca";
        String[] tests=tets.split("");
        for (int i = 0; i < tests.length; i++) {
            testStack.push(tests[i]);
        }

        while (testStack.hasNext()){
            System.out.print(" "+testStack.next());
        }
       // System.out.println(" "+testStack.pop());

    }
}
