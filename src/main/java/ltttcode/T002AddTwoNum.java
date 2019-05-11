package ltttcode;


public class T002AddTwoNum {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        ListNode l2=new ListNode(4);
        ListNode l3=new ListNode(3);
        l1.next=l2;
        l2.next=l3;

        ListNode li1=new ListNode(5);
        ListNode li2=new ListNode(6);
        ListNode li3=new ListNode(4);
        li1.next=li2;
        li2.next=li3;
        addTwoNumbers(l1,li1);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode node = new ListNode(0);
        ListNode n1 = l1, n2 = l2, t = node;
        int sum = 0;
        while (n1 != null || n2 != null) {
            sum /= 10;
            if (n1 != null) {
                sum += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                sum += n2.val;
                n2 = n2.next;
            }
            t.next = new ListNode(sum % 10);
            t = t.next;
        }
        if (sum / 10 != 0) t.next = new ListNode(1);
        return node.next;
    }

}
