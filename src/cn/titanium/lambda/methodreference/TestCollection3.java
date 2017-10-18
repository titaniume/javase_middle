package cn.titanium.lambda.methodreference;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

//-引用构造器
public class TestCollection3 {
	public static void main(String[] args) {
		insertFirst(ArrayList::new, "ArrayList");
		insertFirst(LinkedList::new , "LinkedList");
	}
	
	 private static void insertFirst(Supplier<List> s, String type) {
	        int total = 1000 * 100;
	        final int number = 5;
	        long start = System.currentTimeMillis();
	        List list = s.get();
	        for (int i = 0; i < total; i++) {
	            list.add(0, number);
	        }
	        long end = System.currentTimeMillis();
	        System.out.printf("在%s 最前面插入%d条数据，总共耗时 %d 毫秒 %n", type, total, end - start);
	    }
}
