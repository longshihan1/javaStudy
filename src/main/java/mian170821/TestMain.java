package mian170821;

import mian170821.DataSource.GeneralArray;
import mian170821.DataSource.Node;
import mian170821.DataSource.RoundQueue;

/**
 * Created by dell on 2017/8/21.
 */
public class TestMain {
    public static void main(String args[]) {
     /*   GeneralArray generalArray = new GeneralArray(10);
        for (int i = 0; i < 7; i++) {
            generalArray.insert(i);
        }
        generalArray.insert(5);
        System.out.println(" " + generalArray.find(0));
        generalArray.delete(4);

        generalArray.display();

        RoundQueue queue = new RoundQueue(10);
        for (int i = 0; i < 15; i++) {
            queue.insert(i);
        }
        System.out.println(" " + queue.peek());

        queue.display();*/

        initNode();
    }

    private static void initNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node5;
        node3.right = node6;

        inOderRecur(node1);

    }



    /**
     * 前序遍历
     * @param head
     */
    public static void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.println(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 中序遍历
     * @param head
     */
    public static void inOderRecur(Node head){
        if(head == null){
            return;
        }
        inOderRecur(head.left);
        System.out.println(head.value + " ");
        inOderRecur(head.right);
    }

    /**
     * 后序遍历
     * @param head
     */
    public static void posOrderRecur(Node head){
        if(head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.value + "");
    }
}
