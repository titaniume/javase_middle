package cn.titanium.file;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * 字符流
 * @author Administrator
 *2017年10月16日上午11:34:48
 */
public class CharacterTranslate {
	public static void main(String[] args) {
		
		/*Reader字符输入流 
		Writer字符输出流 
		专门用于字符的形式读取和写入数据*/
		
		// 1 : 使用字符流读取文件
		/*FileReader 是Reader子类，以FileReader 为例进行文件读取*/
		
		// 准备文件lol.txt其中的内容是XZY
		File f1 = new File("d:/lol.txt");
		
		try(FileReader fr = new FileReader(f1)){
			//准备一个char数组存放字符
			char[] cr = new char[(int)f1.length()];
			fr.read(cr);
			System.out.print("读取到的内容：");
			for (char c : cr) {
				System.out.print(" "+c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// 1 : 使用字符流输出文件
		File f2 = new File("d:/lol2.txt");
		try(FileWriter fw = new FileWriter(f2)){
			//准备写入文件得字符串
			String date ="我爱你，我的女神，请问你还在我的梦里吗！";
			//把字符转换为数组
			char [] cr = date.toCharArray();
			fw.write(cr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//练习-文件加密 
		
		/*准备一个文本文件(非二进制)，其中包含ASCII码的字符和中文字符。
		设计一个方法
		 
		public static void encodeFile(File encodingFile, File encodedFile);
		 

		在这个方法中把encodingFile的内容进行加密，然后保存到encodedFile文件中。
		加密算法： 
		数字：
		如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4
		如果是9的数字，变成0
		字母字符：
		如果是非z字符，向右移动一个，比如d变成e, G变成H
		如果是z，z->a, Z-A。
		字符需要保留大小写
		非字母字符
		比如',&^ 保留不变，中文也保留不变
*/	
		
		//见--->TestStram
		
	}
}
