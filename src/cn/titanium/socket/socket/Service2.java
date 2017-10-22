package cn.titanium.socket.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Service2 {
	public static void main(String[] args) {
		
		try {
			ServerSocket s  = new ServerSocket(6666);
			System.out.println("6666端口正在别监听");
			Socket sa = s.accept();
			InputStream is = sa.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			OutputStream os = sa.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);
			while(true){
				String msg = dis.readUTF();
				System.out.println("收到的客户信息:"+msg);
				Scanner sc = new Scanner(System.in);
				String str =sc.next();
				dos.writeUTF(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
