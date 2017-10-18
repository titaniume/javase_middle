package cn.titanium.generic.standbyclass;

import java.util.LinkedList;

public class ItemStack {
   
    LinkedList<Item> Items = new LinkedList<Item>();
       
    public void push(Item h) {
        Items.addLast(h);
    }
   
    public Item pull() {
        return Items.removeLast();
    }
   
    public Item peek() {
        return Items.getLast();
    }
       
    public static void main(String[] args) {
           
        ItemStack ItemStack = new ItemStack();
        for (int i = 0; i < 5; i++) {
            Item item = new Item("Item name " + i);
            System.out.println("压入 Item:" + item);
            ItemStack.push(item);
        }
        for (int i = 0; i < 5; i++) {
            Item item =ItemStack.pull();
            System.out.println("弹出 Item" + item);
        }
    }
}
   