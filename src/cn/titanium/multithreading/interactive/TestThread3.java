package cn.titanium.multithreading.interactive;

/**
 * 练习-线程交互
 * @author Administrator
 *2017年10月20日下午4:34:05
 */
public class TestThread3 {
	public static void main(String[] args) {

		final Hero3 gareen = new Hero3();
		gareen.name = "盖伦";
		gareen.hp = 616;
		Thread t1 = new Thread() {
			public void run() {
				while (true) {
					gareen.hurt();
					// 减慢掉血的速度
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		t1.start();
		Thread t2 = new Thread() {
			public void run() {
				while (true) {
					gareen.recover();

					try {
						// 加快回血的速度
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
        t2.start();
	}
}
