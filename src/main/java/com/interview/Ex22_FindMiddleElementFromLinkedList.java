package com.interview;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;
import java.util.Scanner;

import static org.hamcrest.CoreMatchers.is;

/*
How do you find the middle element of LinkedList in one pass is a programming question often asked
Java and non-Java programmers in telephonic Interview. This question is similar to checking palindrome
or calculating the factorial, where Interviewer sometimes also ask to write code. In order to answer
this question candidate must be familiar with LinkedList data structure i.e. In the case of singly
LinkedList, each node of Linked List contains data and pointer, which is the address of next Linked
List and the last element of Singly Linked List points towards the null. Since in order to find middle
element of Linked List you need to find the length of linked list, which is counting elements till end
i.e. until you find the last element of Linked List.

Read more: https://javarevisited.blogspot.com/2012/12/how-to-find-middle-element-of-linked-list-one-pass.html#ixzz5nsjCkCPH
 */
public class Ex22_FindMiddleElementFromLinkedList {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //String word = sc.next();
        Ex22_FindMiddleElementFromLinkedList ex22 = new Ex22_FindMiddleElementFromLinkedList();
        LinkedList linkedList = new LinkedList();
        linkedList.head();
        linkedList.add(new LinkedList.Node("1"));
        linkedList.add(new LinkedList.Node("2"));
        linkedList.add(new LinkedList.Node("3"));
        linkedList.add(new LinkedList.Node("4"));
        linkedList.add(new LinkedList.Node("5"));
        linkedList.add(new LinkedList.Node("6")); // Middle
        linkedList.add(new LinkedList.Node("7"));
        linkedList.add(new LinkedList.Node("8"));
        linkedList.add(new LinkedList.Node("9"));
        linkedList.add(new LinkedList.Node("10"));
        linkedList.add(new LinkedList.Node("11"));
        linkedList.add(new LinkedList.Node("12"));
        System.out.println(ex22.solution(linkedList));
    }

    public LinkedList.Node solution(LinkedList linkedList) {
        linkedList.head();
        LinkedList.Node current = linkedList.head();
        LinkedList.Node last = linkedList.head();
        Boolean i = true;
        int counter = 0;
        while (i) {
            last = last.next();
            if (last != null) {
                counter++;
            } else {
                i = false;
            }
        }
        last = current;
        for (int j = 1; j <= counter / 2; j++) {
            last = last.next();
        }
        return last;

    }

    @Test
    public void testSolution() {
        LinkedList linkedList = new LinkedList();
        linkedList.head();
        linkedList.add(new LinkedList.Node("1"));
        linkedList.add(new LinkedList.Node("2"));
        linkedList.add(new LinkedList.Node("3"));
        linkedList.add(new LinkedList.Node("4"));
        Assert.assertThat(solution(linkedList), is(new LinkedList.Node("2")));
        linkedList.add(new LinkedList.Node("5"));
        linkedList.add(new LinkedList.Node("6")); // Middle
        linkedList.add(new LinkedList.Node("7"));
        linkedList.add(new LinkedList.Node("8"));
        Assert.assertThat(solution(linkedList), is(new LinkedList.Node("4")));
        linkedList.add(new LinkedList.Node("9"));
        linkedList.add(new LinkedList.Node("10"));
        linkedList.add(new LinkedList.Node("11"));
        linkedList.add(new LinkedList.Node("12"));
        Assert.assertThat(solution(linkedList), is(new LinkedList.Node("6")));
    }

}

class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = new Node("head");
        tail = head;
    }

    public Node head() {
        return head;
    }

    public void add(Node node) {
        tail.next = node;
        tail = node;
    }

    public static class Node {
        private Node next;
        private String data;

        public Node(String data) {
            this.data = data;
        }

        public String data() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public Node next() {
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