package cn.titanium.log4j;

/**
 * 配置讲解
 * @author Administrator
 *2017年10月23日上午9:36:31
 */
public class ConfigurationExplanation {
	
	public static void main(String[] args) {
		
		// 1 : log4j.properties
		//首先在src目录下添加log4j.properties文件，这个配置文件什么含义后面再讲
		
		// 2 : TestLog4j
		/*然后修改TestLog4j，并运行。 有两个效果
		1. 输出在控制台，并且格式有所变化，如图所示，会显示是哪个类的哪一行输出的信息
		2. 不仅仅在控制台有输出，在把日志输出到了D:\OpenSources\eclipse\workspace\javase_middle\example.log 这个位置*/
		
		// 3 : 分析代码
		/*与 Log4j入门 中的BasicConfigurator.configure();方式不同，采用指定配置文件
		 
		PropertyConfigurator.configure("D:\\OpenSources\\eclipse\\workspace\\javase_middle\\src\\log4j.properties");
		 
		Log4j的配置方式按照log4j.properties中的设置进行*/
		
		
		//4 : 解释log4j.properties
		/*设置日志输出的等级为debug,低于debug就不会输出了
		设置日志输出到两种地方，分别叫做 stdout和 R
		 
		log4j.rootLogger=debug, stdout, R
		 
		第一个地方stdout, 输出到控制台
		 
		log4j.appender.stdout=org.apache.log4j.ConsoleAppender
		 
		输出格式是 %5p [%t] (%F:%L) - %m%n, 格式解释在下个步骤讲解
		 
		log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
		log4j.appender.stdout.layout.ConversionPattern=%5p [%t] (%F:%L) - %m%n
		 
		第二个地方R, 以滚动的方式输出到文件，文件名是example.log,文件最大100k, 最多滚动5个文件
		 
		log4j.appender.R=org.apache.log4j.RollingFileAppender
		log4j.appender.R.File=example.log
		log4j.appender.R.MaxFileSize=100KB
		log4j.appender.R.MaxBackupIndex=5
		 
		输出格式是 %p %t %c - %m%n, 格式解释在下个步骤讲解
		 
		log4j.appender.R.layout=org.apache.log4j.PatternLayout
		log4j.appender.R.layout.ConversionPattern=%p %t %c - %m%n*/
		
		//5 : 格式解释
		
		
	}
}
