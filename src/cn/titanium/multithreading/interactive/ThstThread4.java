package cn.titanium.multithreading.interactive;

/**
 * 多线程练习
 * @author Administrator
 *2017年10月20日下午4:43:59
 */
public class ThstThread4 {
	
	
	static class HurtThread extends Thread{
		private Hero4 hero;
		public HurtThread(Hero4 hero){
			this.hero= hero;
		}
		
		public void run(){
			while (true) {
				hero.hurt();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	
	static class RecoverThread extends Thread{
		private Hero4 hero;
		public RecoverThread(Hero4 hero){
			this.hero= hero;
		}
		
		public void run(){
			while (true) {
				hero.recover();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		final Hero4 gareen = new Hero4();
        gareen.name = "盖伦";
        gareen.hp = 616;
        
        for (int i = 0; i < 2; i++) {
			new RecoverThread(gareen).start();
		}
        for (int i = 0; i < 5; i++) {
			new HurtThread(gareen).start();
		}
	}
}
