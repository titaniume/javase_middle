package cn.titanium.socket.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;



/**
 * 服务端
 * @author Administrator
 *2017年10月22日下午12:54:38
 */
public class Server {
	public static void main(String[] args) {
		
		
		try {
			//服务端打开8080端口
			ServerSocket ss = new ServerSocket(8888);
			
			//在8888上监听，看是否有连接请求
			System.out.println("监听在端口8888");
			Socket s = ss.accept();
			
			//打开输入流
			InputStream is = s.getInputStream();
			
			//把输入流封装在DataInputStream
			DataInputStream dis = new DataInputStream(is);
			//使用readUTF读取字符串
			String msg = dis.readUTF();
			//打印
			System.out.println("msg:\t"+msg);
			
			dis.close();
			s.close();
			ss.close();
			System.out.println("有连接过来："+ss);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
