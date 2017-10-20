package cn.titanium.multithreading.threadpool;

import java.io.File;

public class TestThreadPoolSearchFile {
	 static ThreadPoolSearchFile pool= new ThreadPoolSearchFile();
	    public static void search(File file, String search) {
	         
	        if (file.isFile()) {
	            if(file.getName().toLowerCase().endsWith(".java")){
	                SearchFileTask task = new SearchFileTask(file, search);
	                pool.add(task);
	            }
	        }
	        if (file.isDirectory()) {
	            File[] fs = file.listFiles();
	            for (File f : fs) {
	                search(f, search);
	            }
	        }
	    }
	       
	    public static void main(String[] args) {
	        File folder =new File("d:\\project");
	        search(folder,"Magic");
	    }
}
