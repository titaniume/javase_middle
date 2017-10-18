package cn.titanium.lambda;

/**
 * 方法引用
 * @author Administrator
 *2017年10月18日下午5:37:24
 */
public class MethodReference {
	public static void main(String[] args) {
		
		
		//1 : 引用静态方法
	/*	首先为TestLambda添加一个静态方法：
		 
		public static boolean testHero(Hero h) {
		   return h.hp>100 && h.damage<50;
		}
		 
		Lambda表达式：
		 
		filter(heros, h->h.hp>100 && h.damage<50);
		 
		在Lambda表达式中调用这个静态方法：
		 
		filter(heros, h -> TestLambda.testHero(h) );
		 
		调用静态方法还可以改写为：
		 
		filter(heros, TestLambda::testHero);
		 
		这种方式就叫做引用静态方法*/
		
		
		// 2 : 引用对象方法
		/*与引用静态方法很类似，只是传递方法的时候，需要一个对象的存在		 
		TestLambda testLambda = new TestLambda();
		filter(heros, testLambda::testHero);
		 
		这种方式叫做引用对象方法
		*/
		
		// 3 : 引用容器中的对象的方法
		/*首先为Hero添加一个方法
		 
		public boolean matched(){
		   return this.hp>100 && this.damage<50;
		}
		 

		使用Lambda表达式
		 
		filter(heros,h-> h.hp>100 && h.damage<50 );
		 

		在Lambda表达式中调用容器中的对象Hero的方法matched
		 
		filter(heros,h-> h.matched() );
		 

		matched恰好就是容器中的对象Hero的方法，那就可以进一步改写为
		 
		filter(heros, Hero::matched);
		 

		这种方式就叫做引用容器中的对象的方法*/
		
		
		
		// 4 : 引用构造器
	/*	有的接口中的方法会返回一个对象，比如java.util.function.Supplier提供
		了一个get方法，返回一个对象。
		 
		public interface Supplier<T> {
		    T get();
		}
		
		设计一个方法，参数是这个接口
		 
		public static List getList(Supplier<List> s){
		  return s.get();
		}
		 

		为了调用这个方法，有3种方式
		第一种匿名类：
		 
		Supplier<List> s = new Supplier<List>() {
			public List get() {
				return new ArrayList();
			}
		};
		List list1 = getList(s);
		 
		第二种：Lambda表达式
		 
		List list2 = getList(()->new ArrayList());
		 
		第三种：引用构造器
		 
		List list3 = getList(ArrayList::new);*/
		
		//5 : 练习-引用静态方法
		
		//7 : 练习-引用容器中的对象的方法
	/*	把比较器-Comparator 章节中的代码，使用 引用容器中的对象的方法 的方式来实现。
		提示: 为Hero提供一个compareHero方法*/
		
		
		//8 :练习-引用构造器
		/*把比较ArrayList和LinkedList的区别这段代码，改造成引用构造器的模式。
		目前的调用方式是:
		 
		        List<Integer> l;
		        l = new ArrayList<>();
		        insertFirst(l, "ArrayList");
		 
		        l = new LinkedList<>();
		        insertFirst(l, "LinkedList");
		 


		改造后的调用方式将变为：
		 
		        insertFirst(ArrayList::new, "ArrayList");
		        insertFirst(LinkedList::new, "LinkedList");*/
	}
}
