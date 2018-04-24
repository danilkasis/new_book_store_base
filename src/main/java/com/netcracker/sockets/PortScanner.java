package com.netcracker.sockets;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.RecursiveAction;


public class PortScanner extends RecursiveAction {

    private final String IP = "195.19.34.72"; //ОЧЕНЬ ВАЖНО ПИСАТЬ СВОЙ IP

    private int minPort;
    private int maxPort;
    private int range = 20;


    public PortScanner() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter minPort: ");
        this.minPort = in.nextInt();
        System.out.println("Enter maxPort: ");
        this.maxPort = in.nextInt();

        System.out.println("Please waite");

    }

    private PortScanner(int minPort,int maxPort) {
        this.minPort = minPort;
        this.maxPort = maxPort;
    }

    @Override
    protected void compute() {

        if ((this.maxPort - this.minPort) > range) { // Дробим задачи

            PortScanner newFolk1 = new PortScanner(this.minPort+range,this.maxPort);
            newFolk1.fork();
            chekPort(this.minPort, this.minPort+range);
            newFolk1.join();
            System.out.println(Thread.currentThread().getName()+ " отработал");
        } else { // Выполняем сами
            chekPort(this.minPort, this.maxPort);
        }
    }

    public void chekPort(int minPort, int maxPort) {

        for (int i = minPort; i <= maxPort; i++) {
            try {
                Socket socket = new Socket();
                socket.connect(new InetSocketAddress(IP, i));
                socket.close();
                System.out.println(IP + ":" + i + " port is OPEN" + "=========>>>>" + Thread.currentThread().getName());
            } catch (Exception ex) {
                //System.out.println(IP + ":" + i + " CLOSE" + "" + Thread.currentThread().getName());
            }
        }
    }
}
