package cn.titanium.multithreading.commmethod;
public class Hero{
    public String name; 
    public float hp;
      
    public int damage;
      
    public void attackHero(Hero h) {
        //把暂停时间去掉，多条线程各自会尽力去占有CPU资源
        //线程的优先级效果才可以看得出来
//        try {
//            
//            Thread.sleep(0);
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);
          
        if(h.isDead())
            System.out.println(h.name +"死了！");
    }
  
    public boolean isDead() {
        return 0>=hp?true:false;
    }
    
    int totalTime = 3;
    public void adugen(){
    	while(true){
    		for (int i = 0; i < totalTime; i++) {
    			 System.out.printf("波动拳第%d发%n", i + 1);
    			 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
			}
    		System.out.println("开始为时5秒的充能");
		   try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    public static void main(String[] args) {
		Hero h = new Hero();
		h.name ="大仙";
		
		h.adugen();
	}
  
}