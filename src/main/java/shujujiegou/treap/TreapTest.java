package shujujiegou.treap;

public class TreapTest {
    public static void main(String[] args) {
        Treap<Byte> treap = new Treap<Byte>();
        treap.add((byte) 1);
//        System.out.println("[test] treap = " + treap);
        treap.add((byte) 2);
//        System.out.println("[test] treap = " + treap);
        treap.add((byte) 3);
//        System.out.println("[test] treap = " + treap);
        treap.add((byte) 4);
//        System.out.println("[test] treap = " + treap);
        treap.remove((byte) 3);

        treap.remove((byte) 2);
    }
}
