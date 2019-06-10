package com.interview.java2blog;

/*
You need to implement Stack using Linked List. You need to write push and pop methods to demonstrate Stack behavior(Last In First Out).
 */
public class Question2 {

    public static void main(String[] args) {
        LinkedStack stackLinked = new LinkedStack();

        String position1 = "First";
        String position2 = "Second";
        String position3 = "Third";

        stackLinked.push(position1);
        stackLinked.push(position2);
        stackLinked.push(position3);

        assert(stackLinked.peek().getData()==position3);
        assert(stackLinked.pop().getData()==position3);
        assert(stackLinked.peek().getData()==position2);

//        System.out.println(stackLinked.peek().getData());
//        System.out.println(stackLinked.pop().getData());
//        System.out.println(stackLinked.peek().getData());
    }
}

class LinkedStack {
    private Node head;

    public void push(Object data){
        Node node = new Node(data);
        if(this.head==null){
            this.head = node;
            return;
        }

        node.next = this.head;
        this.head = node;
    }

    public Node pop(){
        Node o = head;
        this.head = head.next;
        return o;
    }

    public Node peek(){
       return head;
    }


    class Node{
        private Object data;
        Node next;

        Node(Object data){
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }
}
