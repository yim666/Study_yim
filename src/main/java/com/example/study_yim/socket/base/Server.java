package com.example.study_yim.socket.base;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server {
    private ServerSocket serverSocket;

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
        while (true){
            try {

                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String message;
                while ((message = bufferedReader.readLine()) != null){
                    System.out.println(ip +"say:"+message);
                }

                OutputStream outputStream = socket.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_8);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                printWriter = new PrintWriter(bufferedWriter,true);

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


    public static void main(String[] args) {
        new Server().start();
    }
}
