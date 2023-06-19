package DataStructure;

import java.util.Stack;

public class LinkNodeReverse {
    public static void main(String[] args) {
        System.out.println(LinkNodeReverse.isValid("({})"));
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;//创建两个指针, prev是前一个指针
        while (curr != null) {
            ListNode temp = curr.next;//创建临时temp节点,用于存放当前节点指向的下一位置
            curr.next = prev;//将当前节点的指针指向上一节点
            prev = curr;//将prev往后移动到curr
            curr = temp;//将curr节点往后移动;用temp临时节点赋值
        }
        return prev;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {//如果当前栈为空则压入
                stack.push(s.charAt(i));
            }
            else {
                if (s.charAt(i) == ')' && stack.peek() == '(') {//peek返回栈顶元素但不删除;此时i已经i++了
                    stack.pop();
                } else if (s.charAt(i) == ']' && stack.peek() == '[') {
                    stack.pop();
                } else if (s.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}
