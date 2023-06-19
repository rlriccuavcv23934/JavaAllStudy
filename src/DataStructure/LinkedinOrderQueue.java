package DataStructure;

import java.util.NoSuchElementException;
//层序遍历
public class LinkedinOrderQueue<E> {

    private final Node<E> head = new Node<>(null);

    public void offer(E element) {
        Node<E> last = head;
        while (last.next != null)
            last = last.next;
        last.next = new Node<>(element);
    }

    public E poll() {
        if (head.next == null)
            throw new NoSuchElementException("队列为空");
        E e = head.next.element;
        head.next = head.next.next;
        return e;
    }

    public boolean isEmpty() {   //这里多写了一个判断队列为空的操作，方便之后使用
        return head.next == null;   //直接看头结点后面还有没有东西就行了
    }

    private class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }

    public static <T> void levelOrder(Tree<T> root) {
        LinkedinOrderQueue<Tree<T>> queue = new LinkedinOrderQueue<>();  //创建一个队列
        queue.offer(root);    //将根结点丢进队列
        while (!queue.isEmpty()) {   //如果队列不为空，就一直不断地取出来
            Tree<T> node = queue.poll();   //取一个出来
            System.out.print(node.element);  //打印
            if (node.left != null) queue.offer(node.left);   //如果左右孩子不为空，直接将左右孩子丢进队列
            if (node.right != null) queue.offer(node.right);
        }
    }
    /*
    上面这段代码是一个实现LinkedQueue的静态类，实现了队列的基本操作offer(添加元素)、poll(取出元素)和isEmpty(判断队列是否为空)。
    LinkedQueue类中也实现了一个levelOrder方法，用于实现树的层序遍历，它首先创建一个队列，
    然后将根结点放进队列中，然后判断队列是否为空，不为空则取出一个结点，
    并打印，然后判断左右孩子是否为空，不为空就放进队列中，重复这个过程直到队列为空。
     */
}
