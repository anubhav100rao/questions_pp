import java.util.HashMap;

class LinkedListNode {
    int val;
    LinkedListNode next;

    LinkedListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class LinkedList {
    LinkedListNode head;
    LinkedListNode tail;

    LinkedList() {
        head = null;
    }

    void pushNode(int val) {
        LinkedListNode node = new LinkedListNode(val);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    void pushNode(LinkedListNode node) {
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    void printLinkedList() {
        LinkedListNode temp = head;
        HashMap<LinkedListNode, Boolean> seenNodes = new HashMap<>();
        while (temp != null) {
            if (seenNodes.containsKey(temp)) {
                System.out.println("Cycle detected at node" + temp.val + " ---- breaking the loop");
                break;
            }
            seenNodes.put(temp, true);
            System.out.print(temp.val + " -> ");
            temp = temp.next;

        }
        System.out.println("NULL");
    }

    void reverseLinkedList() {
        if (head == null) {
            System.out.println("Please create linkedlist before reversing it.");
            return;
        }
        LinkedListNode prevNode = null, currNode = head, nextNode = head.next;
        tail = currNode;

        while (currNode != null) {
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
            if (nextNode != null)
                nextNode = nextNode.next;
        }

        head = prevNode;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode tail = null;

        while (true) {
            int smallIdx = -1; // it will store index of current smallest head among available linkedLists

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    if (smallIdx == -1) {
                        smallIdx = i;
                    } else if (lists[smallIdx].val > lists[i].val) {
                        smallIdx = i;
                    }
                }
            }

            if (smallIdx == -1)
                break;
            if (head == null) {
                head = new ListNode(lists[smallIdx].val);
                tail = head;
                lists[smallIdx] = lists[smallIdx].next;
            } else {
                tail.next = new ListNode(lists[smallIdx].val);
                tail = tail.next;
                lists[smallIdx] = lists[smallIdx].next;
            }
        }

        return head;
    }
}

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.pushNode(10);
        linkedList.pushNode(20);
        linkedList.pushNode(30);
        LinkedListNode node40 = new LinkedListNode(40);
        linkedList.pushNode(node40);
        linkedList.pushNode(50);
        linkedList.pushNode(60);
        linkedList.pushNode(70);

        LinkedListNode node80 = new LinkedListNode(80);
        linkedList.pushNode(node80);

        node80.next = node40;

        linkedList.printLinkedList();
    }
}
