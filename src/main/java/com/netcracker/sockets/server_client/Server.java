package com.netcracker.sockets.server_client;

import java.net.*;
import java.io.*;

public class Server {

    //public void startServer()
    public static void main(String[] args) {
        int port = 1480;

        try {

            ServerSocket ss = new ServerSocket(port);

            System.out.println("Waiting for a client...");
                    Socket socket = ss.accept();

                    System.out.println("Got a client"+"\n");


                    //входной и выходной потоки сокета
                    InputStream sinput = socket.getInputStream();
                    OutputStream soutput = socket.getOutputStream();

                    // Конвертируем потоки в другой тип, чтоб легче обрабатывать текстовые сообщения.
                    DataInputStream input = new DataInputStream(sinput);
                    DataOutputStream output = new DataOutputStream(soutput);

                    String temp = null;
                    int count = 0;
                    boolean flag = true;
                    BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

                    while(true){

                        temp = input.readUTF();
                        count = Integer.parseInt(temp);

                        if(count >= 0){
                            System.out.println("The client sent "+ count + " ports: \n");
                            for(int i = 0; i < count; i++){

                                temp = input.readUTF();
                                System.out.println("PORT: "+temp+" is OPEN");

                            }

                            System.out.println("======================" +
                                    "\nType in something and press enter. Will send it to the CLIENT: ");

                            temp = keyboard.readLine(); // ждем пока пользователь введет что-то
                            System.out.println("Your letter has been sent\n");
                            output.writeUTF(temp); // отсылаем введенную строку текста
                            output.flush();
                        }
                        else{

                            temp = input.readUTF();

                            System.out.println("The client sent it:"+temp+ "\n");

                            System.out.println("Type in something and press enter. Will send it to the CLIENT: \n");

                            temp = keyboard.readLine(); // ждем пока пользователь введет что-то.
                            System.out.println("Sending this line to the CLIENT...");
                            output.writeUTF(temp); // отсылаем введенную строку текста
                            output.flush();
                        }


                    }


        } catch (Exception x) {
            x.printStackTrace();
        }

    }
}


