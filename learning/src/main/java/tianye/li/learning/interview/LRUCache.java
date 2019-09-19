package tianye.li.learning.interview;
/**
 * Created by litianye on 2019-08-16
 */


import java.util.HashMap;
import java.util.Map;

/**
 * @program: learn_and_practice
 *
 * @description:
 *
 * @author: litianye
 *
 * @create: 2019-08-16
 **/

class LRUCache {
    Map<Integer, ListNode> map = new HashMap<>();
    DoubleList list = new DoubleList();
    int capacity;

    String str = "233";

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            int val = node.val;
            map.put(key, list.refresh(node));
            return val;
        }else {
            return -1;
        }

    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;
            map.put(key, list.refresh(node));
        }else {
            if (map.size() == capacity) {
                map.put(key, list.put(key,value));
            }else {
                map.put(key, list.add(key,value));
            }
        }

    }

    class DoubleList {
        ListNode head = new ListNode(Integer.MAX_VALUE, 0);
        ListNode tail = new ListNode(Integer.MIN_VALUE, 0);

        public DoubleList() {
            head.setPre(null);
            head.setNext(tail);
            tail.setPre(head);
            tail.setNext(null);
        }

        //头插
        public ListNode add(int key, int value) {
            ListNode node = new ListNode(key, value);
            ListNode tmp = head.getNext();
            head.setNext(node);
            node.setPre(head);
            node.setNext(tmp);
            tmp.setPre(node);
            return node;
        }

        //移到头部
        public ListNode refresh(ListNode node) {
            ListNode pre = node.getPre();
            ListNode next = node.getNext();
            pre.setNext(next);
            next.setPre(pre);
            return add(node.key, node.val);
        }

        //删除尾部
        public ListNode put(int key, int value) {
            ListNode LRU = tail.getPre();
            ListNode nLRU = LRU.getPre();
            nLRU.setNext(tail);
            tail.setPre(nLRU);
            map.remove(LRU.key);
            return add(key,value);
        }
    }

    class ListNode {
        int key;
        int val;
        ListNode pre;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.pre = null;
            this.next = null;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public ListNode getPre() {
            return pre;
        }

        public void setPre(ListNode pre) {
            this.pre = pre;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */