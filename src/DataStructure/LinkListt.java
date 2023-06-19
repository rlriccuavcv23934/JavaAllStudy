package DataStructure;

public class LinkListt<E> {

    private final Node<E> head = new Node<>(null);//链表的头结点，用于连接之后的所有结点
    private int size = 0;   //当前的元素数量还是要存一下，方便后面操作

    private static class Node<E> {  //结点类，仅供内部使用
        E element;   //每个结点都存放元素
        Node<E> next;   //指向下一个结点的引用

        public Node(E element) {//下一节点的元素;通过构造函数赋值
            this.element = element;
        }
    }

    //插入
    public void add(E element, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("插入位置非法，合法的插入位置为：0 ~ " + size);
        Node<E> prev = head;   //先找到对应位置的前驱结点
        for (int i = 0; i < index; i++)
            prev = prev.next;
        Node<E> node = new Node<>(element);   //创建新的结点
        node.next = prev.next;   //先让新的节点指向原本在这个位置上的结点
        prev.next = node;   //然后让前驱结点指向当前结点
        size++;   //完事之后一样的，更新size
    }

    //删除
    public E remove(int index) {
        if (index < 0 || index > size - 1)   //同样的，先判断位置是否合法
            throw new IndexOutOfBoundsException("删除位置非法，合法的删除位置为：0 ~ " + (size - 1));
        Node<E> prev = head;
        for (int i = 0; i < index; i++)   //同样需要先找到前驱结点
            prev = prev.next;
        E e = prev.next.element;   //先把待删除结点存放的元素取出来
        prev.next = prev.next.next;  //可以删了
        size--;   //记得size--
        return e;
    }

    //更新
    public void setElement(int index, E e) {
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("更新位置非法，合法的删除位置为：0 ~ " + (size - 1));
        //获取指定位置的原节点
        Node<E> node = head;
        //同样需要先找到前驱结点
        for (int i = 0; i < index; i++) node = node.next;//需要到达更新节点的前一节点
        node.next.element = e;
    }


    //查询
    public E getElement(int index) {
        if (index < 0 || index > size - 1)
            throw new IndexOutOfBoundsException("非法的位置，合法的位置为：0 ~ " + (size - 1));
        Node<E> node = head;
        while (index-- >= 0)   //这里直接让index减到-1为止
            node = node.next;
        return node.element;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("链表长度: ").append(getSize()).append(" ");

        Node<E> node = head.next;   //从第一个结点开始，一个一个遍历，遍历一个就拼接到字符串上去
        builder.append("链表元素: ").append(" ");
        while (node != null) {
            builder.append(node.element).append(" ");
            node = node.next;
        }
        return builder.toString();
    }
}
/*
import ClassStudy.LinkListt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkListt<Integer> link = new LinkListt<>();
        link.add(10, 0);
        link.add(20, 1);
        link.add(30, 2);
        link.add(40, 3);
        System.out.println("插入后: " + link);
        link.remove(2);
        System.out.println("删除后: " + link);
        link.setElement(0, 50);
        System.out.println("更新后: " + link);
        System.out.print("输入查询的节点位置: ");
        int index = input.nextInt();
        System.out.println("查询节点的元素: " + link.getElement(index));
    }
}
 */

