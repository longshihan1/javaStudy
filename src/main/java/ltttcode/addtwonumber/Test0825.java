package ltttcode.addtwonumber;

/**
 * Created by dell on 2017/8/25.
 */
public class Test0825 {
    public static void main(String args[]) {
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode li1 = new ListNode(5);
        ListNode li2 = new ListNode(6);
        ListNode li3 = new ListNode(4);
        li1.next = li2;
        li2.next = li3;
        l1.next = l2;
        l2.next = l3;
        //addtwo1(l1, li1);



        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        LinkList linkList=new LinkList();
        linkList.addFirstNode(1);
        linkList.add(0,2);
        while (node1!=null){
            System.out.println(" "+node1.data);
            node1=node1.next;
        }
    }

    private static ListNode addtwo1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode root = new ListNode(0);
        ListNode r = root;
        r.next = l1;
        int carry = 0; // 初始进位
        int sum;
        while (p1 != null && p2 != null) {
            sum = p1.val + p2.val + carry;
            p1.val = sum % 10;
            carry = sum / 10;

            r.next = p1;
            r = p1;
            p1 = p1.next;
            p2 = p2.next;
        }

        if (p1 == null) {
            r.next = p2;
        } else {
            r.next = p1;
        }
        if (carry == 1) {
            while (r.next != null) {
                sum = r.next.val + carry;
                r.next.val = sum % 10;
                carry = sum / 10;
            }
            if (carry == 1) {
                r.next = new ListNode(1);
            }
        }
        return root.next;
    }
}
