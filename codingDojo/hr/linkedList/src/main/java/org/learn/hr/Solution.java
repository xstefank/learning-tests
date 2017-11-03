package org.learn.hr;

public class Solution {

    //print each element on the new line
    public static void printElements(Node head, int data) {
        Node current = head;

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    //insert new node to the end of the list
    public Node insertLast(Node head, int data) {
        Node tail = head;

        if (tail == null) {
            Node ret = new Node();
            ret.data = data;
            ret.next = null;
            return ret;
        }

        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = new Node();
        tail.next.data = data;
        tail.next.next = null;
        return head;
    }

    public Node insertFirst(Node head, int x) {
        Node newHead = new Node();
        newHead.data = x;
        newHead.next = head;
        return newHead;

    }

    public Node insertNth(Node head, int data, int position) {
        Node current = head;
        Node newNode = new Node();
        newNode.data = data;

        if (current == null) {
            return newNode;
        }

        if (position == 0) {
            newNode.next = head;
            return newNode;
        }

        int i = 0;
        while (i < position - 1 && current.next != null) {
            current = current.next;
            i++;
        }

        Node nextElem = current.next;

        current.next = newNode;
        newNode.next = nextElem;

        return head;
    }

    public Node delete(Node head, int position) {
        Node current = head;

        if (current == null) {
            return null;
        }

        if (position == 0) {
            return head.next;
        }

        int i = 0;
        while (i < position - 1 && current.next != null) {
            current = current.next;
            i++;
        }

        Node deleted = current.next;
        current.next = deleted != null ? deleted.next : null;

        return head;
    }

    public void ReversePrint(Node head) {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            System.out.println(head.data);
            return;
        }

        Node prevElem = head;
        Node current = head.next;
        prevElem.next = null;


        while (current != null) {
            Node nextElem = current.next;
            current.next = prevElem;
            prevElem = current;
            current = nextElem;
        }

        current = prevElem;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public Node reverse(Node head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        Node prevElem = head;
        Node current = head.next;
        prevElem.next = null;

        while (current != null) {
            Node nextElem = current.next;
            current.next = prevElem;
            prevElem = current;
            current = nextElem;
        }

        return prevElem;
    }

    public int compareLists(Node headA, Node headB) {
        Node currentA = headA;
        Node currentB = headB;

        if (currentA == null || currentB == null) {
            return (currentA == null && currentB == null) ? 1 : 0;
        }

        while (currentA != null) {
            if (currentB == null) {
                return 0;
            }

            if (currentA.data != currentB.data) {
                return 0;
            }

            currentA = currentA.next;
            currentB = currentB.next;
        }

        if (currentB != null) {
            return 0;
        }

        return 1;
    }

    public Node mergeLists(Node headA, Node headB) {
        if (headA == null) {
            return headB;
        }

        if (headB == null) {
            return headA;
        }
        Node currentA = headA;
        Node currentB = headB;
        Node retHead = null;
        if (headA.data < headB.data) {
            retHead = headA;
            currentA = headA.next;
        } else {
            retHead = headB;
            currentB = headB.next;
        }

        Node currentRet = retHead;

        while (currentA != null || currentB != null) {
            if (currentA != null && currentB != null) {
                if (currentA.data < currentB.data) {
                    currentRet.next = currentA;
                    currentA = currentA.next;
                } else {
                    currentRet.next = currentB;
                    currentB = currentB.next;
                }
            } else if (currentA == null) {
                currentRet.next = currentB;
                currentB = currentB.next;
            } else {
                currentRet.next = currentA;
                currentA = currentA.next;
            }

            currentRet = currentRet.next;
        }

        return retHead;
    }

    public static int getNode(Node head, int positionFromTail) {
        int length = getLength(head);
        int positionFromHead = length - positionFromTail - 1;
        Node current = head;

        if (current == null) {
            //no elements
            return -1;
        }

        for (int i = 0; i < positionFromHead; i++) {
            current = current.next;
        }

        return current.data;
    }

    private static int getLength(Node head) {
        int length = 0;
        Node current = head;

        while (current != null) {
            length++;
            current = current.next;
        }

        return length;
    }

    public Node removeDuplicates(Node head) {
        Node current = head;

        if (current == null) {
            return null;
        }

        while (current.next != null) {
            Node nextNode = current.next;
            while (nextNode.next != null && nextNode.data == nextNode.next.data) {
                nextNode = nextNode.next;
            }

            current.next = nextNode;
            current = current.next;
        }

        return head;
    }

    public static boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }

        Node current = head;

        while (current != null) {
            Node temp = head;

            while (temp != current) {
                if (current.next == temp) {
                    return true;
                }
                temp = temp.next;
            }

            current = current.next;
        }

        return false;
    }

    public int findMergeNode(Node headA, Node headB) {
        Node currentA = headA;

        while (currentA != null) {
            Node currentB = headB;

            while (currentB != null) {
                if (currentA == currentB) {
                    return currentA.data;
                }

                currentB = currentB.next;
            }

            currentA = currentA.next;
        }


        return 0;
    }

    public static Node sortedInsert(Node head, int data) {
        Node insertNode = new Node();
        insertNode.data = data;

        Node current = head;

        if (current == null) {
            //empty list
            return insertNode;
        }

        while (current.next != null && current.next.data < data) {
            current = current.next;
        }

        if (current.next == null) {
            //insert to the end
            current.next = insertNode;
            insertNode.prev = current;
            return head;
        }

        current.next.prev = insertNode;
        insertNode.next = current.next;
        current.next = insertNode;
        insertNode.prev = current;

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node();
        head.data = 1;
        head.next = new Node();
        head.next.data = 2;
        head.next.prev = head;
        head.next.next = new Node();
        head.next.next.data = 4;
        head.next.next.prev = head.next;

        printElements(sortedInsert(head, 3), 0);

    }


    private static class Node {

        //testing purposes
        //adding getters and setters would be redundant
        public Node next;
        public Node prev;
        public int data;


    }
}
