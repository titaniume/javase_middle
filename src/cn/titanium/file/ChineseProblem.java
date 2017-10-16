package cn.titanium.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * 中文问题
 * @author Administrator
 *2017年10月16日下午1:42:35
 */
public class ChineseProblem {
	public static void main(String[] args) {
		
		// 1 : 编码概念
		/*计算机存放数据只能存放数字，所有的字符都会被转换为不同的数字。
		就像一个棋盘一样，不同的字，处于不同的位置，而不同的位置，有不同的数字编号。
		有的棋盘很小，只能放数字和英文
		有的大一点，还能放中文
		有的“足够”大，能够放下世界人民所使用的所有文字和符号*/
		
		//2 : 常见编码
		/*工作后经常接触的编码方式有如下几种：
		ISO-8859-1 ASCII 数字和西欧字母
		GBK GB2312 BIG5 中文
		UNICODE (统一码，万国码)

		其中
		ISO-8859-1 包含 ASCII
		GB2312 是简体中文，BIG5是繁体中文，GBK同时包含简体和繁体以及日文。
		UNICODE 包括了所有的文字，无论中文，英文，藏文，法文，世界所有的文字都包含其中*/
		
		// 3 : UNICODE和UTF
		/*根据前面的学习，我们了解到不同的编码方式对应不同的棋盘，而UNICODE因为要存放所有的数据，那么它的棋盘是最大的。 
		不仅如此，棋盘里每个数字都是很长的(4个字节)，因为不仅要表示字母，还要表示汉字等。

		如果完全按照UNICODE的方式来存储数据，就会有很大的浪费。
		比如在ISO-8859-1中，a 字符对应的数字是0x61
		而UNICODE中对应的数字是 0x00000061，倘若一篇文章大部分都是英文字母，那么按照UNICODE的方式进行数据保存就会消耗很多空间

		在这种情况下，就出现了UNICODE的各种减肥子编码, 比如UTF-8对数字和字母就使用一个字节，而对汉字就使用3个字节，从而达到了减肥还能保证健康的效果

		UTF-8，UTF-16和UTF-32 针对不同类型的数据有不同的减肥效果，一般说来UTF-8是比较常用的方式*/
		
		//4 : Java采用的是Unicode
		/*写在.java源代码中的汉字，在执行之后，都会变成JVM中的字符。
		而这些中文字符采用的编码方式，都是使用UNICODE. "中"字对
		应的UNICODE是4E2D,所以在内存中，实际保存的数据就是十六进制的0x4E2D, 也就是十进制的20013。*/
		
		//5 : 一个汉字使用不同编码方式的表现
		/*以字符 中 为例，查看其在不同编码方式下的值是多少*/

		String str = "中";
		showCode(str);
		
		
		
		// 6 : 文件的编码方式-记事本	
		/*接下来讲，字符在文件中的保存
		字符保存在文件中肯定也是以数字形式保存的，即对应在不同的棋盘上的不同的数字
		用记事本打开任意文本文件，并且另存为，就能够在编码这里看到一个下拉。
		ANSI 这个不是ASCII的意思，而是采用本地编码的意思。如果你是中文的操作系统，就会使GBK，如果是英文的就会是ISO-8859-1
		Unicode UNICODE原生的编码方式
		Unicode big endian 另一个 UNICODE编码方式
		UTF-8 最常见的UTF-8编码方式，数字和字母用一个字节， 汉字用3个字节。*/
		
		//文件的编码方式-eclipse
		/*eclipse也有类似的编码方式，右键任意文本文件，点击最下面的"property"
		就可以看到Text file encoding
		也有ISO-8859-1，GBK,UTF-8等等选项。
		其他的US-ASCII,UTF-16，UTF-16BE,UTF-16LE不常用。*/
		
		
		// 8 : 用FileInputStream 字节流正确读取中文
		/*用FileInputStream 字节流正确读取中文	
		为了能够正确的读取中文内容
		1. 必须了解文本是以哪种编码方式保存字符的
		2. 使用字节流读取了文本后，再使用对应的编码方式去识别这些数字，得到正确的字符
		如本例，一个文件中的内容是字符中，编码方式是GBK，那么读出来的数据一定是D6D0。
		再使用GBK编码方式识别D6D0，就能正确的得到字符中*/
		File f = new File("D:/test.txt");
		try(FileInputStream fis = new FileInputStream(f)){
			byte [] bt = new byte[(int)f.length()];
			fis.read(bt);

            //文件中读出来的数据是
            System.out.println("文件中读出来的数据是：");
            for (byte b : bt) 
            {
                int i = b&0x000000ff;  //只取16进制的后两位
                System.out.println(Integer.toHexString(i));
            }
			 System.out.println("把这个数字，放在GBK的棋盘上去：");
			 String str1 = new String(bt,"GBK");
			 System.out.println(str1);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		// 9 : 用FileReader 字符流正确读取中文
		/*FileReader得到的是字符，所以一定是已经把字节根据某种编码识别成了字符了
		而FileReader使用的编码方式是Charset.defaultCharset()的返回值，如果是中文的操作系统，就是GBK
		FileReader是不能手动设置编码方式的，为了使用其他的编码方式，只能使用InputStreamReader来代替，像这样：*/
		File f1 = new File("d:/test.txt");
	    System.out.println("默认编码方式:"+Charset.defaultCharset());
        //FileReader得到的是字符，所以一定是已经把字节根据某种编码识别成了字符了
        //而FileReader使用的编码方式是Charset.defaultCharset()的返回值，如果是中文的操作系统，就是GBK,这里是UTF-8 会乱码
	    
		try(FileReader fr = new FileReader(f)){
			char [] ct = new char[(int)f.length()];
			fr.read(ct);
		    System.out.printf("FileReader会使用默认的编码方式%s,识别出来的字符是：%n",Charset.defaultCharset());
			System.out.println(new String(ct));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //FileReader是不能手动设置编码方式的，为了使用其他的编码方式，只能使用InputStreamReader来代替
        //并且使用new InputStreamReader(new FileInputStream(f),Charset.forName("UTF-8")); 这样的形式
		try(InputStreamReader ist = new InputStreamReader(new FileInputStream(f),Charset.forName("GBK"))){
			char [] ct = new char[(int)f.length()];
			ist.read(ct);
			System.out.printf("InputStreamReader 指定编码方式GBK,识别出来的字符是：%n");
	        System.out.println(new String(ct));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//练习-数字对应的中文
		/*找出 E5 B1 8C 这3个十六进制对应UTF-8编码的汉字*/
		byte [] bt1 = new byte[3];
		bt1[0] = (byte) 0xE5;
		bt1[1] = (byte) 0xB2;
		bt1[2] = (byte) 0x8C;
		
		
		try {
			String str2 =new String(bt1,"UTF-8");
			System.out.println(" E5 B1 8C 对应的字符是：" +str2);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//练习-移除BOM 
		/*如果用记事本根据UTF-8编码保存汉字就会在最前面生成一段标示符，这个标示符用于表示该文件是使用UTF-8编码的。

		找出这段标示符对应的十六进制，并且开发一个方法，自动去除这段标示符*/
		//带完结
		
	}
	
	private static void showCode(String str){
		String [] encodes = {"BIG5","GBK","GB2312","UTf-8","UTF-16","UTF-32"};
		for (String encode : encodes) {
			showCode(str,encode);
		}
	}

	private static void showCode(String str, String encode) {
	        try {
	            System.out.printf("字符: \"%s\" 的在编码方式%s下的十六进制值是%n", str, encode);
	            byte[] bs = str.getBytes(encode);
	 
	            for (byte b : bs) {
	                int i = b&0xff;
	                System.out.print(Integer.toHexString(i) + "\t");
	            }
	            System.out.println();
	            System.out.println();
	        } catch (UnsupportedEncodingException e) {
	            System.out.printf("UnsupportedEncodingException: %s编码方式无法解析字符%s\n", encode, str);
	        }
	    }
	
	
	
}
