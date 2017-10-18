package cn.titanium.multithreading.startthread;



public class TestThread {
	public static void main(String[] args) {
		Hero gareen = new Hero();
        gareen.name = "盖伦";
        gareen.hp = 616;
        gareen.damage = 50;
 
        Hero teemo = new Hero();
        teemo.name = "提莫";
        teemo.hp = 300;
        teemo.damage = 30;
         
        Hero bh = new Hero();
        bh.name = "赏金猎人";
        bh.hp = 500;
        bh.damage = 65;
         
        Hero leesin = new Hero();
        leesin.name = "盲僧";
        leesin.hp = 455;
        leesin.damage = 80;
        
       /* //盖伦攻击提莫
        while(!teemo.isDead()){
        	gareen.attackHero(teemo);
        }
        //赏金猎人攻击盲僧
        while(!bh.isDead()){
        	bh.attackHero(leesin);
        }*/
        
        //继承Thread类
      /*  KillThread kd1 = new KillThread(gareen, teemo);
        kd1.start();
        KillThread kd2 = new KillThread(bh, leesin);
        kd2.start();*/
        
        //实现runable 接口
        /*Battle bt1 = new Battle(gareen, teemo);
        new Thread(bt1).start();
        Battle bt2 = new Battle(bh, leesin);
        new Thread(bt2).start();*/
        
        //匿名类
        Thread td1 = new Thread(){       	
        	public void run(){
        		 //匿名类中用到外部的局部变量teemo，必须把teemo声明为final
                //但是在JDK7以后，就不是必须加final的了
        		while (!teemo.isDead()) {
					gareen.attackHero(teemo);	
					
				}
        	}
        };
        td1.start();
        
        Thread td2 = new Thread(){
        	public void run(){
        		while(!leesin.isDead()){
        			bh.attackHero(leesin);
        		}
        	}
        };
        
        td2.start();
        
        
        
	}
}
