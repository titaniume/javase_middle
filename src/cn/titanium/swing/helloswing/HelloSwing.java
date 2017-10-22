package cn.titanium.swing.helloswing;

import javax.swing.JButton;
import javax.swing.JFrame;

public class HelloSwing {
	public static void main(String[] args) {
		
		//主窗体
		JFrame f = new JFrame("titanium");
		
		//窗体设置大小
		f.setSize(400,300);
		
		//主窗体位置设置
		f.setLocation(200, 200);
		
		//主窗体的组件设置为绝对定位
		f.setLayout(null);
		
		//按钮组件
		JButton jb = new JButton("my Buttom");
		
		//同时设置组件的大小和位置
		jb.setBounds(50,50,280,30);
		
		//把按钮放入主窗体中
		f.add(jb);
		
		//关闭窗体的时候，退出程序
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//让窗体变得可见
		f.setVisible(true);
		
		
		
	}
}
