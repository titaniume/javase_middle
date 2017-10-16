package cn.titanium.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/***
 * 文件加密
 * @author Administrator
 *2017年10月16日下午1:13:16
 */
public class TestStram {
	
	/**
	 * 
	 * @param decodingFile	
	 * 		   被解密的文件
	 * @param decodedFile
	 * 		解密后保存的位置
	 */
	public static void decodeFile(File decodingFile, File decodedFile){

        try (FileReader fr = new FileReader(decodingFile); FileWriter fw = new FileWriter(decodedFile)) {
            // 读取源文件
            char[] fileContent = new char[(int) decodingFile.length()];
            fr.read(fileContent);
            System.out.println("源文件的内容:");
            System.out.println(new String(fileContent));
            // 进行解密
            decode(fileContent);
            System.out.println("解密后的内容:");
            System.out.println(new String(fileContent));
            // 把解密后的内容保存到目标文件
            fw.write(fileContent);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
	}
	 private static void decode(char[] fileContent) {
	        for (int i = 0; i < fileContent.length; i++) {
	            char c = fileContent[i];
	            if (isLetterOrDigit(c)) {
	                switch (c) {
	                case '0':
	                    c = '9';
	                    break;
	                case 'a':
	                    c = 'z';
	                    break;
	                case 'A':
	                    c = 'Z';
	                    break;
	                default:
	                    c--;
	                    break;
	                }
	            }
	            fileContent[i] = c;
	        }
	    }
	 

	 public static boolean isLetterOrDigit(char c) {
	        // 不使用Character类的isLetterOrDigit方法是因为，中文也会被判断为字母
	        String letterOrDigital ="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	        return -1 == letterOrDigital.indexOf(c) ? false : true;
	    }
	
	public static void main(String[] args) {
		 File decodingFile = new File("d:/Test2.txt");
	        File decodedFile = new File("d:/Test1.txt");
	 
	        decodeFile(decodingFile, decodedFile);
	 
		   
	}
}
