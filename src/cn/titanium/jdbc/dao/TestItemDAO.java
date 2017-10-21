package cn.titanium.jdbc.dao;

import java.util.List;

public class TestItemDAO {
    public static void main(String[] args) {
        ItemDAO dao= new ItemDAO();
        List<Item> is =dao.list();
        System.out.println("数据库中总共有" + is.size() + " 条数据");
        Item i = new Item("新的物品");
        System.out.println("新加一条数据");
        dao.add(i);
        is =dao.list();
        System.out.println("数据库中总共有" + is.size() + " 条数据");
        System.out.println("取出id=4的数据，它的name是:");
        i = dao.get(4);
        System.out.println(i.name);
        System.out.println("把名字改为 物品X，并且更新到数据库");
        i.name="物品X";
        dao.update(i);
        System.out.println("取出id=4的数据，它的name是:");
        i = dao.get(4);
        System.out.println(i.name);
        System.out.println("删除id=4的数据");
        dao.delete(i.id);
        is =dao.list();
        System.out.println("数据库中总共有" + is.size() + " 条数据");
          
    }
}
