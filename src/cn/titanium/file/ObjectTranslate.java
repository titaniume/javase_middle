package cn.titanium.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cn.titanium.file.objecttran.Hero;

/**
 * 对象流
 * @author Administrator
 *2017年10月16日下午10:28:33
 */
public class ObjectTranslate {
	
	public static void main(String[] args){
		/*对象流指的是可以直接把一个对象以流的形式传输给其他的介质，比如硬盘 
		一个对象以流的形式进行传输，叫做序列化。 该对象所对应的类，必须是实现Serializable接口*/
		
		
		//1 : 序列化一个对象
		/*创建一个Hero对象，设置其名称为garen。 
		把该对象序列化到一个文件garen.lol。
		然后再通过序列化把该文件转换为一个Hero对象*/
		
		
		//2 : 练习-序列化数组
		/*准备一个长度是10，类型是Hero的数组，使用10个Hero对象初始化该数组

		然后把该数组序列化到一个文件heros.lol

		接着使用ObjectInputStream 读取该文件，并转换为Hero数组，验证该数组中的内容，是否和序列化之前一样*/
		
		Hero [] ho = new Hero[10];
		for (int i = 0; i < ho.length; i++) {
			ho[i] = new Hero("hero"+i);
		}
		 File f =new File("d:/heros.lol");
		 try(
				 FileOutputStream fos = new FileOutputStream(f);
				 ObjectOutputStream oos = new ObjectOutputStream(fos);
				 FileInputStream fis = new FileInputStream(f);
				 ObjectInputStream ooi = new ObjectInputStream(fis)
		     ){
			  //把数组序列化到文件heros.lol
			 oos.writeObject(ho);
			 Hero []  h =(Hero[]) ooi.readObject();
			   System.out.println("查看中文件中反序列化出来的数组中的每一个元素：");		 
			for (Hero hero : h) {
				System.out.println(hero.name);
			}
			 
		 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
