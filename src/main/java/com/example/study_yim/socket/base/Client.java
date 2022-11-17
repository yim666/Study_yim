package com.example.study_yim.socket.base;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    private Socket socket;

    public Client() {
        try {
            System.out.println("正在连接服务端.....");
            this.socket = new Socket("localhost", 8099);
            System.out.println("连接服务端.....Success");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void start() {
        try {
            //启动一个线程 不停接收服务端消息
            Thread t = new Thread(new ServerHander());
            t.setDaemon(true);
            t.start();

            //写入
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {

                OutputStream outputStream = socket.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                PrintWriter printWriter = new PrintWriter(bufferedWriter, true);
                printWriter.println(scanner.next());

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



public class ServerHander implements Runnable {


    @Override
    public void run() {
        while (true) {

            try {
                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String message;
                while ((message = bufferedReader.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

}


    public static void main(String[] args) {
        new Client().start();
    }
}
