package com.netcracker;
import com.netcracker.sockets.PortScanner;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args){

        ForkJoinPool forkJoinPoll = new ForkJoinPool(100);
        PortScanner ps = new PortScanner();

        CopyOnWriteArrayList<String> list =  (CopyOnWriteArrayList)forkJoinPoll.invoke(ps);


        System.out.println("===============================================================");
        for(String temp: list){
            System.out.println(temp + "is OPEN \n");
        }


    }
}
