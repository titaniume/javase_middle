package cn.titanium.socket.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		
		
		try {
			//连接本地的8888端口
			Socket s = new Socket("127.0.0.1",8888);
			
			
			//打开输出流
			OutputStream os =  s.getOutputStream();
			//把输出流封装在DataOutputStream中
			DataOutputStream dos = new DataOutputStream(os);
			
			//使用Scanner读取控制台的输入，并发送到服务端
			Scanner sc = new Scanner(System.in);
			System.err.println("请输入你想对我说的话：");
			String str =sc.next();
			
			//使用writeUTF发送字符串
			
			dos.writeUTF(str);
			dos.close();
			s.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
