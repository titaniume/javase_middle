package cn.titanium.generic.wildcard;

import java.util.ArrayList;
import java.util.List;

public class Node<T extends Comparable<T>> {
 
    public Node<T> leftNode;
 
    public Node<T> rightNode;
 
    public T value;
 
    public void add(T t) {
 
        if (null == value)
            value = t;
 
        else {
 
            //t和value都是T 类型，而T类型extends Comparable，所以必然提供compare接口
            if (t.compareTo(value) <= 0) {
                if (null == leftNode)
                    leftNode = new Node<T>();
                leftNode.add(t);
            }
 
            else {
                if (null == rightNode)
                    rightNode = new Node<T>();
                rightNode.add(t);
            }
 
        }
 
    }
 
    public List<T> values() {
        List<T> values = new ArrayList<>();
 
        if (null != leftNode)
            values.addAll(leftNode.values());
 
        values.add(value);
 
        if (null != rightNode)
 
            values.addAll(rightNode.values());
 
        return values;
    }
 
    public static void main(String[] args) {
 
        int randoms[] = new int[] { 67, 7, 30, 73, 10, 0, 78, 81, 10, 74 };
 
        Node<Integer> roots = new Node<>();
        for (int number : randoms) {
            roots.add(number);
        }
 
        System.out.println(roots.values());
         
        //Hero实现了 Comparable接口，所以可以作为Node的泛型
        Node<Hero2> heros = new Node<>();
         
        //Item 没有实现 Comparable接口，所以不能作为Node的泛型
      //  Node<Item> dragons = new Node<>();
         
    }
}