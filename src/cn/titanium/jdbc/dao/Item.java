package cn.titanium.jdbc.dao;
public class Item implements LOL ,Comparable<Item>{
    public int id;
    public String name;
    public int price;
      
    public Item(){
          
    }
      
    public Item(String name){
        this.name = name;
    }
      
    public void effect(){
        System.out.println("物品使用后，可以有效果");
    }
 
    public boolean disposable() {
        return false;
    }
 
    @Override
    public int compareTo(Item o) {
        return o.price-price;
    }
 
    @Override
    public String toString() {
        return "Item [name=" + name + ", price=" + price + "]\r\n";
    }
     
}