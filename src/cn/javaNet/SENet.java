package cn.javaNet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SENet {
    public static void main(String[] args) throws Exception
    {
        Server server = new Server();
        Client client = new Client();
        Thread threadServer = new Thread(){
            public void run()
            {
                try {
                    server.startWork();
                }
                catch (Exception e)
                {e.printStackTrace();}
            }
        };
        Thread clientServer = new Thread(){
            public void run()
            {
                try {
                    client.startComm();
                }
                catch (Exception e)
                {e.printStackTrace();}
            }
        };
        threadServer.start();
        clientServer.start();
    }
}
class Server
{
    ServerSocket serverSocket;
    Socket socket;
    Server() throws Exception
    {
        serverSocket = new ServerSocket(7001);
    }

    /**
     * 服务器开始工作
     * @throws IOException
     */
    public void startWork() throws IOException
    {
        //接收socket
        socket = serverSocket.accept();
        DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(socket.getInputStream())
        );
        DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(socket.getOutputStream())
        );
        do {
            double length = dataInputStream.readDouble();

            System.out.println("服务器收到："+length);

            double square = Math.pow(length,2);

            dataOutputStream.writeDouble(square);

            dataOutputStream.flush();
        }
          while(true||dataInputStream.readDouble()!=0);
//        socket.close();
//        serverSocket.close();
//        System.out.println("服务器已断开");
    }
}
class Client
{
    Socket socket;
    Client() throws Exception
    {
        //端口号
        int port = 7001;
        //主机
        String host = "localhost";
        //套接字
        socket = new Socket(host,port);
    }

    /**
     * 开始通信
     */
    public void startComm() throws IOException
    {
        //输入字节流
        DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(socket.getInputStream())
        );
        //输出字节流
        DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(socket.getOutputStream())
        );

        Scanner scanner = new Scanner(System.in);

        boolean flag = false;

        while(!flag)
        {
            System.out.println("请输入正方形的边长");
            //获取边长
            double length = scanner.nextDouble();
            //写入缓冲
            dataOutputStream.writeDouble(length);
            //发出
            dataOutputStream.flush();

            System.out.println("已发出");
            //输出服务器计算的数值
            System.out.println(dataInputStream.readDouble());
        }
    }

}