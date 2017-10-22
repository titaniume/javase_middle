package cn.titanium.reflex.createobject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;

public class TestReflection {
	
	public static void main(String[] args) {
		 Hero h = getHero();
	     System.out.println(h);
	}

	private static Hero getHero() {
		File file = new File("D:/OpenSources/eclipse/workspace/javase_middle/src/cn/titanium/reflex/createobject/hero.config");
		try(FileReader fr = new FileReader(file)){
			String ClassName = null;
			char [] all =new char[(int)file.length()];
			fr.read(all);
			ClassName = new String(all);
			Class clazz =Class.forName(ClassName);
			Constructor c =clazz.getConstructor();
			Hero h =(Hero)c.newInstance();
			return h;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
