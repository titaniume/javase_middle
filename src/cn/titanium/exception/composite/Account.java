package cn.titanium.exception.composite;

public class Account {
	
	protected double balance;  //余额
	
	public Account(double balance){
		this.balance = balance;
	}
	
	
	//获取余额
	public double getBalance(){
		return balance;
	}
	
	
	//存钱
	public void deposit(double atm){
		this.balance += atm;
	}
	
	//取钱
	public double withdraw(double atm) throws OverDraftException{
		if(balance < atm){
			throw new OverDraftException("余额不足", atm-this.balance);
		}
		
		return this.balance -= atm;
	}
	
	public static void main(String[] args) {
		 //开户存了1000
        Account a = new Account(1000);
        //存钱1000
        a.deposit(1000);
      //查看余额
        System.out.println(a.getBalance());
        try {
			a.withdraw(2001);
		} catch (OverDraftException e) {
			  System.err.println("透支金额："+e.getDeficit());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
