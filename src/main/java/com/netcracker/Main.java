package com.netcracker;
import com.netcracker.sockets.PortScanner;

import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args){

        ForkJoinPool forkJoinPoll = new ForkJoinPool(100);
        PortScanner ps = new PortScanner();

        forkJoinPoll.invoke(ps);

    }
}
