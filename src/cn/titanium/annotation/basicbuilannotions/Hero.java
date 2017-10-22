package cn.titanium.annotation.basicbuilannotions;

public class Hero {
	String name;
	
	//注意Hero 是默认继承Object的，所以可以重写toString()方法
	
	@Override
	public String toString(){
		return name;
	}
	
	   
    @Deprecated
    public void hackMap(){
         
    }
	
	
	//在fromString()方法上加上@Override 注解，就会失败，因为Hero类的父类Object，并没有fromString方法
	
	/*@Override
	public String fromString(){
		return name;
	}*/
    
   
}	
