package cn.titanium.log4j;

/**
 * 入门
 * @author Administrator
 *2017年10月23日上午12:15:04
 */
public class GettingStart {
	
	public static void main(String[] args) {
		
		//1 : System.out.println
		/*通常，我们写代码的过程中，免不了要输出各种调试信息。在没有使用任何日志工具之前，都会使用 System.out.println 来做到。 这么做直观有效，但是有一系列的缺点：
		1. 不知道这句话是在哪个类，哪个线程里出来的
		2. 不知道什么时候前后两句输出间隔了多少时间
		3. 无法关闭调试信息，一旦System.out.println多了之后，到处都是输出，增加定位自己需要信息的难度
		等等
		如图所示，光溜溜的出现这么些输出信息出来*/
	    
        System.out.println("跟踪信息");
        System.out.println("调试信息");
        System.out.println("输出信息");
        System.out.println("警告信息");
        System.out.println("错误信息");
        System.out.println("致命信息");
        
        //2 : 导入jar包
        //3 : 使用Log4j
      /*  为了应对这种情况，我们使用Log4j来进行日志输出。 采用如下代码，执行雷同的输出。 可以看到输出结果有几个改观：
        1. 知道是log4j.TestLog4j这个类里的日志
        2. 是在[main]线程里的日志
        3. 日志级别可观察，一共有6个级别 TRACE DEBUG INFO WARN ERROR FATAL
        4. 日志输出级别范围可控制， 如代码所示，只输出高于DEBUG级别的，那么TRACE级别的日志自动不输出
        5. 每句日志消耗的毫秒数(最前面的数字)，可观察，这样就可以进行性能计算*/
        
        // 4 : 代码讲解
       /* 1. 基于类的名称获取日志对象
        
        static Logger logger = Logger.getLogger(TestLog4j.class);
         

        2. 进行默认配置
         
        BasicConfigurator.configure();
         

        3. 设置日志输出级别
         
        logger.setLevel(Level.DEBUG);
         

        3. 进行不同级别的日志输出
         
        logger.trace("跟踪信息");
        logger.debug("调试信息");
        logger.info("输出信息");
        Thread.sleep(1000);
        logger.warn("警告信息");
        logger.error("错误信息");
        logger.fatal("致命信息");
         
        Thread.sleep(1000); 是为了便于观察前后日志输出的时间差*/
	}
}
