package com.company;

import java.util.Map;
import java.util.TreeMap;

public class ladders {

    private Map<Integer,ladder> ladderMap = new TreeMap<>();
    public void addLadder(int index,int start,int end){
        ladder ladder=new ladder(index,start,end);
        ladderMap.put(start,ladder);
    }
    public ladder getLadderWithStart(int start){
        //no ladder at this position
        if(ladderMap.get(start)==null) return null;
        else return ladderMap.get(start);
    }


}
