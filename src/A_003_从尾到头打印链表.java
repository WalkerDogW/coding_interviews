import comm.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * @author Tao
 * @create 2020/6/19 11:43
 */
public class A_003_从尾到头打印链表 {
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //解法一：栈，先入后出
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;


    }

    public static ArrayList<Integer> result = new ArrayList<>();

    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        //解法二：递归
        if (listNode != null) {
            printListFromTailToHead2(listNode.next);
            result.add(listNode.val);
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        head.next = next;
        ListNode nextt = new ListNode(3);
        next.next = nextt;
        System.out.println(printListFromTailToHead(head));
        System.out.println(printListFromTailToHead2(head));
    }
}



