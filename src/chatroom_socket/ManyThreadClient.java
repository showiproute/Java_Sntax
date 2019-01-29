package chatroom_socket;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
 
/**
 *  接收服务端发来的消息
 */
class FromServer implements Runnable{
    Socket client;
    public FromServer(Socket client){
        this.client = client;
    }
    @Override
    public void run() {
        try {
            Scanner in = new Scanner(client.getInputStream());
            while (true) {
                if (in.hasNextLine()) {
                    System.out.println("服务器：" + in.nextLine());
                }
                //判断客户端是否退出，如果推出，跳出循环，并关闭流
                if (client.isClosed()) {
                    System.out.println("客户端关闭。。。");
                    break;
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 
/**
 *  向服务端发出消息
 */
class ToServer  implements Runnable{
    Socket client;
    public ToServer(Socket client){
        this.client = client;
    }
    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(System.in);
            PrintStream out = new PrintStream(client.getOutputStream(),true,"UTF-8");
            while (true) {
                System.out.println("请输入信息：");
                String strToserver;
                if(scanner.hasNextLine()){
                    strToserver = scanner.nextLine().trim();
                    out.println(strToserver);
                    //客户端退出标志：B
                    if(strToserver.startsWith("B")){
                        System.out.println("客户端退出。。。");
                        scanner.close();
                        out.close();
                        client.close();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class ManyThreadClient {
    public static void main(String[] args){
        try {
            //实例化Socket对象，与服务器建立连接
            Socket client = new Socket("127.0.0.1",6666);
            //为了发送消息和接收消息可以同时进行，使用多线程进行处理
            Thread thread1 = new Thread(new FromServer(client));
            Thread thread2 = new Thread(new ToServer(client));
            thread1.start();
            thread2.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
