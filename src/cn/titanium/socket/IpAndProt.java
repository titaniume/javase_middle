package cn.titanium.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

/**
 * IP地址和端口
 * @author Administrator
 *2017年10月22日上午11:14:19
 */
public class IpAndProt {
	public static void main(String[] args) throws IOException {
		
		// 1 : IP地址
		/*在网络中每台计算机都必须有一个的IP地址； 
		32位，4个字节，常用点分十进制的格式表示，例如：192.168.1.100 
		127.0.0.1 是固定ip地址，代表当前计算机，相当于面向对象里的 "this"*/
		
		//2 : 端口
		//查看端口netstat -a
		/*两台计算机进行连接，总有一台服务器，一台客户端。
		服务器和客户端之间的通信通过端口进行。如图：

		ip地址是 192.168.1.100的服务器通过端口 8080
		与ip地址是192.168.1.189的客户端 的1087端口通信*/
		// 3 : 获取本机IP地址
		InetAddress host = InetAddress.getLocalHost();
		String ip = host.getHostAddress();
		System.out.println("本地Ip地址："+ip);
		
		//4 : ping命令
		/*使用ping判断一个地址是否能够到达
		ping不是java的api，是windows中的一个小工具，用于判断一个地址的相应时间*/
		
		//5 : 使用java 执行ping命令
		/*借助 Runtime.getRuntime().exec() 可以运行一个windows的exe程序
		使用java运行 ping 192.168.6.107，返回这样的字符串*/
		
		Process p = Runtime.getRuntime().exec("ping " + "192.168.6.107");
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream(),"GBK"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line=br.readLine())!= null){
			if(line.length() !=0){
				sb.append(line+"\r\n");
			}
		}
		System.out.println("本次指令返回的消息是:");
		System.out.println(sb.toString());
		
		// 6 : 练习-判断本网段有多少可用的ip地址
		/*首先获取 获取本机IP地址，比如说是192.168.2.100。 那么本网段的ip地址就是从 192.168.2.1 到 192.168.2.255
		再通过使用java 执行ping命令 判断这些ip地址能否使用，把能够使用的ip打印出来*/
		
		
	}
}
