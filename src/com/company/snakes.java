package com.company;

import java.util.Map;
import java.util.TreeMap;

public class snakes {
    private Map<Integer,snake> snakeMap=new TreeMap<>();
    public void addSnake(int index,int head,int tail){
        snake snake =new snake(index,head,tail);
        snakeMap.put(head,snake);
    }

    public snake getSnakeWithHead(int head){
        //no snakes at this position
        if(snakeMap.get(head)==null) return null;
        else return snakeMap.get(head);
    }
}
