package com.interview.glassdoor;

import org.junit.Test;

import java.util.Objects;
import java.util.Scanner;

/*
How to get the k'th element from the end of a doubly linked list.
 */
public class RemoveTheKthElementDoublyLinkedList {

    // Time complexity is O(2n)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Type the list size: ");
        Integer number = Integer.parseInt(sc.next());
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < number; i++) {
            if (i == 0) {
                linkedList = new LinkedList(sc.next());
            } else {
                linkedList.add(new LinkedList.Node(sc.next()));
            }
        }
        System.out.print("Type the kth element that you want to remove: ");
        Integer position = Integer.parseInt(sc.next());
        RemoveTheKthElementDoublyLinkedList removeTheKthElementDoublyLinkedList = new RemoveTheKthElementDoublyLinkedList();

        LinkedList solution = removeTheKthElementDoublyLinkedList.solution(position, linkedList);
        if (solution == null || solution.head() == null) return;
        LinkedList.Node head = solution.head();
        while (head.getNext() != null) {
            System.out.println(head);
            head = head.getNext();
        }
        System.out.println(head);
    }

    public LinkedList solution(Integer position, LinkedList list) {
        if (position == null) return list;
        if (position == 1) return new LinkedList();
        if (list == null || list.head() == null || list.head().getNext() == null || position <= 0) return list;


        LinkedList.Node desiredNode = list.head();
        int listSize = 0;
        while (true) {
            desiredNode = desiredNode.getNext();
            if (desiredNode != null) {
                listSize++;
            } else {
                listSize++;
                break;
            }
        }
        int counter = 0;
        desiredNode = list.head();

        for (int i = 0; i < listSize; i++) {
            if (counter == 0) counter = position - 1;

            desiredNode = desiredNode.getNext();
            counter--;
            if (counter == 0) {
                list.remove(desiredNode);
                counter = position;
                i++;
            }
        }

        return list;
    }

    @Test
    public void testSolution() {

        LinkedList linkedList = new LinkedList("1");
        linkedList.add(new LinkedList.Node("2"));
        linkedList.add(new LinkedList.Node("3"));
        linkedList.add(new LinkedList.Node("4"));
        linkedList.add(new LinkedList.Node("5"));
        solution(2, linkedList);
//        Assert.assertThat(solution("test/works/maybe"), is("maybe"));
//        Assert.assertThat(solution("/test/slash/begin"), is("begin"));
//        Assert.assertThat(solution("test/123"), is(""));
//        Assert.assertThat(solution("///test"), is(""));
//        Assert.assertThat(solution(""), is(""));
//        Assert.assertThat(solution(null), is(""));
    }
}

class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList(String data) {
        this.head = new Node(data);
        tail = head;
    }

    public LinkedList() {
    }

    public Node head() {
        return head;
    }

    public void add(Node node) {
        node.before = tail;
        tail.next = node;
        tail = node;
    }

    public void remove(Node node) {
        node.before.setNext(node.next);
        if (node.next != null) {
            node.next.setBefore(node.before);
        }
    }

    public static class Node {
        private Node next;
        private String data;
        private Node before;

        public Node(String data) {
            this.data = data;
        }

        public void setBefore(Node before) {
            this.before = before;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public String toString() {
            return this.data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(data, node.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }
}
