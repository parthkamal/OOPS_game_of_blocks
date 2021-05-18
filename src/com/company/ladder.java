package com.company;

public class ladder {
    private int start;
    private int end;
    private int ladderIndex;


    public ladder(int index,int start, int end) {
        this.ladderIndex =index;
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getIndex(){
        return this.ladderIndex;
    }


}
