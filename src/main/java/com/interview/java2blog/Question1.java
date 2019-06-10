package com.interview.java2blog;

/*
You need to implement Stack using array. You need to write push and pop methods to demonstrate Stack behavior(Last In First Out).
 */
public class Question1 {

    public static void main(String[] args) {
        ArrayStack stackArray = new ArrayStack(2);

        String position1 = "First";
        String position2 = "Second";
        String position3 = "Third";

        stackArray.push(position1);
        stackArray.push(position2);
        stackArray.push(position3);

        assert(stackArray.peek()==position3);
        assert(stackArray.pop()==position3);
        assert(stackArray.peek()==position2);
    }
}

class ArrayStack {
    private Object[] array;
    private Integer size = 0;

    ArrayStack(int size){
        this.array = new Object[size];
    }

    public void push(Object data){
        if(size == array.length){
            Object[] objects = new Object[this.array.length + this.array.length / 2];
            System.arraycopy(this.array, 0, objects, 0, this.array.length);
            array = objects;
        }
        array[size] = data;
        size++;
    }

    public Object pop(){
        Object o = array[array.length - 1];
        array[array.length - 1] = null;
        return o;
    }

    public Object peek(){
       return array[array.length - 1];
    }
}
