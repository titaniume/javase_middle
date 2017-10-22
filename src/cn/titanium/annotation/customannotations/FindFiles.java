package cn.titanium.annotation.customannotations;



public class FindFiles {
	
	@FileType(".java")
	@FileType(".html")
	@FileType(".css")
	@FileType(".js")
	public void work(){
		try {
			FileType [] fileTypes = this.getClass().getMethod("work").getAnnotationsByType(FileType.class);
			 System.out.println("将从如下后缀名的文件中查找文件内容");
			 for (FileType fileType : fileTypes) {
				System.out.println(fileType.value());
			}
			 
			 System.out.println("查找过程省略");
			 
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	  public static void main(String[] args) {
	        new FindFiles().work();
	    }
 
}
