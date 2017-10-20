package cn.titanium.jdbc;

public class Mysql {
	public static void main(String[] args) {
		
		
		//MySQL
		/*Mysql是常见的数据库,在中小型网站经常被使用。*/
		//创建数据库
		//create database titanium;
		
		// 创建表hero
		/*CREATE TABLE hero (
		  id int(11) AUTO_INCREMENT,
		  name varchar(30) ,
		  hp float ,
		  damage int(11) ,
		  PRIMARY KEY (id)
		)  DEFAULT CHARSET=utf8;*/
		
		//插入数据
		//insert into hero values (null, '盖伦', 616, 100)
		
		//查询所有数据
		//select * from hero
		
		//统计表中有多多少条数据
		//select count(*) from hero
		
		//分页 前5条
		//select * from hero limit 0,5
		
		
		//修改数据
		//update hero set hp = 818 where id = 1
		
		//删除数据
		//delete from hero where id = 1
		
		//备份 ----->使用Mysql自带命令行 备份
		/*假定mysql安装在D:/software/MySQL Server 5.1/
		那么其bin目录下有一个mysqldump.exe文件
		账号是root
		密码是admin
		备份的数据库名是 test
		备份后的文件是 d:\test.sql*/
		
		//还原----->使用mysql自带命令
		/*假定mysql安装在D:/software/MySQL Server 5.1/
		那么其bin目录下有一个mysql.exe文件
		账号是root
		密码是admin
		还原的数据库名是 test
		还原的文件是 d:\test.sql*/
		
		//1: 开启InnoDB  5.1、5.5上使用，5.7默认是InnoDB的，所以无需额外开启	
		//2: 检查是否innodb已开启   --->SHOW variables like 'have_%';
		
	}
}
