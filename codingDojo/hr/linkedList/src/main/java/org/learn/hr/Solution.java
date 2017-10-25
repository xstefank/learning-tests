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

    private class Node {

        //testing purposes
        //adding getters and setters would be redundant
        public Node next;
        public int data;


    }
}
