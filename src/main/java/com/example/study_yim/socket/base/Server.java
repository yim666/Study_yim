package com.example.study_yim.socket.base;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Server {
    private ServerSocket serverSocket;

    //广播消息
    private ArrayList<PrintWriter> allOut = new ArrayList<>();
    public Server(){
        try {
            System.out.println("服务器启动ing。。。。");
            serverSocket =new ServerSocket(8099);
            System.out.println("服务器启动 success !!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        while (true){
            try {
                System.out.println("等待客户端连接......");
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端 已连接 success......");

                //启动一个线程来连接这个客户端
                new Thread(new ClientThread(socket)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

public class ClientThread implements Runnable{
    private Socket socket;
    private String ip;
    public ClientThread(Socket socket) {
        this.socket =socket;
        this.ip =socket.getInetAddress().getHostAddress();
    }

    @Override
    public void run() {
            PrintWriter printWriter =null;
            try {

                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                OutputStream outputStream = socket.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                printWriter = new PrintWriter(bufferedWriter,true);

               synchronized (allOut) {
                    allOut.add(printWriter);
                }

                String message;
                while ((message = bufferedReader.readLine()) != null){
                    System.out.println(ip +"say:"+message);
                    for (PrintWriter p:allOut){
                        p.println(ip +"say:"+message);
                    }
                }


            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    synchronized (allOut) {
                        allOut.remove(printWriter);
                    }
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}


    public static void main(String[] args) {
        new Server().start();
    }
}
