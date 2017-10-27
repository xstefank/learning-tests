package org.learn.hr;

public class Solution {

    //print each element on the new line
    public void printElemnts(Node head, int data) {
        Node current = head;

        while (current != null) {
            System.out.println(current);
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
        return  newHead;

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
        while (i < position - 1&& current.next != null) {
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

    private class Node {

        //testing purposes
        //adding getters and setters would be redundant
        public Node next;
        public int data;


    }
}
