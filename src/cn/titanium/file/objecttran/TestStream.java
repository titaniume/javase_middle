package cn.titanium.file.objecttran;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestStream {
	public static void main(String[] args) {
	     //创建一个Hero garen
        //要把Hero对象直接保存在文件上，务必让Hero类实现Serializable接口
		Hero hero  = new Hero();
		hero.name ="德玛西亚";
		hero.hp=10000;
		
		//准备一个文件用于保存该对象
		File f = new File("d:/dema.txt");
		try(
				//创建对象输出流
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				//创建对象输入流
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ooi = new ObjectInputStream(fis);
			){
			oos.writeObject(hero);
			Hero h = (Hero)ooi.readObject();
			System.out.println(h.name);
			System.out.println(h.hp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
