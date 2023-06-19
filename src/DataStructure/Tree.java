package DataStructure;

public class Tree<E> {
    public E element;
    public Tree<E> left, right;

    public Tree(E element) {
        this.element = element;
    }

    //前序遍历
    public static <T> void preOrder(Tree<T> root) {
        if (root == null) return;
        System.out.print(root.element);
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历
    public static <T> void inOrder(Tree<T> root) {
        if (root == null) return;
        inOrder(root.left);    //先完成全部左子树的遍历
        System.out.print(root.element);    //等待左子树遍历完成之后再打印
        inOrder(root.right);    //然后就是对右子树进行遍历
    }

    //后序遍历
    public static <T> void postOrder(Tree<T> root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.element);  //时机延迟到最后
    }
}
/*
import DataStructure.Tree;

import static DataStructure.LinkedinOrderQueue.levelOrder;
import static DataStructure.Tree.*;

public class Main {
    public static void main(String[] args) {
        Tree<Character> a = new Tree<>('A');
        Tree<Character> b = new Tree<>('B');
        Tree<Character> c = new Tree<>('C');
        Tree<Character> d = new Tree<>('D');
        Tree<Character> e = new Tree<>('E');
        Tree<Character> f = new Tree<>('F');
        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = f;

        System.out.print("前序遍历: ");
        preOrder(a);
        System.out.println();
        System.out.print("中序遍历: ");
        inOrder(a);
        System.out.println();
        System.out.print("后序遍历: ");
        postOrder(a);
        System.out.println();
        System.out.print("层序遍历: ");
        levelOrder(a);

    }
}

 */

