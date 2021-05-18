package com.company;

public class snake {
    private int head;
    private int tail;
    private int snakeIndex;

    public snake(int index,int head, int tail) {
        this.head = head;
        this.tail = tail;
        this.snakeIndex=index;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public int getSnakeIndex(){
        return this.snakeIndex;
    }
}
