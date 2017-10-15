package cn.titanium.exception.excep02;

public class TestException2 {

		@SuppressWarnings("finally")
		public 	static int mehtod(){
			
			try {
				return return1();
			} catch (Exception e) {
				return return2();
			}finally{
				return return3();
			}
		}
		
		private static int return3() {
			System.out.println("return 3");
			return 3;
		}

		private static int return2() {
			System.out.println("return 2");
			return 2;
		}

		public static int return1(){
			System.out.println("return 1");
			return 1;
		}
		
		public static void main(String[] args) {
			int result = mehtod();
			System.out.printf("result: %s:",result);
		}
}
