package com.company;

public class Main {

    public static void main(String[] args)
    {
        Interface tmp = new Interface();
        tmp.showPanel();
        CacheMemory cache = CacheMemory.getInstance();
        cache.addObserver(tmp);


    }
}
