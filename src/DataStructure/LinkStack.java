package DataStructure;

import java.util.NoSuchElementException;

public class LinkStack<E> {

    private final Node<E> head = new Node<>(null);   //大体内容跟链表类似

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    //推入操作
    public void push(E element) {
        Node<E> node = new Node<>(element);   //直接创建新结点
        node.next = head.next;    //新结点的下一个变成原本的栈顶结点
        head.next = node;     //头结点的下一个改成新的结点
    }

    //推出操作
    public E pop() {
        if (head.next == null)   //如果栈已经没有元素了，那么肯定是没办法取的
            throw new NoSuchElementException("栈已经为空");
        E e = head.next.element;   //先把待出栈顶元素取出来
        head.next = head.next.next;   //直接让头结点的下一个指向下一个的下一个
        return e;
    }
}
/*
import ClassStudy.LinkStack;

public class Main {
    public static void main(String[] args) {
        LinkStack<String> stack = new LinkStack<>();
        stack.push("AA");
        stack.push("BBB");
        stack.push("CCeC");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
 */

