package cn.titanium.swing.helloswing;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;

/**
 * 保存的位置信息
 * @author Administrator
 *2017年10月22日上午1:33:26
 */
public class SavingPostionThread extends Thread {
	
	 private JFrame f;
		File file = new File("D:/project/location.txt");
	 
	    SavingPostionThread(JFrame f) {
	        this.f = f;
	    }
	 
	    public void run() {
	        while (true) {
	            int x = f.getX();
	            int y = f.getY();
	 
	            try (FileOutputStream fos = new FileOutputStream(file);
	                    DataOutputStream dos = new DataOutputStream(fos);) {
	                dos.writeInt(x);
	                dos.writeInt(y);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	 
	            try {
	                Thread.sleep(100);
	            } catch (InterruptedException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	 
	        }
	    }
	
}
