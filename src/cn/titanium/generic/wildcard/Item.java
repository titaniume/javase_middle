package cn.titanium.generic.wildcard;

public class Item   {

	String name;
	double price;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Item(String name) {
		
		this.name = name;
	}




	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + "] \r\n";
	}
	

}
