package sdk.HashMap;

import java.util.Iterator;
import java.util.Objects;

/**
 * Created by longshihan on 2017/4/1.
 * 手写hashmap的实现
 */
public class MyHashMap<K, V> {

    private Node<K, V>[] table;
    private static final int DEfault_INITANCE = 1 << 4;
    private static final float DEFAULT_LOAD = 0.75f;
    private static int size = 0;
    private static int inload;

    static class Node<K, V> {
        private int hash;
        private K key;
        private V value;
        private Node<K, V> nextNode;

        public Node(int hash, K key, V value, Node<K, V> nextNode) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.nextNode = nextNode;
        }

        public int getHash() {
            return hash;
        }

        public void setHash(int hash) {
            this.hash = hash;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<K, V> nextNode) {
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(key + "(" + hash + ")");
            stringBuffer.append("=");
            stringBuffer.append(value);
            stringBuffer.append(",");
            if (nextNode != null) {
                stringBuffer.append(nextNode.toString());
            }

            return stringBuffer.toString();
        }


    }

    public void put(K key, V value) {
        //获取hash
        //int hashcode=key==null?0:key.hashCode();
        int hash = Objects.hashCode(key);
        //指定数组长度。初始化
        int length = DEfault_INITANCE;

        if (table == null) {
            inload = (int) (DEfault_INITANCE * DEFAULT_LOAD);
            table = new Node[length];
        }
        //根据key算出hash值
        //&操作
        //  0101&1111=0101
        // int i = hash % length;//数组下标
        int i = hash & (length - 1);
        //判断table[]是否存在
        if (null == table[i]) {
            table[i] = new Node<K, V>(hash, key, value, null);
        } else {
            Node<K, V> node = table[i];
            //判断table[i]是的等于传入的value值
            if ((hash == node.hash) && (node.key == key || (key != null && node.key.equals(key)))) {
                node.value = value;
            } else {
                for (int count = 0; ; count++) {
                    if (null == node.nextNode) {
                        node.nextNode = new Node<K, V>(hash, key, value, null);
                        break;
                    } else {
                        //判断next
                        if ((node.nextNode.hash == hash) && (node.nextNode.key == key || (key != null && node.nextNode.key.equals(key)))) {
                            node.nextNode.value = value;
                            break;
                        }
                    }
                }
            }
        }
        size++;
        if (size >= inload) {

            resize();
        }
    }

    //扩容
    private void resize() {
        //翻倍
        int newCapacity = table.length << 1;
        inload = (int) (newCapacity * DEFAULT_LOAD);
        Node<K, V>[] newTable = new Node[newCapacity];
        //转移数据
        for (Node<K, V> old : table) {
            if (null == old) {
                continue;
            }
            for (int count = 0; ; count++) {
                if (old == null) {
                    break;
                }
                Node<K, V> next = old.nextNode;
                //获取新table的下标
                int i = old.hash & (newCapacity - 1);
                old.nextNode = newTable[i];
                newTable[i] = old;
                old = next;
            }
        }

        //替换table
        table = newTable;
    }

    public V get(K key) {
        //获取key的hash值
        int hash = Objects.hashCode(key);
        //判断table
        if (table == null || table.length <= 0) {
            return null;
        }
        //哈希table数组下标
        int i = hash % table.length;

        Node<K, V> node = table[i];
        if (node == null) {
            return null;
        }

        //判断key是否相等
        if ((node.hash == hash) && ((node.key == key) || (key != null && node.key.equals(key)))) {
            return node.value;
        } else {
            for (int count = 0; ; count++) {
                if (node.nextNode != null) {
                    if ((node.nextNode.hash == hash) && ((node.nextNode.key == key) || (key != null && node.nextNode.key.equals(key)))) {
                        return node.nextNode.value;
                    }
                    node = node.nextNode;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("{");
        for (Node<K, V> node : table) {
            if (null == node) {
                continue;
            }
            stringBuffer.append(node.toString());

        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public int size() {
        return size;
    }

    public MyIterator myIterator(){
        return new MyIterator();
    }
    class MyIterator implements Iterator<K> {

        private Node<K, V> current;
        private Node<K, V> next;
        private int index;

        public MyIterator() {
            current = null;
            next = null;
            index = 0;
            //第一个非null的数组元素，
            if (table == null || size <= 0) {
                return;
            }

            for (int count = 0; ; count++) {
                if (index >= table.length) {
                    break;
                }
                next = table[index++];
                if (next != null) {
                    break;
                }
            }

        }


        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public K next() {
            //处理一下current
            current = next;
            //处理next
            if (table != null && next.nextNode != null) {
                next = current.nextNode;
            } else {
                for (int count = 0; ; count++) {
                    if (index >= table.length) {
                        break;
                    }
                    next = table[index++];
                    if (next != null) {
                        break;
                    }
                }
            }
            return current.key;
        }
    }
}
