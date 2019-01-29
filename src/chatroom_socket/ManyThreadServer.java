package chatroom_socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ManyThreadServer {
    //存储所有注册的客户端
    private static Map<String, Socket> clientMap = new ConcurrentHashMap<String,Socket>();
    //具体的处理每个客户端的请求
    private static class ExcuteClient implements Runnable{
        private Socket client;
        public ExcuteClient(Socket client) {
            this.client = client;
        }
        @Override
        public void run() {
            try {
                //获取客户端的输出流，读取客户端消息，并处理
                Scanner in = new Scanner(client.getInputStream());
                String strFromClient;
                while(true){
                    if(in.hasNextLine()){
                        strFromClient = in.nextLine();
                        //在Windows下默认换行是：\r\n,所以把\r要转换为空字符串
                        Pattern pattern = Pattern.compile("\r");
                        Matcher matcher = pattern.matcher(strFromClient);
                        strFromClient = matcher.replaceAll("");
                        //注册流程
                        if(strFromClient.startsWith("useName")){
                            String useName = strFromClient.split("\\:")[1];
                            registerUser(useName,client);
                            continue;
                        }
                        //群聊功能
                        if(strFromClient.startsWith("G")){
                            String msg = strFromClient.split("\\:")[1];
                            groupChat(msg,client);
                            continue;
                        }
                        //私聊功能
                        if(strFromClient.startsWith("P")){
                            String userName = strFromClient.split("\\:")[1].split("-")[0];
                            String msg = strFromClient.split("\\:")[1].split("-")[1];
                            privateChat(userName,msg,client);
                            continue;
                        }
                        //用户退出
                        if(strFromClient.startsWith("B")){
                            String userName = null;
                            //根据Socket找到UserName
                            for(String keyName : clientMap.keySet()){
                                if(clientMap.get(keyName).equals(client)){
                                    userName = keyName;
                                }
                            }
                            System.out.println("用户" + userName + "下线了。。。");
                            clientMap.remove(userName);
                            System.out.println("当前共有用户" + clientMap.size() + "人");
                            continue;
                        }
                        else{
                            PrintStream out = new PrintStream(client.getOutputStream(),true,"UTF-8");
                            out.println("输入错误。。。");
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void registerUser(String name,Socket client){
            System.out.println("用户：" + name + "已上线！");
            clientMap.put(name,client);
            System.out.println("当前在线人数：" + clientMap.size() + "人！");
            //既然是用户在注册，所以这里服务器通知用户注册结果
            try {
                PrintStream out = new PrintStream(client.getOutputStream(),true,"UTF-8");
                out.println("用户注册成功！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void groupChat(String msg,Socket client){
            //取出clientMap中所有的Entry对象，遍历每个用户，并且发送消息
            Set<Map.Entry<String,Socket>> clientSet = clientMap.entrySet();
            for(Map.Entry<String,Socket> entry:clientSet){
                try {
                    Socket socket = entry.getValue();
                    //取得输出流，向客户端发送消息
                    PrintStream out = new PrintStream(socket.getOutputStream(),true,"UTF-8");
                    out.println("由端口号为"+ client.getPort() + "发来的群聊消息：" + msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        private void privateChat(String userName,String msg,Socket client){
            Socket privateSocket = clientMap.get(userName);
            try {
                PrintStream out = new PrintStream(privateSocket.getOutputStream(),true,"UTF-8");
                out.println("由端口号为：" + client.getPort() + "发来的消息：" + msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args)throws Exception{
        //为了提高效率，这里使用多线程进行处理
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        //实例化ServerSocket对象，并指定IP为本地主机，端口号为6666
        ServerSocket serverSocket = new ServerSocket(6666);
        for(int i = 0; i < 30;i++){
            System.out.println("等待用户连接。。。");
            //等待客户端连接服务器
            Socket client = serverSocket.accept();
            System.out.println("有客户端连接，端口号为：" + client.getPort());
            //启动线程，并处理客户端请求
            executorService.submit(new ExcuteClient(client));
        }
        //关闭线程，关闭服务器
        executorService.shutdown();
        serverSocket.close();
    }
}
