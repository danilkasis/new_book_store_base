package com.netcracker.sockets.server_client;

import com.netcracker.sockets.PortScanner;

import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ForkJoinPool;

public class Client {

    private static int serverPort = 1480;
    private static String address = "195.19.45.225";


    public static void main(String[] args){

            try {

                InetAddress ipAddress = InetAddress.getByName(address);
                Socket socket = new Socket(ipAddress, serverPort);
                InputStream sInput = socket.getInputStream();
                OutputStream sOutput = socket.getOutputStream();

                String answer;

                DataInputStream input = new DataInputStream(sInput);
                DataOutputStream output = new DataOutputStream(sOutput);


                while(true){

                    Scanner in = new Scanner(System.in);
                    System.out.println("Do you want to scan the ports and send the result to the server?");
                    answer = in.nextLine();

                    System.out.println("Your data will be sent to this address ->"+address+":"+serverPort);

                    int count = -1;
                    if(answer.equals("yes")) {

                        String temp;
                        ForkJoinPool forkJoinPoll = new ForkJoinPool(100);
                        PortScanner ps = new PortScanner();
                        CopyOnWriteArrayList<String> list =  (CopyOnWriteArrayList)forkJoinPoll.invoke(ps);
                        count = list.size();
                        temp = Integer.toString(count);
                        output.writeUTF(temp);

                        for(String port: list){
                            output.writeUTF(port);
                        }
                        System.out.println("Your data has been sent\n\n");
                        output.flush(); // заставляем поток закончить передачу данных.
                        temp = input.readUTF(); // ждем пока сервер отошлет строку текста.
                        System.out.println("SERVER ANSWER: "+ temp+"\n\n");
                    }
                    else {
                        String temp = Integer.toString(count);
                        output.writeUTF(temp);
                        output.flush();

                        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
                        System.out.println("Type in something and press enter. Will send it to the SERVER:");
                        System.out.println();

                        temp = keyboard.readLine(); // ждем пока пользователь введет что-то и нажмет кнопку Enter.
                        System.out.println("Sending this line to the server...");
                        output.writeUTF(temp); // отсылаем введенную строку текста серверу.
                        output.flush(); // заставляем поток закончить передачу данных.
                        temp = input.readUTF(); // ждем пока сервер отошлет строку текста.
                        System.out.println("SERVER ANSWER: " + temp);

                    }
                }


            } catch (Exception x) {
                x.printStackTrace();
            }
        }
    }