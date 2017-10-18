package cn.titanium.generic.standbyclass;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用泛型二叉树排序
 * 但是这样的泛型有个弊端，在比较的时候，泛型T被转换为了Integer进行大小比较。换句话说，如果写成非Integer泛型，就会出现类型转换异常
 * @author Administrator
 *2017年10月18日上午11:08:13
 * @param <T>
 */
public class Node<T> {
	// 左子节点
    public Node<T> leftNode;
    // 右子节点
    public Node<T> rightNode;
  
    // 值
    public T value;
  
    // 插入 数据
    public void add(T t) {
        // 如果当前节点没有值，就把数据放在当前节点上
        if (null == value)
            value = t;
  
        // 如果当前节点有值，就进行判断，新增的值与当前值的大小关系
        else {
            // 新增的值，比当前值小或者相同
             
            if ((Integer) t -((Integer)value) <= 0) {
                if (null == leftNode)
                    leftNode = new Node<T>();
                leftNode.add(t);
            }
            // 新增的值，比当前值大
            else {
                if (null == rightNode)
                    rightNode = new Node<T>();
                rightNode.add(t);
            }
  
        }
  
    }
  
 // 中序遍历所有的节点
    public List<T> values() {
        List<T> values = new ArrayList<>();
  
        // 左节点的遍历结果
        if (null != leftNode)
            values.addAll(leftNode.values());
  
        // 当前节点
        values.add(value);
  
        // 右节点的遍历结果
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
  
    }
}
